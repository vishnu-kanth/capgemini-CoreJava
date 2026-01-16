package WrapperClass;

public class UnBoxing {
	public static void main(String[] args) {
		// Boxing
		int a = 10;
		Integer i = Integer.valueOf(a);

		// UnBoxing
		int b = i.intValue();
		System.out.println(b);

		// Byte Boxing
		byte b1 = 50;
		Byte b2 = Byte.valueOf(b1);
		// Unboxing Byte

		byte c = b2.byteValue();
		System.out.println(c);

		// AutoBoxing

		int s = 77;
		Integer d = s;
		int f = d;
		System.out.println(f);
	}
}
