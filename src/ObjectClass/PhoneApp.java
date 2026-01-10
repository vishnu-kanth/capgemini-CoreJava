package ObjectClass;

public class PhoneApp {
	public static void main(String[] args) {
		Box b1 = new Box();
		System.out.println(b1.toString());
		Phone p = new Phone(128,256);
		System.out.println(p);
	}
	

}
class Box{
	int price;
	public String toString() {
		return "Price : "+price;
	}
}
class Phone{
	int ram;
	int rom;
	Phone(int ram,int rom){
		this.ram = ram;
		this.rom = rom;
		
		
	}
	public String toString() {
		return "Phone : [Ram: "+ram+" Rom: "+rom+"]";
	}
}
