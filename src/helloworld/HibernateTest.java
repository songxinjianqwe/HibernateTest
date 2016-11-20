package helloworld;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.jdbc.Work;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import mappingrelation.Pay;
import mappingrelation.Worker;


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
	public void testSessionCache(){
		UserPO u1 = session.get(UserPO.class, 3);
		UserPO u2 = session.get(UserPO.class, 3);
		System.out.println(u1);
		System.out.println(u2);
		//总共执行了一条select语句
	}
	
	@Test
	public void testUpdate(){
		UserPO user = session.get(UserPO.class, 1);
		user.setCredit(2300);
		session.update(user);
	}
	
	@Test
	public void testDelete(){
		UserPO user = new UserPO();
		user.setId(3);
		session.delete(user);
		
	}
	
	@Test
	public void testComponent(){
		Worker worker = new Worker();
		Pay pay = new Pay();
		pay.setMonthPay(5000);
		pay.setYearPay(80000);
		pay.setVacationWithPay(20);
		worker.setPay(pay);
		worker.setName("hehe");
		session.save(worker);
		
	}
	@Test
	public void testDoWork(){
		session.doWork(new Work(){

			@Override
			public void execute(Connection conn) throws SQLException {
				System.out.println(conn);
			}
		});
	}
	@After
	public void tearDown() throws Exception {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
