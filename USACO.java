import java.io.*;
import java.util.*;
public class USACO{
  public static void main(String[] args){
    System.out.println("" + silver("ctravel.4.in"));
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

      int[][] around = {
        {1,1},
        {1,0},
        {1, -1},
        {0,0},
        {0, 1},
        {0, -1},
        {-1, 0},
        {-1, 1},
        {-1, -1}
      };

      for (int i = 0; i < directions.length; i++){
        int R = directions[i][0];
        int C = directions[i][1];
        int highest = 0;
        for (int j = 0; j < 9; j++){
          int nextR = R + around[j][0];
          int nextC = C + around[j][1];
          if (nextR >= 0 && nextR < elevations.length && nextC >= 0 &&
              nextC < elevations[0].length && elevations[nextR][nextC] > highest){
              highest = elevations[nextR][nextC];
            }
        }
        //we have the highest elevation, now we can stomp
        for (int j = 0; j < directions[i][2] && highest > 0; j++){
          for (int z = 0; z < 9; z++){
            int nextR = R + around[z][0];
            int nextC = C + around[z][1];
            if (nextR >= 0 && nextR < elevations.length && nextC >= 0 &&
                nextC < elevations[0].length && elevations[nextR][nextC] == highest){
                elevations[nextR][nextC] -= 1;
              }
          }
          highest -= 1;
        }
      }
      int total = 0;
      for (int i = 0; i < elevations.length; i++){
        for (int j = 0; j < elevations[0].length; j++){
          if (0 < e - elevations[i][j]){
            total += e - elevations[i][j];
          }
        }
      }
      total = total * 72 * 72;
      return total;
    } catch (FileNotFoundException e){
      System.out.println("File Invalid");
    }
    return -1;
  }

  //for testing purposes
  public static String testingString(int[][] ary){
    String s = "";
    for (int i = 0; i < ary.length; i++){
      for (int j = 0; j < ary[0].length; j++){
        s += " " + ary[i][j];
      }
      s += "\n";
    }
    return s;
  }

  public static int silver(String filename){
    try{
      File ctravel = new File(filename);
      Scanner traveller = new Scanner(ctravel);
      int N = Integer.parseInt(traveller.next());
      int M = Integer.parseInt(traveller.next());
      int T = Integer.parseInt(traveller.next());
      String a;
      char[][] field = new char[N][M];
      for (int i = 0; i < N; i++){
        a = traveller.next();
        for (int j = 0; j < M; j++){
          field[i][j] = a.charAt(j);
        }
      }
      int startR = Integer.parseInt(traveller.next()) - 1;
      int startC = Integer.parseInt(traveller.next()) - 1;
      int endR = Integer.parseInt(traveller.next()) - 1;
      int endC = Integer.parseInt(traveller.next()) - 1;
      //System.out.println(testingString(field));
      int[][] moves = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
      };

      int[][] trace = new int[N][M];
      int[][] storeSums = new int[N][M];

      for (int i = 0; i < 4; i++){
        int r = startR + moves[i][0];
        int c = startC + moves[i][1];
        if (r >= 0 && r < N && c >= 0 && c < M && field[r][c] != '*'){
          trace[r][c] = 1;
          storeSums[r][c] = 1;
        }
      }

      //while there is time left
      while (T > 1){
        //loops through each spot on the grid and finds a sum for each
        for (int i = 0; i < N; i++){
          for (int j = 0; j < M; j++){
            int around = 0;
            for (int z = 0; z < 4; z++){
              int r = i + moves[z][0];
              int c = j + moves[z][1];
              //around is the sum of surrounding paths or sum of possible ways to get to a certain spot from the start
              if (r >= 0 && r < N && c >= 0 && c < M && field[r][c] != '*'){
                around += trace[r][c];
              }
            }
            if (field[i][j] != '*'){
              //the use of this 2D array allows us to find sums for each spot and store them
              storeSums[i][j] = around;
            }
          }
        }

        //after a sum has been found for each square, values can be transferred over to trace
        for (int i = 0; i < N; i++){
          for (int j = 0; j < M; j++){
            trace[i][j] = storeSums[i][j];
          }
        }
        T--;
      }
      //System.out.println("" + startR + ", " + startC);
      //System.out.println(testingString(trace));
      return trace[endR][endC];
    } catch (FileNotFoundException e){
      System.out.println("Filename Not Valid");
    }
    return -1;
  }
}
