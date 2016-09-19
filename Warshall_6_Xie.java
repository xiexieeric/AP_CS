//Name:      Date:
//Graphs, Lesson #1
   import java.util.Scanner;
   import java.io.*;
   public class Warshall_6_Xie
   {
      public static void warshall( int[][] g)
      {
         for (int k = 0; k < g.length; k++) 
            for (int i = 0; i < g.length; i++)
               for (int j = 0; j < g.length; j++)
               	{
							if((g[i][k]==1)&&(g[k][j]==1))
							g[i][j]=1;
								
               	}
                  
      }
      
      public static void main( String[] args) throws FileNotFoundException
      {
         System.out.print("Warshall's Algorithm! Enter filename: "); //citydata.txt
         Scanner keyboard=new Scanner(System.in);		
         String filename=keyboard.nextLine();																		//citydataundirected.txt
         int[][] adjacency = read(filename);
         warshall(adjacency);
         display(adjacency);
      }
   		
      public static int[][] read(String filename) throws FileNotFoundException
      {
         Scanner infile=new Scanner(new File(filename));
         int[][] map=new int[infile.nextInt()][infile.nextInt()];
         for(int i=0;i<map.length;i++)
            for(int k=0;k<map[i].length;k++)
               map[i][k]=infile.nextInt();
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