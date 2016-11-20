package hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hql.dao.DepartmentDAO;
import hql.pojo.Department;
import hql.pojo.Employee;

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
	public void test() {
		// 编写HQL
		// 创建Query
		// 绑定参数(基于位置的参数)，支持链式编程
		// 执行查询
		//注意HQL中出现的是不是数据表中的字段和表名，而是类名和属性名
		//除了设置基础类型，还还可以设置对象参数（有id就足够了）
		Department dept = new Department();
		dept.setId(1);
		String hql = "from Employee e where e.id < ? and e.dept = ?";
		Query<Employee> query = session.createQuery(hql);
		query.setParameter(0, 100).setParameter(1, dept);
		List<Employee> emps = query.getResultList();
		System.out.println(emps.size());

	}

	@Test
	public void test2() {
		// 除了占位符之外，还可以使用命名参数
		//用冒号，后面加上变量名
		//set参数时，第一个参数为变量名，第二个参数是值
		String hql = "from Employee e where e.id < :maxID and e.name like :name";
		Query<Employee> query = session.createQuery(hql);
		query.setParameter("maxID", 6).setParameter("name", "%小%");
		List<Employee> emps = query.getResultList();
		System.out.println(emps.size());
	}
	@Test
	public void testPageQuery(){
		String hql = "from Employee";
		Query<Employee> query  = session.createQuery(hql);
		int pageNo = 2;
		int pageSize =  4;
		List<Employee> emps = query.setFirstResult(pageSize*(pageNo-1)).setMaxResults(pageSize).getResultList();
		for(Employee e:emps){
			System.out.println(e);
		}
	}
	
	@Test
	public void testNamedQuery(){
		Query<Employee> query = session.createNamedQuery("salaryEmps");
		List<Employee> emps = query.setParameter("minSal", 3200F)
			 .setParameter("maxSal", 3600F).getResultList();
		for(Employee e:emps){
			System.out.println(e);
		}
	}
	
	@Test
	public void testFieldQuery(){
		//注意需要相应的构造方法
		String hql = "select new Employee(e.name,e.salary) from Employee e where e.dept = :dept";
		Department dept = new Department();
		dept.setId(2);
		Query<Employee> query  = session.createQuery(hql);
		List<Employee> emps = query.setParameter("dept",dept).getResultList();
		for(Employee e:emps){
			System.out.println(e);
		}
	}
	@Test
	public void testLeftJoinFetch(){
		//一般都应该去重
		String hql = "select distinct d from Department d left join fetch d.emps";
		Query<Department> query = session.createQuery(hql);
		List<Department> depts = query.getResultList();
		for(Department d:depts){
			System.out.println(d +  "-"+ d.getEmps().size());
		}
	}
	
	@Test
	public void testLeftJoin(){
		String hql = "select distinct d from Department d left join d.emps";
		List<Department> depts = session.createQuery(hql).getResultList();
		for(Department d:depts){
			System.out.println(d +  "-"+ d.getEmps().size());
		}
		//与迫切左外连接的区别是，只有当访问所对应的一对多属性时，才执行查询语句
		//而迫切左外连接是查询一的一方时，多的一方的属性就已经查询出来了
	}
	
	@Test
	public void testManageSession(){
		
		
	}
	@After
	public void tearDown() throws Exception {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
