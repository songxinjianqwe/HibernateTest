package joinedsubclass;

public class Student extends Person{
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age) {
		super(name, age);
	}

	private String school;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
}
