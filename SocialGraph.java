import java.util.ArrayList;

public class SocialGraph {

    public void visualizeMatrix(int[][] matrix) {
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void getFriendList(int[][] matrix, int userID){

        ArrayList<Integer> friendList = new ArrayList<Integer>();
        int counter = 0;

        // searches through userID's row and tracks friends
        for(int i = 0; i < matrix.length; i++){
            if(matrix[userID][i] == 1){
                friendList.add(counter, i); 
                counter++;
            }
        }

        // display friend count and friend list
        System.out.println("Person " + userID + " has " + counter + " friends!"); 
        System.out.print("List of friends: ");
        for(int i = 0; i < friendList.size(); i++){
            System.out.print(friendList.get(i) + " ");
        }
        System.out.println();
    }


    public void getConnection(){

    }

}
