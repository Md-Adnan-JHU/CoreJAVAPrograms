package question1;

import java.util.Scanner;

class Employee {
	
	private String employeeId;
	private String[] courses;
	private double salary;
	private int rating;
	private double increment;
	private int coursesDone;

	public Employee(String employeeId, String[] courses, double salary, int coursesDone) {
		this.employeeId = employeeId;
		this.courses = courses;
		this.salary = salary;
		this.coursesDone = coursesDone;
	}
	
	public void calculateRating() {
		for (int i = 0; i < coursesDone; i++) {
			String string = courses[i];
			if (string.equals("AWS")) {
				rating++;
			} else if (string.equals("Cisco")){
				rating++;
			}  else if (string.equals("RedHat")){
				rating++;
			} else if (string.equals("Oracle")){
				rating++;
			} else if (string.equals("AEM")){
				rating++;
			} 
		}	
	}

   public int getRating() {
	   calculateRating();
	   return rating;
   }
   
   public double calculateIncrement() {
	   if (rating==1) {
		   increment = salary * 2.5/100;
	}else if (rating==2) {
		   increment = salary * 4/100;
	} else if (rating==3) {
		   increment = salary * 5.5/100;
	}else if (rating==4) {
		   increment = salary * 8/100;
	} else if (rating==5) {
		   increment = salary * 10/100;
	} else {
		 increment = 0;
	} 
	   return increment;
   }
   
   public double getNewSalary() {
	  return salary+increment;
   }
}

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String decision;
		String [] courses = new String[5];
		boolean yn = true;
		
		while(yn)
		{
		    System.out.println("Enter Employee Id: ");
		    String employeeId = sc.nextLine();
		    System.out.println("Enter your salary: ");
		    double salary = sc.nextInt();
		    System.out.println("Number of courses done: ");
		    int coursesDone = sc.nextInt();
		    
		    System.out.println("Enter the course name as given: ");
		    System.out.println("1. Oracle");
		    System.out.println("2. AEM");
		    System.out.println("3. Cisco");
		    System.out.println("4. AWS");
		    System.out.println("5. RedHat");
		    
		    for(int i=0; i<coursesDone; i++) {
		    	courses[i] = sc.next();
		    }
		    sc.nextLine();
		    
		    Employee emp = new Employee(employeeId, courses, salary, coursesDone);
		    System.out.println("\nYour rating is : "+emp.getRating());
		    System.out.println("Increment amount is : "+emp.calculateIncrement());
		    System.out.println("Updated salary is : "+emp.getNewSalary());

		    System.out.println("Wanna continue?  yes or no...");
		    decision = sc.nextLine();

		    switch(decision)
		    {
		        case "yes":
		            yn = true;
		            break;

		        case "no":
		            yn = false;
		            break;

		        default:
		            System.out.println("please enter again ");
		            boolean repeat = true;

		            while (repeat)
		            {
		                System.out.println("Wanna continue?  yes or no...");
		                decision = sc.nextLine();
		                sc.close();
		                
		                switch (decision)
		                {
		                    case "yes":
		                        yn = true;
		                        repeat = false;
		                        break;

		                    case "no":
		                        yn = repeat = false;
		                        break;
		                    default:
		                        repeat = true;
		                }
		            }
		            break;
		    }
		}	
	}
}
