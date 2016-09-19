//Name:     Date:
//Graphs, Lesson #4

   import java.util.*;
   import java.io.*;

   class wVertex implements Comparable<wVertex>
   {
      private final String name;
      private Map<wVertex , Integer> edges = new HashMap<wVertex , Integer>();
      private int minDistance = Integer.MAX_VALUE;
       
      public wVertex( String city )
      {
         name = city;
      }
      public String toString() 
      {
         return name;
      }
      public void addEdge( wVertex city , Integer weight )
      {
         edges.put( city , weight );
      }
      public Map<wVertex , Integer> getEdges()
      {
         return edges;
      }
      public int getMinDistance() 
      {
         return minDistance;
      }
      public void setMinDistance(int d) 
      {
         minDistance = d;
      }
      public int compareTo( wVertex other ) 
      {
         if(getMinDistance() > other.getMinDistance() )
            return 1;
         if(getMinDistance() < other.getMinDistance() )
            return -1;
         else
            return 0;
      }
      
   }

   public class Dijkstra_6_Xie
   {
      public static void main(String[] args) throws FileNotFoundException
      {
        //  List<wVertex> vertices = read();
         List<wVertex> vertices = read2();
         int n = enterSource(vertices);    
         wVertex source = vertices.get(n); 
         computePaths(source);   
         System.out.println("Distance from "+ source.toString() );
         for (wVertex v : vertices)
         {
            System.out.print("    to " + v + ": " + v.getMinDistance() );
            System.out.println();
         }
      }
      // public static List<wVertex> read()
   //       {
   //       
   //       }
      public static List<wVertex> read2() throws FileNotFoundException
      {
         List<wVertex> list = new ArrayList<wVertex>();
         Scanner keyboard = new Scanner(System.in);  
         System.out.println("List of Cities: ");
         String s=keyboard.nextLine();
         Scanner cities = new Scanner(new File(s));
         System.out.println("Matrix: ");
         String s1=keyboard.nextLine();
         Scanner matrix = new Scanner(new File(s1));
         while( cities.hasNext())
            list.add( new wVertex( cities.nextLine() ) );
         int r = matrix.nextInt();
         int c = matrix.nextInt();
         int[][] result = new int[r][c];
         for( int i = 0; i < r; i++ )
            for( int j = 0; j < c; j++ )
               result[i][j] = matrix.nextInt();
         for(int i  = 0; i < result.length; i++ )
            for( int j  = 0; j < result[i].length; j++ )
               if( result[i][j] >= 0 && result[i][j] < 9999 )
                  list.get(i).addEdge(list.get(j) , result[i][j] );
         return list;
      }
      public static int enterSource(List<wVertex> theList)
      {
         int b = (int)( Math.random()*theList.size() );
         return b;
      }
      public static void computePaths(wVertex source)
      {
         PriorityQueue<wVertex> p = new PriorityQueue<wVertex>();
         source.setMinDistance(0);
         Map<wVertex , Integer> map = source.getEdges();
         for( wVertex w : map.keySet() )
            if( w.getMinDistance() > (map.get( w ) + source.getMinDistance() ) )
            {
               w.setMinDistance( map.get( w ) + source.getMinDistance() );
               p.add( w );
            }
         
         while( !p.isEmpty())
         {
            wVertex temp = p.remove();
            Map<wVertex , Integer> map2 = temp.getEdges();
         
            for( wVertex w : map2.keySet() )
               if( w.getMinDistance() > map2.get( w ) + temp.getMinDistance()  )
               {
                  w.setMinDistance( map2.get( w ) + temp.getMinDistance() );
                  p.add( w );
               }
         }
      }
   
      // public static List<wVertex> getShortestPathTo(wVertex target)
//       {
//       }
   }

