package academic;

import java.util.*;

import actor.IAttendant;
import actor.IAttendee;
import actor.Lecturer;
import actor.Student;

public class Class {
	private String classCode, year;
	private int semester;
	
	private List<Course> courses = new ArrayList<>();
	private List<Student> students = new ArrayList<>();
	private List<Lecturer> lecturers = new ArrayList<>();
	private List<Student> attendances = new ArrayList<>();
	
	public Class(String classCode, int semester, String year) {
		super();
		this.classCode = classCode;
		this.year = year;
		this.semester = semester;
	}

	public void addCourse(Course co1) {
		courses.add(co1);
		System.out.println(co1.getCourseName()+" added to list");
	}

	public void addStudent(Student student) {
		students.add(student);
		for(Course course: courses) {
			student.addCourse(course);
		}
		System.out.println(student.getName()+" added to list");
	}

	public void addLecturer(Lecturer lec1, Course co1) {
		lecturers.add(lec1);
		lec1.addCourse(co1);
		System.out.println(lec1.getName()+" added to list");
	}

	public void attend(IAttendant attendant) {
		attendant.attend();
		if(attendant instanceof Student student) {
			attendances.add(student);
		}
	}

	public void takeAttendance(IAttendee attendee) {
		attendee.takeAttendance();
	}

	public void showTodayAttendance() {
		System.out.println("\nToday's attendance: ");
		for(Student student: attendances) {
			System.out.println(" "+student.getNim()+" - "+student.getName());
		}
	}
}