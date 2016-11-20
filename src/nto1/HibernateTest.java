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
		UserPO user = new UserPO("admin4","admin4","231231231","�Ǻ�",230,1,UserType.Normal);
		OrderPO order = new OrderPO(new Date(),new Date(),new Date(),OrderStatus.Unexecuted,1,400,RoomType.Single,1,user);
		//�ȱ���һ��һ����
		session.save(user);
		//�ٱ������һ����
		session.save(order);
		//��֮��ɣ����ǻ���һ��update��䣬�����¶���һ����id
	}
	
	@Test
	public void testManyToOneGet(){
		OrderPO order = session.get(OrderPO.class, 10);
		//���ֻ��ѯ���һ�˵Ķ�����Ĭ�������ֻ��ѯ�˶��һ�˵Ķ��󣬶�û�в�ѯ������1��һ�˵Ķ���
		//���ǵ����ʵ�ʱ�򣬻Ὣ1��һ�˵Ķ����ѯ���� (�ӳټ���)
		System.out.println(order.getUser().getUsername());
	}

	
	@After
	public void tearDown() throws Exception {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
