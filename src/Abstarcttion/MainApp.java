package Abstarcttion;

public class MainApp {
	public static void main(String[] args) {
		Animal a = new Dog();
		a.walk();
		a.sound();
		
		Teacher t = new Student();
		t.teaching();
		t.section();
	}
}
