//Name:       Date: 
//Graphs, Lesson #3

   import java.util.Scanner;
   import java.io.*;
   public class Floyd_6_Xie
   {
      public static void floyd( int[][] g)
      {
         int cost;
         int n=g.length;
         for(int i = 0; i < n; i++) 
            for(int j = 0; j < n; j++)
               for(int k = 0; k < n; k++)
               {
                  cost = g[j][k]+g[i][j];
                  if(cost < g[i][k]) 
                  {
                     g[k][i] = cost;
                     g[i][k] = cost;
                     
                  }
               }
      
      }
      
      public static void main( String[] args)throws FileNotFoundException
      {
         System.out.print("Floyd's Algorithm! Enter filename: "); //citydataweighted.txt
         Scanner keyboard=new Scanner(System.in);
         String filename=keyboard.nextLine();
         int[][] adjacency = read(filename);
         floyd(adjacency);
         display(adjacency);
      }
   		
      public static int[][] read(String filename) throws FileNotFoundException
      {
         Scanner infile = new Scanner(new File(filename));
         int[][] map = new int[infile.nextInt()][infile.nextInt()];
         for(int i = 0; i< map.length; i++)
            for(int j = 0; j<map[i].length; j++)
               map[i][j] = infile.nextInt();			
         return map;
      
      }
      
      public static void display(int[][] g)
      {
         for(int r = 0; r < g.length; r++)
         {
            for(int c = 0; c < g[0].length; c++)
               System.out.print(" " + g[r][c] + " ");
            System.out.println();
         }
      }
   }