import java.io.*;
import java.util.*;
public class USACO{
  public static void main(String[] args){
    bronze("makelake.1.in");
  }
  public static int bronze(String filename){
    try {
      int r, c, e, n;
      File lake = new File(filename);
      Scanner lakeler = new Scanner(lake);
      r = lakeler.nextInt();
      c = lakeler.nextInt();
      e = lakeler.nextInt();
      n = lakeler.nextInt();
      int[][] elevations = new int[r][c];
      int[][] directions = new int[r][c];
      for (int i = 0; i < elevations.length; i++){
        for (int j = 0; j < elevations[0].length; j++){
          elevations[i][j] =  lakeler.nextInt();
        }
      }
      while (n > 0){
        int row = lakeler.nextInt();
        int col = lakeler.nextInt();
        int stomp = lakeler.nextInt();
        
      }
      String z = "";
    //for testing purposes
      for (int i = 0; i < r; i++){
        for (int j = 0; j < c; j++){
          z += " " + directions[i][j];
        }
        z += "\n";
      }
      System.out.println(z);
      return 1;
    } catch (FileNotFoundException e){
      return 1;
    }
  }

}
