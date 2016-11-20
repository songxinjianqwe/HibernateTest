package nto1;

import java.util.Date;

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
	public void testManyToOneSave(){
		UserPO user = new UserPO("admin4","admin4","231231231","呵呵",230,1,UserType.Normal);
		OrderPO order = new OrderPO(new Date(),new Date(),new Date(),OrderStatus.Unexecuted,1,400,RoomType.Single,1,user);
		//先保存一这一方的
		session.save(user);
		//再保存多这一方的
		session.save(order);
		//反之亦可，但是会多出一条update语句，来更新多这一方的id
	}
	
	@Test
	public void testManyToOneGet(){
		OrderPO order = session.get(OrderPO.class, 10);
		//如果只查询多的一端的对象，则默认情况下只查询了多的一端的对象，而没有查询关联的1的一端的对象
		//但是当访问的时候，会将1的一端的对象查询出来 (延迟加载)
		System.out.println(order.getUser().getUsername());
	}

	
	@After
	public void tearDown() throws Exception {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
