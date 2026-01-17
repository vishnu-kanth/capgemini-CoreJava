package CollectionsFramework;
import java.util.ArrayList;

public class ArrayLists {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(10);
		al.add(20);
		al.add(25);
		al.add(30);
		al.add(35);
		al.add(40);
		al.add("Hello");
		al.add(null);
		al.add(0,50);
		System.out.println(al);
		
		ArrayList al1 = new ArrayList();
		al1.add(15);
		al1.add(33);
		al1.add(38);
		al1.add(42);
		al1.addAll(4,al);
		System.out.println(al1);
		
		
		
	}

}
