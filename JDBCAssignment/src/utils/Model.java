package utils;
import java.util.Scanner;

public class Model {
	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		
		do{
			System.out.println("1. Save a new Car");
			System.out.println("2. Add a new Number");
			System.out.println("3. Exit");
			
			int task = in.nextInt();
			
			if(task == 1) {
				
			}
			else if(task == 2) {
				System.out.println("Please enter First Name:");
				String firstName = in.next();
				System.out.println("Please enter Second Name:");
				String secondName = in.next();
			}
			else{
				System.out.println("Bye!");
				break;
			}
		}while(true);
	}
}
