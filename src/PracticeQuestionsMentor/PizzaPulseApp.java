package PracticeQuestionsMentor;

import java.util.Scanner;

class InvalidPizzaOrderException extends Exception {
    public InvalidPizzaOrderException(String message) {
        super(message);
    }
}

class PizzaUtil {

    public boolean validateOrderId(String orderId) throws InvalidPizzaOrderException {
        if (!orderId.matches("PZ-\\d{3}"))
            throw new InvalidPizzaOrderException("The order ID " + orderId + " is invalid");
        return true;
    }

    public boolean validatePizzaType(String pizzaType) throws InvalidPizzaOrderException {
        if (!(pizzaType.equals("Margherita") ||
              pizzaType.equals("Pepperoni") ||
              pizzaType.equals("Veggie") ||
              pizzaType.equals("BBQ Chicken")))
            throw new InvalidPizzaOrderException("The pizza type " + pizzaType + " is invalid");
        return true;
    }

    public boolean validateQuantity(int quantity) throws InvalidPizzaOrderException {
        if (quantity <= 0 || quantity > 50)
            throw new InvalidPizzaOrderException("The quantity " + quantity + " is invalid");
        return true;
    }

    public double calculateFinalBill(String pizzaType, double basePrice, int quantity)
            throws InvalidPizzaOrderException {

        if (basePrice < 200)
            throw new InvalidPizzaOrderException("Invalid base price for " + pizzaType);

        double toppingPercent = 0;

        if (pizzaType.equals("Margherita"))
            toppingPercent = 10;
        else if (pizzaType.equals("Pepperoni"))
            toppingPercent = 20;
        else if (pizzaType.equals("Veggie"))
            toppingPercent = 15;
        else if (pizzaType.equals("BBQ Chicken"))
            toppingPercent = 25;

        double baseCost = basePrice * quantity;
        double toppingCharge = (baseCost * toppingPercent) / 100;
        double deliveryFee = 100;

        return baseCost + toppingCharge + deliveryFee;
    }
}

public class PizzaPulseApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PizzaUtil util = new PizzaUtil();

        try {
            System.out.println("Enter pizza order details");
            String input = sc.nextLine();

            String[] data = input.split(":");

            String orderId = data[0];
            String pizzaType = data[1];
            double basePrice = Double.parseDouble(data[2]);
            int quantity = Integer.parseInt(data[3]);

            util.validateOrderId(orderId);
            util.validatePizzaType(pizzaType);
            util.validateQuantity(quantity);

            double bill = util.calculateFinalBill(pizzaType, basePrice, quantity);

            System.out.println("Total bill for " + pizzaType + " pizzas: " + bill);

        } catch (InvalidPizzaOrderException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
