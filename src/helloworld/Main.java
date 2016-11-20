package helloworld;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
	public void test() {
		SessionFactory factory = null;
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder()
				.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
		factory = metadata.getSessionFactoryBuilder().build();
		// 创建SessionFactory

		// 创建Session
		Session session = factory.openSession();

		// 打开事务
		Transaction trans = session.beginTransaction();

		// 创建对象
		UserPO user = new UserPO("admin2", "admin2", "231231", "NewSong", 230, new Date(new java.util.Date().getTime()),
				"NJU", 1, UserType.Normal);

		// 保存对象
		// session.save(user);
		user = session.get(UserPO.class, 1);
		System.out.println(user);

		// 提交事务
		trans.commit();

		// 关闭session
		session.close();

		// 关闭SessionFactory
		factory.close();
	}

	public static void main(String[] args) {
		new Main().test();
	}
}
