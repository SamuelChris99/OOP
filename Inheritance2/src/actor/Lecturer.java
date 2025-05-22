package actor;
import academic.Course;
import java.util.*;

public class Lecturer extends Person implements IAttendee {
	private String lectureCode;
	private List<Course> courses = new ArrayList<>();
	
	public Lecturer(String lectureCode, String name, String dob) {
		super(name, dob);
		this.lectureCode = lectureCode;
	}

	public String getLectureCode() {
		return lectureCode;
	}

	public void setLectureCode(String lectureCode) {
		this.lectureCode = lectureCode;
	} 
	
	public void addCourse(Course course) {
		courses.add(course);
	}

	@Override
	public void takeAttendance() {
		System.out.println(name+" is verifying attendance");
	}
	
	public void showCourse(int i) {
		System.out.println("\n"+name+ "is teaching: ");
		for(Course course: courses) {
			if(course.getCredit() == i) {
				System.out.println(" - "+course.getCourseName());
			}
		}
	}
	
}