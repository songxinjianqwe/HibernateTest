package joinedsubclass;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class HibernateTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void setUp() throws Exception {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder()
				.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	@Test
	public void testSave(){
		Person person = new Person("NewSong",20);
		Student s = new Student("Cheng2",10);
		s.setSchool("NJU");
		session.save(person);
		session.save(s);
		//插入子类的数据需要插入两条记录
	}
	//多态查询
	@Test
	public void testGet(){
		//查询父类与子类
		List<Person> list = session.createQuery("from Person ").getResultList();
		System.out.println(list);
		//查询某个子类
		List<Student> students = session.createQuery("from Student").getResultList();
		System.out.println(students);
		//需要连接两张表进行插入，使用一个左外连接查询和一个内查询
	}
	
	@After
	public void tearDown() throws Exception {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
