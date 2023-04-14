package com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class Menu {
	
	
	public static void main(String[] args) throws IOException {
		Dish dish1 =new Dish(1,"Rajama chawal",120.0);
		Dish dish2= new Dish(2,"Dal chawal",100.0);
		Dish dish3 =new Dish(3,"Biryani",220);
		Dish dish4 =new Dish(4,"Roti",10.0);
		
		
		ArrayList<Dish> dishes =new ArrayList<Dish>();

		dishes.add(dish1);
		dishes.add(dish2);
		dishes.add(dish3);
		dishes.add(dish4);
		
		LinkedHashMap<Dish ,Integer> ordered =new LinkedHashMap<Dish , Integer>();
		Scanner sc =new Scanner(System.in);
		
        int input;
		//double bill=0;
		boolean exit=false;
		int dish1Quantity=0;
		int dish2Quantity=0;
		int dish3Quantity=0;
		int dish4Quantity=0;
		
		do {
			
			System.out.println("Please select a dish to order. Press 0 to exit");
			System.out.println(dish1.getSno() + " "+dish1.getDishName()+" "+dish1.getPrice());
			System.out.println(dish2.getSno() + " "+dish2.getDishName()+" "+dish2.getPrice());
			System.out.println(dish3.getSno() + " "+dish3.getDishName()+" "+dish3.getPrice());
			System.out.println(dish4.getSno() + " "+dish4.getDishName()+" "+dish4.getPrice());
			input =sc.nextInt();
			
			switch(input) {
			
			case 1: dish1Quantity++;
				ordered.put(dish1,dish1Quantity) ;
			  System.out.println(dish1.getDishName()+" added to cart");
			  //bill =bill+resturant1.getPrice();
			  System.out.println();
			  break;
			  
			case 2: ordered.put(dish2, ++dish2Quantity);
				System.out.println(dish2.getDishName()+" added to cart");
			//  bill =bill+resturant2.getPrice();
			  System.out.println();
			  break;
			case 3:ordered.put(dish3,++dish3Quantity) ;
			  System.out.println(dish3.getDishName()+" added to cart");
			  //bill =bill+resturant3.getPrice();
			  System.out.println();
			  break;
			case 4:ordered.put(dish4,++dish4Quantity) ;
			  System.out.println(dish4.getDishName()+" added to cart");
			 // bill =bill+resturant4.getPrice();
			  System.out.println();
			  break;
			case 0: exit=true;
			break;
			default: System.out.println("Invalid Input");
			}
			
			}while(!exit);
		 
		//System.out.println("Your total bill is Rs"+bill);
		 System.out.println("You have ordered");
		 double billingAmount=0;
		Set<Dish> keys =ordered.keySet();
		     
		FileWriter writer = new FileWriter(new File("bill.txt"));
		    writer.write("               Nihal Resturant "+"\n");
		    writer.write("              -----------------"+"\n");
		for(Dish dish :keys) {
		//	 char arr[]=new char[25];
			
				
			writer.write(dish.getDishName()+" x "+ ordered.get(dish)+"  ");
			for(int i=dish.getDishName().length();i<=25;i++) {
				writer.write(" ");
			}
			writer.write(dish.getPrice()+"\n");
			billingAmount =billingAmount + (dish.getPrice()*ordered.get(dish));
			
			
		}
		double sgst=(4.5*billingAmount)/100;
		double cgst=(4.5*billingAmount)/100;
		writer .write("State GST is:                   "+sgst+"\n");
		writer .write("Central GST is:                 "+cgst+"\n");
	    writer.write("Payable amount is:              "+(sgst+cgst+billingAmount)+"rupees");
		
		writer.flush();
		System.out.println("Please visit again...");
		
		
	}
}
