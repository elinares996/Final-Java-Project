package cars;
import java.util.InputMismatchException;
import java.util.Scanner;



public class dealership {
 // constructor of project class
	public dealership() {
		// TODO Auto-generated constructor stub
	}
	
	//Method to display the menu
	public static void menu(){
		System.out.println("1  --  Add Vehicle");
		System.out.println("2  --  Display All Vehicles");
		System.out.println("0  --  Quit");
		
	}
	
	//Main entry point
	public static void main(String[] args) throws NumberFormatException {
		
		//scanner object for user input, boolean variable, car array, and project variable
		Scanner choice_  = new Scanner(System.in);
		boolean zero = true ;
		Car[] cars = new Car[2];
		dealership p = new dealership();
		
		//while loop to carry out what proceeds aslong as boolean variable is = to true
		while(zero == true) {
			
			//use p object to call menu method and display the menu
			p.menu();
			
			//Try and catch block 
			try {
				System.out.print("Enter your choice: ");
			     String input = choice_.nextLine();
			   
			    int choice = Integer.parseInt(input);
			    
			    //determine which case should be chosen 
    		    switch(choice) {
    		  //in case one use a for loop that increments after each loop and takes in user input and stores them in the cars array declared earlier
				case 1:
					for (int i = 0; i < 2; i++){
						System.out.println("make");
						String make = choice_.nextLine();
						
						System.out.println("model");
						String model = choice_.nextLine();
						
						System.out.println("year" );
						int year = Integer.parseInt(choice_.nextLine());
						
						System.out.println("doors");
						int doors = Integer.parseInt(choice_.nextLine());
						
						System.out.println("price");
						int price = Integer.parseInt(choice_.nextLine());
						
						cars[i] =  new Car(make, model, year, doors, price);
						System.out.println("");
												}
					break;
					
				// declare boolean variable  and do another while loop to display the cars and ask users whether they want to go back to menu or quit 	
				case 2:
					boolean secondZero = true;
					System.out.println(" ");
					while(secondZero == true) {
					
					int i = 0;
					for(i = 0; i < 2; i++) {
					cars[i].GetDisplay();
											}
					if(i == 2) {
						System.out.println(" ");
						System.out.println(" would you like to go back? ");
						System.out.println(" 1 -- to menu ");
						System.out.println(" 0 -- to quit ");
						int choice2 = Integer.parseInt(choice_.nextLine());
						
					
							switch(choice2) {
							case 1:
								secondZero = false;
								break;
							case 0:
								secondZero = false;
								zero = false;
								break;
							default:
								System.out.println("wront input please press 1 or 0 \n");
								break;
											}
								}
					
						
					}
					break;
					// for case 0 change boolean variable in while loop to false to exit the loop
				case 0:
					zero = false;
					break;
				default:
					System.out.println("please try another option");
					break;
				
				}
				
			}
			//catch any input error within each case and shows input error along with "invalid input, please try again" message to help clarify/
			catch(IllegalArgumentException e) {
	    		   System.out.println("Invalid input, please try again!\\n"); 
	    		   System.out.println(e);
	    	   }
			catch(NullPointerException e) {
		        System.out.println("Empty Please input values!");
		        System.out.println(e + "\n");
		        
			
								}
			catch(Exception e) {
		        System.out.println("Invalid input, please try again!\n");
		        System.out.println(e + "\n");
		        
			
								}
		}

		
	}
	
}
	

class Vehicle{
		//declare Make, Model, and Year variables
		protected String Make;
		protected String Model;
		private int Year;
		
		//Constructor thats arguments are set to the Make, Model, and Year variable declared in this class
		protected Vehicle(String Make, String Model, int Year) {
	        this.Make = Make;
	        this.Model = Model;
	        this.Year = Year;
	    }
		
		//method to display Make, Model, Year that have been instantiated in the Vehicle constructor
		protected void SetDisplay() {
	        System.out.println(String.format("Make: %s \nModel: %s \nYear: %d", this.Make, this.Model, this.Year));
	    }
	}
	
class Car extends Vehicle{
		//Class car inherits Vehicle class
		
		//declare doors and price variables
		private int Doors;
		private int Price;
		
		//call Car constructor thats uses the super keyword to bring values Make, Model, Year from vehicle class and sets doors and price variables equal to the parameters/arguments given
		Car(String Make, String Model, int Year, int Doors, int Price) {
			super(Make,Model,Year);
			super.Make = Make;
			super.Model = Model;
			
			this.Doors = Doors;
			this.Price = Price;
			
			
			
			
			
			
			

		}
		
		
		//method that brings the display method from Vehicle class and adds to it the formatting of doors and price
		public void GetDisplay() {
	        super.SetDisplay();
	        System.out.println(String.format("Doors: %d \nPrice: %d", Doors, Price));
	    }

		
	}