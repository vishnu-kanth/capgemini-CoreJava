package CollectionsFramework;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class customList {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(10);
		al.add(20);
		System.out.println(al);
		
		//get (index)
		for(int i = 0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
		
		//for each
		for(Object o:al) {
			System.out.println(o);
		}
		
		//iterator
		
		Iterator i = al.iterator();
		System.out.println(i.next());
		System.out.println(i.next());
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		//ListIterator
		
		ListIterator i1 = al.listIterator();
		while(i1.hasNext()) {
			System.out.println(i1.next());
		}
		while(i1.hasPrevious()) {
			System.out.println(i1.previous());
		}
	}

}
