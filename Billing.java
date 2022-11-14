package Project;

import java.util.ArrayList;
import java.util.HashMap;

public class Billing {
	public double price(AdminClass admin, int id){
		for (ProductDetails arr: admin.getListOfProduct()) {
			if(arr.getProductid() == id)
				return arr.getProductPrice();
		}
		return 0.0;
	}
	
	public String getname(AdminClass admin, int id){
		for (ProductDetails arr: admin.getListOfProduct()) {
			if(arr.getProductid() == id)
				return arr.getProductName();
		}
		return "";
	}
	
	public void bill(AdminClass admin){
		
	
		Cart rahulCart = new Cart();
		HashMap<Integer, Integer> hashcart = rahulCart.cartManagement(admin);
		
		System.out.println(hashcart);
		
		double amount = 0.0;
		System.out.println("\nYour Purchase Items : ");
		System.out.println("------------------------------------------");
		System.out.println(String.format("|%-10s||%-10s||%-10s||%-10s|","PrdName","PrdQt","PrdPrice","PrdAmount"));
		System.out.println("---------------------------------------------------------------");
		for (Integer hmap: hashcart.keySet()){
			int quantity = hashcart.get(hmap);
			amount += (quantity * price(admin, hmap));
			System.out.println(String.format("|%-10s||%-10d||%-10s||%-10s|", getname(admin, hmap), quantity, String.format("%.2f",price(admin, hmap)), String.format("%.2f",amount)));
		}
		System.out.println("------------------------------------------");
		System.out.println("Total bill : Rs."+amount);
	}
}
