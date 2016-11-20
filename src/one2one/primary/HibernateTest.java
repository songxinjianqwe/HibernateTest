package one2one.primary;

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
	public void test121(){
		LocationPO loc = new LocationPO(1,"南京");
		CommercialCirclePO circle = new CommercialCirclePO(1, loc, "仙林");
		HotelPO hotel = new HotelPO("仙林大酒店", 2, 3.3,loc , circle, "good", "nice");
		StaffPO staff = new StaffPO("admin7", "admin7", "呵呵", StaffType.HotelStaff, hotel);
		session.save(staff);
		session.save(hotel);
	}
	@Test
	public void test122(){
//		HotelPO hotel  = session.get(HotelPO.class, 1);
//		System.out.println(hotel.getName());
//		System.out.println(hotel.getStaff().getName());
		StaffPO staff =  session.get(StaffPO.class, 1);
		System.out.println(staff.getName());
//		System.out.println(staff.getHotel().getName());
		
	}
	
	@After
	public void tearDown() throws Exception {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
