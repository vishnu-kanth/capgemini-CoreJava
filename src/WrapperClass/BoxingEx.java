package WrapperClass;

public class BoxingEx {
	public static void main(String[] args) {
		
		//Boxing
		
		int i = 10;
		Integer a = new Integer(i);
		System.out.println(a);
		
		int b = 20;
		Integer c = Integer.valueOf(b);
		System.out.println(c);
		
		//AutoBoxing
		
		int x = 30;
		Integer y = x;
		System.out.println(y);
	}

}
