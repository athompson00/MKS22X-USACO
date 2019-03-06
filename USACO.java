import java.io.*;
public class USACO{
  public static int bronze(String filename){
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
      
    }
  }
}
