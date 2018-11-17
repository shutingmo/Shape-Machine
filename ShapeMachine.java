//Name: Cynthia Mo
//UFL ID: 04938124
//Section: 2296
//Project Number: 2
//Brief description of file contents: Shape Machine


import java.util.Scanner; 
import java.lang.Math; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.String; 

public class ShapeMachine 
{
	public static void main(String[] args)
	{
		//Add this code below to compare user's entered date with actual date
		new Date (); 
		String realDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		Scanner input = new Scanner(System.in);
		String userDate = " "; 
		
		System.out.println("Shape Machine login\n");

		int tries; //the number of times the user enters the date
		//tries will initially equal 1, the loop will run and ask for the date
		for (tries = 1; !userDate.equals(realDate); tries++)
		{
			
			System.out.print("What is today's day?");
			String day = input.next();
			
			System.out.print("What is today's month?");
			String month = input.next();

			System.out.print("What is today's year?");
			String year = input.next();
			
			userDate = (day + "-" + month + "-" + year); //put the date in the right format
			
			//when the user has less than 3 tries, they can still enter more tries for dates
			if (!userDate.equals(realDate) && tries < 3)
			{
				System.out.println("#ERROR Login attempt #" + tries + " Invalid input. Please try again.\n");
			}
			
			//once the user uses their third try and guesses wrong, the program is terminated
			else if (!userDate.equals(realDate) && tries == 3)
			{
				System.out.println("#ERROR 3rd invalid login attempt. Terminating program.");
				System.exit(0);
			}
			
			else //userDate == realDate
			{
				System.out.println("Correct date. Welcome!\n");
			}
		}
		
		String userShape = "null"; //declare userShape but don't set it to a value yet
		
		while (!userShape.equals("Exit"))
		{
			System.out.println("---Welcome to the Shape Machine---");
			System.out.println("Available Options: \nCircles \nRectangles \nTriangles \nExit \n");
			userShape = input.next();
			
			if (userShape.equals("Circles"))
			{
				System.out.print("Circles selected. Please enter the radius: ");
				double radius = input.nextDouble();
				
				while (radius < 0) 
				{
					System.out.print("#ERROR Negative input. Please input the radius again: ");
					radius = input.nextDouble();
				}
				
				//once radius is 0 or positive then the program moves onto this
				double circumference = 2 * radius * Math.PI; 
				System.out.println("The circumference is: " + circumference);
				
				double circleArea = circumference * (radius/2); 
				System.out.println("The area is: " + circleArea);
				
				//convert double to a string so the program can count how many characters are in the circumference and area
				String circumference2 = Double.toString(Math.abs(circumference));
				System.out.println("Total number of digits in the circumference is: " + (circumference2.length() - 1) );
	
				String circleArea2 = Double.toString(Math.abs(circleArea));
				System.out.println("Total number of digits in the area is: " + (circleArea2.length() - 1) + "\n"); 
			}
			
			else if (userShape.equals("Rectangles"))
			{
				System.out.print("Rectangles selected. Please enter the 2 sides: ");
				double recSide1 = input.nextDouble();
				double recSide2 = input.nextDouble();
				
				while (recSide1 < 0 || recSide2 < 0)
				{
					System.out.print("#ERROR Negative input. Please input the 2 sides again: ");
					recSide1 = input.nextDouble();
					recSide2 = input.nextDouble();
				}
				
				double recArea = recSide1 * recSide2; 
				System.out.println("The area is: " + recArea);
	
				double recPerimeter = (2 * recSide1) + (2* recSide2); 
				System.out.println("The perimeter is: " + recPerimeter);
				
				String recArea2 = Double.toString(Math.abs(recArea));
				System.out.println("Total number of digits in the area is: " + (recArea2.length() - 1) );
	
				String recPerimeter2 = Double.toString(Math.abs(recPerimeter));
				System.out.println("Total number of digits in the perimeter is: " + (recPerimeter2.length() - 1) + "\n"); 
			}
			
			else if (userShape.equals("Triangles"))
			{
				System.out.print("Triangles selected. Please enter the 3 sides: ");
				double triSide1 = input.nextDouble();
				double triSide2 = input.nextDouble();
				double triSide3 = input.nextDouble();
				
				while (triSide1 < 0 || triSide2 < 0 || triSide3 < 0)
				{
					System.out.print("#ERROR Negative input. Please input the 3 sides again: ");
					triSide1 = input.nextDouble();
					triSide2 = input.nextDouble();
					triSide3 = input.nextDouble();
				}
				
				//determine if the sides create a valid triangle, the sum of 2 sides must be greater than the third side
				if ((triSide1 + triSide2 > triSide3) && (triSide3 + triSide2 > triSide1) && (triSide1 + triSide3 > triSide2))
				{
					//Equilateral triangles have same length for all three sides
					if (triSide1 == triSide2 && triSide2 == triSide3) 
					{
						System.out.println("The triangle is: Equilateral");
						
						//use Heron's formula to find area of triangle using the lengths of the three sides
						double s = (triSide1 + triSide2 + triSide3)/2;  

						double triPerimeter = triSide1 + triSide2 + triSide3 ; 
						System.out.println("The perimeter is: " + triPerimeter);
						
						double triArea = Math.sqrt(s * (s - triSide1) * (s - triSide2) * (s - triSide3)); //applying heron's formula
						System.out.println("The area is: " + triArea );
						
						String triPerimeter2 = Double.toString(Math.abs(triPerimeter));
						System.out.println("Total number of digits in the perimeter is: " + (triPerimeter2.length() - 1) );
						
						String triArea2 = Double.toString(Math.abs(triArea));
						System.out.println("Total number of digits in the area is: " + (triArea2.length() - 1) + "\n"); 
					}
					
					//Isosceles triangles have only 2 equal sides 
					else if ((triSide1 != triSide2) && (triSide2 == triSide3) || (triSide1 != triSide3) && (triSide1 == triSide2) || (triSide1 != triSide2) && (triSide1 == triSide3))
					{
						System.out.println("The triangle is: Isosceles");
						
						double s = (triSide1 + triSide2 + triSide3)/2;  

						double triPerimeter = triSide1 + triSide2 + triSide3 ; 
						System.out.println("The perimeter is: " + triPerimeter);
						
						double triArea = Math.sqrt(s * (s - triSide1) * (s - triSide2) * (s - triSide3)); 
						System.out.println("The area is: " + triArea );
						
						String triPerimeter2 = Double.toString(Math.abs(triPerimeter));
						System.out.println("Total number of digits in the perimeter is: " + (triPerimeter2.length() - 1) );
						
						String triArea2 = Double.toString(Math.abs(triArea));
						System.out.println("Total number of digits in the area is: " + (triArea2.length() - 1) + "\n"); 
					}
					
					else
					{
						System.out.println("The triangle is: Scalene");
						
						double s = (triSide1 + triSide2 + triSide3)/2;  

						double triPerimeter = triSide1 + triSide2 + triSide3 ; 
						System.out.println("The perimeter is: " + triPerimeter);
						
						double triArea = Math.sqrt(s * (s - triSide1) * (s - triSide2) * (s - triSide3)); 
						System.out.println("The area is: " + triArea );
						
						String triPerimeter2 = Double.toString(Math.abs(triPerimeter));
						System.out.println("Total number of digits in the perimeter is: " + (triPerimeter2.length() - 1) );
						
						String triArea2 = Double.toString(Math.abs(triArea));
						System.out.println("Total number of digits in the area is: " + (triArea2.length() - 1) + "\n"); 
					}
				}
				
				//the output if the triangle isn't a valid triangle
				else 
				{
					System.out.println("#ERROR Triangle is not valid. Returning to menu. ");
					continue; 
				}
			}
			
			else if (userShape.equals("Exit"))
			{
				System.out.println("Terminating the program. Have a nice day!");
			}
			
			else 
			{
				System.out.println("#ERROR Invalid option. Please try again.");
				continue; //brings us back to the beginning of the loop where we display the menu
			}
		}
		input.close();
	}
}
