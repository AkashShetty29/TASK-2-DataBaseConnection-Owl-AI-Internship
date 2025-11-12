package entity;

public class Student {
	
	private int id;
	private String name;
	private String email;
	private int age;
	private String course;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(int id, String name, String email, int age, String course) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.course = course;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", course=" + course
				+ "]";
	}
	
    // Display format for table
    public String toTableRow() {
        return String.format("| %-3d | %-20s | %-25s | %-3d | %-20s |", 
                           id, name, email, age, course);
    }

}
