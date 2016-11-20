package many2many;

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
	public void testMany2ManySave(){
		Category c1 = new Category("C_A");
		Category c2 = new Category("C_B");
		Item i1 = new Item("I_A");
		Item i2 = new Item("I_B");
		
		//设定关联关系
		c1.getItems().add(i1);
		c1.getItems().add(i2);
	
		c2.getItems().add(i1);
		c2.getItems().add(i2);
		
		session.save(c1);
		session.save(c2);
		
		session.save(i1);
		session.save(i2);
	}
	@Test
	public void testGet(){
		Category cate = session.get(Category.class, 1);
		System.out.println(cate.getName());
		System.out.println(cate.getItems().size());
	}
	@After
	public void tearDown() throws Exception {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
