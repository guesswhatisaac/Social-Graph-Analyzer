import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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


    public void getConnection(int[][] matrix, int start, int end){

        boolean[] visited = new boolean[matrix.length]; 
        int[] parent = new int[matrix.length];  //Stores the parent vertex for each vertex during traversal
        Arrays.fill(parent, -1);                //All values are set to -1 initially to indicate that no parent is assigned yet

        Queue<Integer> search = new LinkedList<>();
        search.add(start);          //Add the start vertex to the queue
        visited[start] = true;      //Mark 'start' as visited since we are starting from it

        while (!search.isEmpty()) {
            int currentVertex = search.poll();
            if (currentVertex == end) {     // Found the end vertex, reconstruct and print the path/connection
                List<Integer> path = reconstructPath(parent, start, end);   
                printPath(path, start, end);
                return;
            }

            //If currentVertex is not equal to end, iterate through the matrix to explore the neighbors
            //i represents each neighbor
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[currentVertex][i] == 1 && !visited[i]) {     //If there is a connection between the currentVertex and i, and i is not visited
                    search.add(i);                                      //add i to the queue
                    visited[i] = true;                                  //mark i as visited
                    parent[i] = currentVertex;                          //set the parent of i to the currentVertex
                }
            }
        }

        // If the loop ends without finding the end vertex, print no connection
        System.out.println("Cannot find a connection between " + start + " and " + end + ".");
    }


    private List<Integer> reconstructPath(int[] parent, int start, int end) {

        List<Integer> path = new ArrayList<>();     //Stores the vertices in the connection path from end to start (reverse order)
        int currentVertex = end;
        while (currentVertex != -1) {       //Loops until currentVertex becomes -1, meaning we've reached the starting vertex (no parent)
            path.add(0, currentVertex);             //Add current vertex to the path
            currentVertex = parent[currentVertex];        //Update currentVertex to its parent
        }
        return path;
    }


    //Prints the path
    private void printPath(List<Integer> path, int start, int end) {
        
        System.out.println("There is a connection from " + start + " to " + end + "!");
        for(int i = 1; i < path.size(); i++)
        {
            System.out.println(path.get(i-1) + " is friends with " + path.get(i));
        }
        System.out.println();
    }

}
