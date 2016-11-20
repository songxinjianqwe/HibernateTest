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
		//���������������Ҫ����������¼
	}
	//��̬��ѯ
	@Test
	public void testGet(){
		//��ѯ����������
		List<Person> list = session.createQuery("from Person ").getResultList();
		System.out.println(list);
		//��ѯĳ������
		List<Student> students = session.createQuery("from Student").getResultList();
		System.out.println(students);
		//��Ҫ�������ű���в��룬ʹ��һ���������Ӳ�ѯ��һ���ڲ�ѯ
	}
	
	@After
	public void tearDown() throws Exception {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
