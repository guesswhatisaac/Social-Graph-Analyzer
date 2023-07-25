import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class FileReader {

    public int[][] readFile(String path) {

        try{
            File file = new File(path);
            Scanner scan = new Scanner(file);

            int n = scan.nextInt();
            int e = scan.nextInt();
            int[][] matrix = new int[n][n];
            
            for(int[] row : matrix){ // set matrix values to 0
                Arrays.fill(row, 0);
            }

            for(int i = 0; i < e; i++){ // create connections between users

                int a = scan.nextInt();
                int b  = scan.nextInt();
                
                if(a != b){
                    matrix[a][b] = 1;
                    matrix[b][a] = 1;
                }
            }

            scan.close();
            return matrix;

        } catch(FileNotFoundException e) {
            System.err.println("File not found.");
            e.printStackTrace();
            return null;
        }
    }
}


