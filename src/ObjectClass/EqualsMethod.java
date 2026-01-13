package ObjectClass;

public class EqualsMethod {
	
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
	}
	public static void main(String[] args) {
		Student s1 = new Student("Vishnu",21);
		Student s2 = new Student("Vishnu",21);
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
	}
}
