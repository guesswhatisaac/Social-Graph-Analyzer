import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        FileReader reader = new FileReader();
        Scanner scan = new Scanner(System.in);
        String path;

        System.out.print("Input File Path: ");
        path = scan.nextLine();
        int[][] matrix = reader.readFile(path);

        if (matrix == null){
            scan.close();
            return;
        }

        System.out.println("\nGraph loaded!");
        
        SocialGraph social = new SocialGraph();
        int choice;

        do{
            System.out.println("\n- MAIN MENU -\n");
            System.out.println("[1] Get Friend List");
            System.out.println("[2] Get Connection");
            System.out.println("[3] Exit");

            do{ // TODO: Input validation (for invalid characters)
                System.out.print("\n[ ] : ");
                choice = scan.nextInt();
            } while (choice < 1 || choice > 3);

            if(choice == 1){
                System.out.print("\nEnter ID of Person : ");
                int userID = scan.nextInt(); // TODO: Input validation
                
                if(userID >= matrix.length){
                    System.out.println("User does not exist.");
                }
                else{
                    social.getFriendList(matrix, userID);
                }
            }
            else if(choice == 2){
                
            }

        } while(choice != 3);

        System.out.println("\nExiting...\n");
        scan.close();
    }
}
