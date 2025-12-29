package oops;

public class Demo {
	String name;
	Demo(String name)
	{
		this.name = name;
	}
	public static void main(String[] args) {
		Demo d = new Demo("Vishnu Kanth");
		System.out.println(d.name);
	}

}