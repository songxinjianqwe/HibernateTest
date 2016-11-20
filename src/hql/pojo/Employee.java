package hql.pojo;

public class Employee {

	private Integer id;
	private String name;
	private float salary;
	private String email;

	private Department dept;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", email=" + email + ", dept=" + dept
				+ "]";
	}

	public Employee(String email, float salary, Department dept) {
		super();
		this.salary = salary;
		this.email = email;
		this.dept = dept;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, float salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

}