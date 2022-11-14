package Project;

import java.util.Scanner;

public class DemoRun {
	
	public static void main(String[] args) {
		AdminClass admin;
		DemoProducts dp = new DemoProducts();
		admin = dp.getUpdatedList();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("------------------------------------------");
		System.out.println("1. Admin Login\n2.Billing Login");
		switch(scan.nextInt()) {
		case 1:
			System.out.println("Enter username : ");
			String id = scan.next();
			if (id.equals("admin")) {
				System.out.println("Enter Password :");
				String password = scan.next();
				if(password.equals("admin")){
					while(true) {
						System.out.println("------------------------------------------");
						System.out.println("1.Add products\n2.Remove Products\n3.Update Products\n4.Show Inventory\n" +
								"5.Add Employee\n6.Remove Employee\n7.Get Employee Details\n8.Logout");
						int n = scan.nextInt();
						switch(n){
						case 1:
							admin.addProducts();
							break;
						case 2:
							admin.removeProduct();
							break;
						case 3:
							admin.editProducts();
							break;
						case 4:
							admin.seeInventory();
							break;
						case 5:
							admin.addEmployee();
							break;
						case 6:
							admin.removeEmployee();
							break;
						case 7:
							admin.seeEmployee();
							break;
						case 8:
							System.exit(0);
							
						default:
							System.out.println("Invalid Choice.");
						}
					}
				}
				else
					System.out.println("Wrong password!");
			}
			else
				System.out.println("Wrong Username!");
			
			break;
		case 2:
			System.out.println("Enter Employee id : ");
			int empid = scan.nextInt();
			int flag = 0;
			for (EmployeeDetails listofemp: admin.getListOfEmployee()){
				if (listofemp.getEmpId() == empid){
					System.out.println("Enter username : ");
					String empname = scan.next();
					if (listofemp.getUsername().equals(empname)){
						System.out.println("Enter password : ");
						String emppass = scan.next();
						if(listofemp.getPassword().equals(emppass)){
							while(true){
								System.out.println("------------------------------------------");
								System.out.println("Welcome to Rushikesh Mart!\n");
								Billing bill = new Billing();
								bill.bill(admin);
								System.out.println("Press 1 to continue or 0 to logout.");
								if(scan.nextInt() == 0)
									System.exit(0);
									//continue;
						}}
						else{
							System.out.println("Invalid Password");
						}
					}
					else{
						System.out.println("Invalid username.");
					}
					
				}
			}
			if(flag == 0)
				System.out.println("Employee ID not found!!!");
		break;
		default:
			System.out.println("Wrong Option.");
		}
		
		
		
	}

}
