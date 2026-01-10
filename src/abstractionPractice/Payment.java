package abstractionPractice;

public class Payment {
	static abstract class paymentMethod{
		
	abstract void processPayment(double amount);
	
	public void printRecipt() {
		System.out.println("Payment Recipt");
	}
}
	static class UPI extends paymentMethod{
		void processPayment(double amount) {
			System.out.println("Recived "+amount+" on UPI");
		}
	}
	
	static class DebitCard extends paymentMethod{
		void processPayment (double amount) {
			System.out.println("Recived "+amount+" on DebitCard");
		}
	}
	
	public static void main(String[] args) {
		paymentMethod upi = new UPI();
		upi.processPayment(1000);
		upi.printRecipt();
		
		paymentMethod d = new DebitCard();
		d.processPayment(2880);
		d.printRecipt();
	} 
}

