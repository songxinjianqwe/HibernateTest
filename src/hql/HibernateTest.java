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
		// ��дHQL
		// ����Query
		// �󶨲���(����λ�õĲ���)��֧����ʽ���
		// ִ�в�ѯ
		//ע��HQL�г��ֵ��ǲ������ݱ��е��ֶκͱ���������������������
		//�������û������ͣ������������ö����������id���㹻�ˣ�
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
		// ����ռλ��֮�⣬������ʹ����������
		//��ð�ţ�������ϱ�����
		//set����ʱ����һ������Ϊ���������ڶ���������ֵ
		String hql = "from Employee e where e.id < :maxID and e.name like :name";
		Query<Employee> query = session.createQuery(hql);
		query.setParameter("maxID", 6).setParameter("name", "%С%");
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
		//ע����Ҫ��Ӧ�Ĺ��췽��
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
		//һ�㶼Ӧ��ȥ��
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
		//�������������ӵ������ǣ�ֻ�е���������Ӧ��һ�Զ�����ʱ����ִ�в�ѯ���
		//���������������ǲ�ѯһ��һ��ʱ�����һ�������Ծ��Ѿ���ѯ������
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
