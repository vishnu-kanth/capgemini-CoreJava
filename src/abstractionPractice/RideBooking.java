package abstractionPractice;

public class RideBooking {
	static abstract class Ride {
		abstract int calculateFare(int distance);
		
		public void rideDetails(int x) {
			System.out.println("Your ride amount is: "+x);
		}
	}
	
	static class BikeRide extends Ride{
		int calculateFare(int distance ) {
			return distance *2;
		}
	}
	
	static class AutoRide extends Ride{
		int calculateFare(int distance) {
			return distance * (int)7.5;
		}
	}
	
	static class CarRide extends Ride{
		int calculateFare(int distance) {
			return distance * 3;
		}
	}
	
	public static void main(String[] args) {
		
		Ride br = new BikeRide();
		br.rideDetails(br.calculateFare(20));
		
		Ride ar = new AutoRide();
		ar.rideDetails(ar.calculateFare(25));
		
		Ride cr = new CarRide();
		cr.rideDetails(cr.calculateFare(50));
		
	}

}
