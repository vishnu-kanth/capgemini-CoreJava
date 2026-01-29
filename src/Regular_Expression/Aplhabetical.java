package Regular_Expression;

public class Aplhabetical {
	public static void main(String[] args) {
		
		String s = "abc";
		System.out.println(s.matches("[a-z]+"));
		
		String s1 = "ABC";
		System.out.println(s1.matches("[A-Z]+"));
		
		String s2 = "AbcBcvG";
		System.out.println(s2.matches("^[a-zA-Z]+$"));
		
		String s3 = "Vishnu31";
		System.out.println(s3.matches("[a-zA-Z0-9]+"));
		
		String s4 = "vishnu@gmail.com";
		System.out.println(s4.matches("[a-z0-9]+@gmail\\.com"));
		
	}

}
