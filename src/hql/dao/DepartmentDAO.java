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
		dept.setName("����");
		dao.save(dept);
		dept.setName("����");
		dao.save(dept);
		dept.setName("����");
		dao.save(dept);
		transaction.commit();
		System.out.println(session.isOpen());
		/**
		 * ���ύ/�ع�����ʱ���Զ��رյ�ǰ�̵߳�Session
		 * ֻ��Ҫ�����������Լ�ȥ���Ĺر�
		 */
	}
}
