package edu.bellevue.cis530.week02.model;

public class Student {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String courseCode;
	private String semester;

	public Student() {
	}

	public Student(Long id, String firstName, String lastName, String email, String courseCode, String semester) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courseCode = courseCode;
		this.semester = semester;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", courseCode='" + courseCode + '\'' +
				", semester='" + semester + '\'' +
				'}';
	}
}