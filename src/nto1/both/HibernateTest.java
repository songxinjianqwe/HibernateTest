package nto1.both;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
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
	public void testManyToOneBoth(){
		UserPO user = new UserPO("admin6","admin6","123123","heheda",3000,3,UserType.Normal);
		OrderPO order1 = new OrderPO(new Date(),new Date(),new Date(),OrderStatus.Unexecuted,1,300,RoomType.Deluxe,2,user);
		OrderPO order2 = new OrderPO(new Date(),new Date(),new Date(),OrderStatus.Unexecuted,1,300,RoomType.Deluxe,2,user);
		user.getOrders().add(order1);
		user.getOrders().add(order2);
		session.save(user);
		session.save(order1);
		session.save(order2);
		//��ִ������insert������update���
		//�Ȳ���Order�ٲ���User��������insert������update
	}
	@Test
	public void testManyToOneBothGet(){
		UserPO user = session.get(UserPO.class, 1);
		System.out.println(user.getUsername());
		//��ѯ1��һ��ʱ�����һ���ļ��ϻ��ӳټ��أ�����δ����ʱ��ʵ������һ������ļ���
		//�����;����ӳټ��غʹ�Ŵ��������
		//ֱ������ʱ����������
		System.out.println(user.getOrders());
		
	}
	
	@After
	public void tearDown() throws Exception {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
