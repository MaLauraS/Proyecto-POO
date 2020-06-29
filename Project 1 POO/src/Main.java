import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
	
		Syst syst = new Syst();
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		boolean enter = false;
	    int option = 0;
	    
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
	    		case 1:	type = "customer";
	    			break;	    			
	    		case 2: type = "chef";
	    			break;	    			
	    		case 3: type = "admi";
	    			break;
	    		}
	    		System.out.print("\n\t|Sign In|\nUsername: ");
	    		String signName = scanner.next();
	    		System.out.print("\nPassword: \n");
	    		String signPassword = scanner.next();
	    		
	    		syst.signIn(signName, signPassword, type);
	    		user = syst.getUser(signName);
	    		enter = true;
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
	    			user = syst.getUser(lognName);
	    			enter = true;
	    			System.out.println("\nLogn In Successfully\n");
	    			option = 3;
	    		}else{
	    			System.out.println("\nUsername or Password incorrect\n");
	    		}
	    		break;
	    	default: break;
	    	}
	    }while(option != 3);
	    
	    if(enter) {
	    	switch(user.getType()) {
	    	case "Customer":
	    		boolean seeCostMenu = true;
	    		do {System.out.print("\n\t|Customer Menu|\n"
	    				+ "1. Register Address\n"
	    				+ "2. Register Food Profile\n"
	    				+ "3. Request Today's Menu\n"
	    				+ "4. Exit\n"
	    				+ "Enter your selection: ");
	    		int customerOption = scanner.nextInt();
	    		switch(customerOption) {
	    		case 1:
	    			System.out.println("\nEnter Addresses Name:\n");
	    			String address = scanner.next();
	    			System.out.println("\nEnter latitude:\n");
	    			float latitude = scanner.nextLong();
	    			System.out.println("\nEnter longitude:\n");
	    			float longitude = scanner.nextLong();
	    			syst.RegisterAddress(address, latitude, longitude, user);
	    			System.out.println("\nAddress Registration Successful\n");
	    			break;
	    			
	    		case 2:
	    			String allergy = "";
	    			boolean stay = true;
	    			do {System.out.println("1. Vegan\n"
	    					+ "2. Vegetarian\n"
	    					+ "3. Gluten Free\n"
	    					+ "4. Halal\n"
	    					+ "5. Kosher\n"
	    					+ "6. Allergy/Intolerance\n"
	    					+ "Enter your Food Profile: ");
	    			int fp_option = scanner.nextInt();
	    			switch (fp_option) {
	                case 1:
	                  syst.setFoodProfile(fp_option, user, allergy);
	                  break;
	                case 2:
	                  syst.setFoodProfile(fp_option, user, allergy);
	                  break;
	                case 3:
	                  syst.setFoodProfile(fp_option, user, allergy);
	                  break;
	                case 4:
	                  syst.setFoodProfile(fp_option, user, allergy);
	                  break;
	                case 5:
	                  syst.setFoodProfile(fp_option, user, allergy);
	                  break;
	                case 6:
	                  System.out.println("\nEnter singular and starting with a capital letter, the food that causes you Allergy or Intolerance: ");
	                  allergy = scanner.next();
	                  syst.setFoodProfile(fp_option, user, allergy);
	                  break;
	                default:
	                  break;
	    			}
	    			System.out.println("\nDo you want to continue updating your Food Profile?\n"
	    					+ "1. Yes\n"
	    					+ "0. No\n");
	    			int YN = scanner.nextInt();  	              	
  	                if(YN == 0) {
  	                	stay = false;
  	                }
	    			}while(stay);
	    			break;
	    			
	    		case 3:
	    			Dishes auxDish = syst.RequestMenu(user);
	                for(int i=0; i < auxDish.size(); i++){
	                  System.out.println("ID:"+i+" - " + auxDish.get(i).getName() + " - Price: " + auxDish.get(i).getPrice(auxDish.get(i).getIngredients()) + "Colones");
	                }
	                  System.out.println("\n*Prices not including IVA and Service Costs*\n"
	                  		+ "Do you want to order one or more dishes?");
	                  System.out.println("1: Yes");
	                  System.out.println("0: No");
	                  int YN2 = scanner.nextInt();
	                  switch(YN2){
	                    case 1:
	                      float shoppingCart = 0;
	                      boolean tempFlag2 = true;
	                      while(tempFlag2){
	                        System.out.println("Enter the Dish ID:");
	                        int dishID = scanner.nextInt();
	                        if(auxDish.isEmpty()){
	                          System.out.println("The dish doesn't exist or is disabled");
	                        } else {
	                          System.out.println("Added to shopping Cart: "+auxDish.get(dishID).getName());
	                          shoppingCart += auxDish.get(dishID).getPrice(auxDish.get(dishID).getIngredients());
	                        }
	                        System.out.println("Do you want to order one or more dishes?");
	                        System.out.println("1: Yes");
	                        System.out.println("0: No");
	                        int YN3 = scanner.nextInt();
	                        switch(YN3){
	                        case 1:
	                           tempFlag2 = true;
	                           break;
	                           
	                        default:
	                          tempFlag2 = false;
	                           break;
	                        }
	                      }
	                      shoppingCart += ((shoppingCart/100)*35);                
	                      System.out.println("\nBill of: " + shoppingCart + " colones\n");
	                      System.out.println("\nDo you want to pay for it?");
	                      System.out.println("1: Yes");
	                      System.out.println("0: No");
	                      int YN4 = scanner.nextInt();
	                      switch(YN4){
	                      case 1:
	                           System.out.println("\nOrder Done, Returning to the Menu\n");
	                           shoppingCart = 0;
	                           break;
	                           
	                     default:
	                           System.out.println("\nDelete Shopping Cart, Returning to the Menu\nl");
	                           shoppingCart = 0;
	                           break;
	                        }
	                      break;
	                      
	                    default:
	                      break;
	                  }
	    			break;
	    			
	    		case 4:
	    			seeCostMenu = false;
	    			break;
	    		}
	    		}while(seeCostMenu);
	    		break;
	    		
	    	case "Chef":
	    		boolean seeChefMenu = true;
	    		do {
	    			System.out.println("\n\t|Chef Menu|\n"
	    					+ "1.Add Dish\n"
	    					+ "2.See Inventory\n"
	    					+ "3. Add Ingredient"
		    				+ "4. Exit\n"
		    				+ "Enter your selection: ");
	    	        int InputMenu3 = scanner.nextInt();
	    	        switch(InputMenu3){
	    	          case 1:
	    	            System.out.println("\nDish Name:\n");
	    	            String nameDish = scanner.next();
	    	            scanner.nextLine();
	    	            Inventory ingredientDish = new Inventory(); 
	    	            boolean flag3 = true;
	    	            while(flag3){
	    	              System.out.println("\nIngredient Name: ");
	    	              String ingName = scanner.next();
	    	              scanner.nextLine();
	    	              System.out.println("Inventory Ingredient Account");
	    	              float ingCant = scanner.nextFloat();
	    	              System.out.println("Dish Ingredient Account");
	    	              float ingCant2 = scanner.nextFloat();
	    	              System.out.println("Ingredient Price");
	    	              float ingPrecio = scanner.nextFloat();
	    	              scanner.nextLine();
	    	              Ingredient TempIng = new Ingredient(ingName, ingCant, ingPrecio);
	    	              Ingredient TempIng2 = new Ingredient(ingName, ingCant2, ingPrecio);
	    	              syst.inventory.add(TempIng);
	    	              ingredientDish.add(TempIng2);
	    	              System.out.println("Do you want to add another Ingredient to the Dish?");
	    	              System.out.println("1: Yes");
	    	              System.out.println("0: No");
	    	              int YN5 = scanner.nextInt();
	    	              switch(YN5){
	    	              case 1:
	    	            	  flag3 = true;
	    	            	  break;
	    	              default:
	    	            	  flag3 = false;
	    	            	  break;
	    	              }
	    	            }

	    	            System.out.println("\nDishes Recipe:\n");
	    	            String preparacionDish = scanner.next();
	    	            scanner.nextLine();
	    	            Dish tempPlatillo = new Dish(nameDish, preparacionDish, ingredientDish);
	    	            syst.setDish(tempPlatillo);
	    	            System.out.println("\nDish loaded to the System\n");
	    	            break;
	    	            
	    	          case 2:
	    	        	Inventory tempInv = syst.getInventory();
	    	        	System.out.println("\n\t|Inventory|");
	    	            for(int i = 0; i < tempInv.size(); i++){
	    	              System.out.println(tempInv.get(i).getIngredient() + " - Stock:" + tempInv.get(i).getAmount() + " - Price: " + tempInv.get(i).getPrice());
	    	            }
	    	            break;
	    	            
	    	          case 3:
	    	              System.out.println("Ingredient Name: ");
	    	              String ingName3 = scanner.next();
	    	              System.out.println("Inventory Ingredient Account: ");
	    	              float ingCant3 = scanner.nextFloat();
	    	              System.out.println("Ingredient Price: ");
	    	              float ingPrecio3 = scanner.nextFloat();
	    	              Ingredient Ing3 = new Ingredient(ingName3, ingCant3, ingPrecio3);
	    	              syst.setIngredient(Ing3);
	    	              break;
	    	            
	    	          case 4:
	    	        	  seeChefMenu = false;
	    	              break;
	    	        }
	    		}while (seeChefMenu);
	    	    break;
	    		
	    	case "Admi":
	    		boolean seeAdmiMenu = true;
	    		while (seeAdmiMenu){
	    	        System.out.println("\n\t|Admi Menu|\n"
	    	        		+ "1: Add Ingredient\n"
	    	        		+ "2: Exit\n"
	    	        		+ "Enter your selection: \n");
	    	        int InputMenu4 = scanner.nextInt();
	    	        switch(InputMenu4){
	    	        case 1:
	    	            System.out.println("Ingredient Name: ");
	    	            String ingName4 = scanner.next();
	    	            System.out.println("Inventory Ingredient Account: ");
	    	            float ingCant4 = scanner.nextFloat();
	    	            System.out.println("Ingredient Price: ");
	    	            float ingPrecio4 = scanner.nextFloat();
	    	            Ingredient Ing4 = new Ingredient(ingName4, ingCant4, ingPrecio4);
	    	            syst.setIngredient(Ing4);
	    	            break;
	    	            
	    	        case 2:
	    	        	seeAdmiMenu = false;
	    	            break;
	    	        }
	    	      }	    		
	    		break;	    			
	    	}
	    }   
    }
 }


