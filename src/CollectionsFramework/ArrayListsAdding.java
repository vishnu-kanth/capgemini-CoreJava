package CollectionsFramework;

import java.util.ArrayList;

class Student {
	String name;
	int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return "Student Name: "+ name +  "Student Age:  " + age;
	}
}

public class ArrayListsAdding {
	public static void main(String[] args) {
		ArrayList students = new ArrayList();
		students.add(new Student(" Vishnu", 21));
		students.add(new Student(" Varun", 22));
		System.out.println(students);
	}
}
