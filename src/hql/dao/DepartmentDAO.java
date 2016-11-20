package hql.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import hql.HibernateUtils;
import hql.pojo.Department;

public class DepartmentDAO {
	public void save(Department department) {
		Session session = HibernateUtils.getInstance().getSession();
		System.out.println(session.hashCode());
		session.save(department);
	}
	public static void main(String[] args) {
		Session session = HibernateUtils.getInstance().getSession();
		Transaction transaction  = session.beginTransaction();
		DepartmentDAO dao = new DepartmentDAO();
		Department dept = new Department();
		dept.setName("哈哈");
		dao.save(dept);
		dept.setName("嘻嘻");
		dao.save(dept);
		dept.setName("呼呼");
		dao.save(dept);
		transaction.commit();
		System.out.println(session.isOpen());
		/**
		 * 当提交/回滚事务时，自动关闭当前线程的Session
		 * 只需要开启，不必自己去关心关闭
		 */
	}
}
