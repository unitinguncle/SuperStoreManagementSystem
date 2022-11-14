package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminClass{
	ArrayList<ProductDetails> listOfProduct = new ArrayList<ProductDetails>();
	Scanner scan = new Scanner(System.in);
	
	public ArrayList<ProductDetails> getListOfProduct() {
		return listOfProduct;
	}
	
	public boolean isProductNew(int productid) {
		for (ProductDetails list : listOfProduct) {
			if(list.getProductid() == productid)
				return false;
		}
		return true;
	}
	
	public void addProducts() {
		while(true) {	
			ProductDetails prd = new ProductDetails();
			System.out.println("Enter Product id - ");
			int prdid = scan.nextInt();
			if(isProductNew(prdid)){
				prd.setProductid(prdid);
				System.out.println("Enter Product name - ");
				prd.setProductName(scan.next());
				System.out.println("Enter Product price per unit - ");
				prd.setProductPrice(scan.nextDouble());
				System.out.println("Enter Product Quantity to add - ");
				prd.setProductStock(scan.nextInt());
				System.out.println("Enter Product Expiry date - ");
				prd.setProductExpiry(scan.next());
				listOfProduct.add(prd);
				System.out.println("Product " + prd.getProductid() + " added successfully.");
				System.out.println("Enter 0 to exit or any number to add more products. ");
				if(scan.nextInt() == 0)
					break;
			}else{
				System.out.println("Product already exists");
				System.out.println("Enter product quantity to be added : ");
				prd.setProductStock(prd.getProductStock() + scan.nextInt());
				System.out.println("Product " + prd.getProductid() + " added successfully.");
				System.out.println("Enter 0 to exit or any number to add more products. ");
				if(scan.nextInt() == 0)
					break;
			}//else
		}//end of while
			
		}//addProducts()
	
	public String removeProduct() {
		System.out.println("Enter Product id - ");
		int prdid = scan.nextInt();
		if (isProductNew(prdid)){
			return "Product Doesn't Exists in your Inventory.";
		}
		else{
			for (ProductDetails list : listOfProduct) {
				if(list.getProductid() == prdid){
					listOfProduct.remove(list);
					return "Product Removed Successfully. ";
				}
			}
		}
		return "Product Doesn't Exists in your Inventory.";
	}//removeProduct()
	
	public void editProducts() {
		while(true) {	
			System.out.println("Enter Product id - ");
			int prdid = scan.nextInt();
			if(!isProductNew(prdid)){
				for (ProductDetails list : listOfProduct) {
					if(list.getProductid() == prdid){
						System.out.println("Enter Product name to edit - ");
						list.setProductName(scan.next());
						System.out.println("Enter product price to edit - ");
						list.setProductPrice(scan.nextDouble());
						System.out.println("Enter Product Quantity to edit - ");
						list.setProductStock(scan.nextInt());
						System.out.println("Enter Product Expiry date to edit - ");
						list.setProductExpiry(scan.next());
						System.out.println("Product " + list.getProductid() + " updated successfully.");
					}
				}
				System.out.println("Enter 0 to exit or any number to edit more products. ");
				if(scan.nextInt() == 0)
					break;
			}else{
				System.out.println("Product doesnot exists");
				System.out.println("Enter 0 to exit or any number to edit another products. ");
				if(scan.nextInt() == 0)
					break;
			}//else
		}//end of while
			
		}//addProdu
	
	public void addProductfromList(ProductDetails prd) {
		listOfProduct.add(prd);
	}
	
	public void seeInventory(){
		System.out.println("------------------------------------------");
		System.out.println("Inventory Details : ");
		System.out.println(String.format("|%-10s||%-10s||%-10s||%-10s|", "PrdId","PrdName","PrdPrice","PrdQt"));
		System.out.println("------------------------------------------");
		for (ProductDetails list : listOfProduct) {
			System.out.println(String.format("|%-10d||%-10s||%-10s||%-10d|",list.getProductid(), list.getProductName(), String.format("%.2f",list.getProductPrice()), list.getProductStock()));
		}
	}//seeInventory()
	
	ArrayList<EmployeeDetails> listofEmployee = new ArrayList<EmployeeDetails>();
	
	public boolean isEmployeeNew(int empid) {
		for (EmployeeDetails list : listofEmployee) {
			if(list.getEmpId() == empid)
				return false;
		}
		return true;
	}
	
	public ArrayList<EmployeeDetails> getListOfEmployee() {
		return listofEmployee;
	}
	
	public void addEmployeefromList(EmployeeDetails emp) {
		listofEmployee.add(emp);
	}
	
	public void addEmployee() {
		EmployeeDetails empData = new EmployeeDetails();
		System.out.println("Enter Employee Id : ");
		int emp = scan.nextInt();
		if(isEmployeeNew(emp)){
			empData.setEmpId(emp);
			System.out.println("Enter username : ");
			empData.setUsername(scan.next());
			System.out.println("Enter Password : ");
			empData.setPassword(scan.next());
			listofEmployee.add(empData);
			System.out.println("Employee added successfully. ");
		}
		else{
			System.out.println("Employee already exists. ");
		}
	}//addEmployee()
	
	public String removeEmployee() {
		System.out.println("Enter Employee id - ");
		int prdid = scan.nextInt();
		if (isEmployeeNew(prdid)){
			return "Employee Doesn't Exists in your Company.";
		}
		else{
			for (EmployeeDetails list : listofEmployee) {
				if(list.getEmpId() == prdid){
					listofEmployee.remove(list);
					return "Employee Removed Successfully. ";
				}
			}
		}
		return "Employee Doesn't Exists in your Company.";
	}//removeProduct()
	
	public void seeEmployee(){
		System.out.println("------------------------------------------");
		System.out.println("Employee Details : ");
		System.out.println(String.format("|%-10s||%-10s||%-10s|", "Emp.Id","Emp.U.name","Emp.Pass"));
		System.out.println("------------------------------------------");
		for (EmployeeDetails list : listofEmployee) {
			System.out.println(String.format("|%-10d||%-10s||%-10s|",list.getEmpId(), list.getUsername(), list.getPassword()));
		}
	}//seeInventory()
	
	
}















