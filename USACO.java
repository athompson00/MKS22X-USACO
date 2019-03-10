import java.io.*;
import java.util.*;
public class USACO{
  public static void main(String[] args){
    bronze("makelake.1.in");
  }
  public static int bronze(String filename){
<<<<<<< HEAD
    int r, c, e, n;
    File lake = new File(filename);
    Scanner lakeler = new Scanner(lake);
    r = lakeler.nextInt();
    c = lakeler.nextInt();
    e = lakeler.nextInt();
    n = lakeler.nextInt();
    lakeler = new Scanner(lake);
    lakeler.nextLine();
    String n = lakeler.nextLine();
    lakeler = new Scanner(lake);
    int a = 0;
    while (lakeler.hasNextLine()){
      lakeler.nextLine();
      a++;
    }
    lakeler = new Scanner(lake);
    int[][] elevations = new int[n.length()][a - 1 - n];
    int[][] directions;
    for (int i = 0; i < elevations.length; i++){

=======
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
>>>>>>> 20d8eef4da6d4c8a668f773bda4df5244c890d8b
    }
  }

}
