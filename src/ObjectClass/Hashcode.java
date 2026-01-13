package ObjectClass;

import ObjectClass.Hashcode.Student;

public class Hashcode {
	
	static class Student{
		String name;
		int age;
		
		public Student(String name,int age) {
			this.name = name;
			this.age = age;
		}
		
		public String toString() {
			return "Student: " +name+ "Student age: " +age;
		}
		public boolean equals(Student obj) {
			return this.name ==obj.name && this.age== obj.age;
		}
	
	public int hashCode() {

		return this.name.hashCode()+age;
	}
	}
	public static void main(String[] args) {
		Student s1 = new Student("Vishnu",22);
		Student s2 = new Student("Vishnu",22);
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s1.hashCode()==s2.hashCode());
	}
}
