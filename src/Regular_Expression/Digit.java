package Regular_Expression;

public class Digit {
	public static void main(String[] args) {
		
		// checks only for one digit - \\d
		String s = "1";
		System.out.println(s.matches("\\d"));
		
		// checks only for one or more digit - \\d+
		String s1 = "123";
		System.out.println(s1.matches("\\d+"));
		
		// checks for empty and one digit - \\d*
		String s2 = "";
		System.out.println(s2.matches("\\d*"));
		
		// checks for starting to end of digit - ^\\d+$
		String s3 = "4567a";
		System.out.println(s3.matches("^\\d+$"));
		
		// checks only for exact one digits - \\d{5}
		String s4 = "23456";
		System.out.println(s4.matches("\\d{5}"));
		
		// checks only for String range - \\d{4,8}
		
		String s5 = "23232323";
		System.out.println(s5.matches("\\d{3,9}"));
		
		// checks only for decimal values - \\d+\\.\\$
		
		String s6 = "23.00";
		System.out.println(s6.matches("\\d+\\.\\d+"));
		
	}

}
