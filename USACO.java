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
      int[][] directions = new int[n][3];
      for (int i = 0; i < elevations.length; i++){
        for (int j = 0; j < c; j++){
          elevations[i][j] = lakeler.nextInt();
        }
      }

      int q = 0;
      while (q < n){
        directions[q][0] = lakeler.nextInt();
        directions[q][1] = lakeler.nextInt();
        directions[q][2] = lakeler.nextInt();
        q++;
      }

    } catch (FileNotFoundException e){

    }
    return 1;
  }
}
