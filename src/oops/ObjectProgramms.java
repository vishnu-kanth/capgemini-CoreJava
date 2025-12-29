package oops;

public class ObjectProgramms {
	static class Box{
		double length;
		double breadth;
		
		Box(double length,double breadth){
			this.length=length;
			this.breadth=breadth;
		}
		double calArea(){
			return length*breadth;
		}
	}
	public static void main(String[] args) {
		Box b1 = new Box(15.0 ,16.0);
		System.out.println(b1.calArea());
	}
}
