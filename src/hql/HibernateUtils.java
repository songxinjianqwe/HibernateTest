package hql;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;import hql.pojo.Department;

public class HibernateUtils {
	/**
	 * µ¥ÀýÄ£Ê½
	 */
	private HibernateUtils(){}
	private static HibernateUtils instance = new HibernateUtils();
	
	public static HibernateUtils getInstance(){
		return instance;
	}
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
			Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder()
					.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}
	
	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
}
