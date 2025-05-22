package actor;

import java.util.*;

import academic.Course;

public class Student extends Person implements IAttendant {
	private String nim;
	private List<Course> courses = new ArrayList<>();
	
	public Student(String nim, String name, String dob) {
		super(name, dob);
		this.nim = nim;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	@Override
	public void attend() {
		System.out.println(name+" is attending the class");
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}

	public void showCredits(int i) {
		int totalCredits = 0;
		System.out.println("\n"+name+"'s credit for semester "+i);
		for(Course course : courses) {
			if(course.getCredit() == i) {
				System.out.println(" - "+course.getCourseName());
				totalCredits += course.getCredit();
			}
		}
		System.out.println("Total credit: "+totalCredits);
	}
}