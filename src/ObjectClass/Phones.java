package ObjectClass;

public class Phones{
	static class phone{
	String brand;
	int price;
	
	phone(String brand,int price){
		this.brand=brand;
		this.price =price;
	}
	public String toString() {
		return "Brand: " +brand+ ",Price:" +price;
	}
}
	public static void main(String[] args) {
		phone[] phones = {new phone("Iphone", 70000),new phone("Samsungs26", 1250000), new phone("OnePlus 13", 65000)};
		for(int i =0;i<phones.length;i++) {
			System.out.println(phones[i]);
		}
	}
}

