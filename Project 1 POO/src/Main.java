import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
	
		Syst syst = new Syst();
		Scanner scanner = new Scanner(System.in);
	    int option = 0;
	    
	    //Sign In & Logn In
	    do{
	    	System.out.print("\t|Restaurant App|\n"
	    			+ "1. Sign In\n"
	    			+ "2. Logn In\n"
	    			+ "3. Exit\n"
	    			+ "Enter your selection: ");
	    	option = scanner.nextInt();
	    	switch(option) {
	    	case 1:
	    		System.out.print("\n1- Customer Account\n"
	    				+ "2- Chef Account \n"
	    				+ "3- Admi Account\n"
	    				+ "Enter your Account Type: \n");
	    		int typeSelect = scanner.nextInt();
	    		String type = "";
	    		switch(typeSelect) {
	    		case 1:	type = "Customer";
	    			break;	    			
	    		case 2: type = "Chef";
	    			break;	    			
	    		case 3: type = "Admi";
	    			break;
	    		}
	    		System.out.print("\n\t|Sign In|\nUsername: ");
	    		String signName = scanner.next();
	    		System.out.print("\nPassword: \n");
	    		String signPassword = scanner.next();
	    		
	    		syst.signIn(signName, signPassword, type);
	    		System.out.println("\nAccount Successfully Registered\n");
	    		break;
	    		
	    	case 2:
	    		String lognName;
	    		String lognPassword;
	    		
	    		System.out.print("\n\t|Logn In|\nUsername: ");
	    		lognName = scanner.next();
	    		System.out.print("\nPassword: ");
	    		lognPassword = scanner.next();
	    		
	    		if(syst.lognIn(lognName, lognPassword)) {
	    			System.out.println("\nLogn In Successfully\n");
	    			option = 3;
	    		}else{
	    			System.out.println("\nUsername or Password incorrect\n");
	    		}
	    		break;
	    	}	    	
	    }while(option != 3);
    }
 }


