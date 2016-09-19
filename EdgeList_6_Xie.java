//Name:   Date:
//Graphs, Lesson #2

   import java.util.*;
   import java.io.*;
   class Vertex 
   {
      private final String name;
      private List<Vertex> edges = new ArrayList<Vertex>();
      Vertex()
      {
         name = null;
      }
      Vertex(String str)
      {
         name = str;
      }
      public void addEdge( Vertex c ) 
      {
         edges.add( c );
      }
      public void removeEdge( Vertex c )
      {
         edges.remove( c );
      } 
      public String getName()
      {
         return name;
      } 
      public List<Vertex> getEdges()
      {
         return edges;
      }
      public String toString()
      {
         String temp = name + "-->" ;
         for(Object v : edges)
            temp += ((Vertex)v).name+" ";
         return temp;
      }
   }
   
   public class EdgeList_6_Xie
   {  
      public static void main(String[] args)throws FileNotFoundException
      {
         System.out.println("Edge List Representation! ");
         List<Vertex> vertices = read();
      //   List<Vertex> vertices = read2();
         System.out.println(vertices);				//let's look at it first
         System.out.println();     
         for (Vertex v : vertices)
            System.out.println( findReachableDepth(v) );
            //System.out.println( findReachableBreadth(v) );
      		//System.out.println ( findReachableRecur(v) );
      }
      
   
      
      public static List<Vertex> read() 
      {
         List<Vertex> vertices=new ArrayList<Vertex>();
         Vertex Pendleton = new Vertex("Pendleton");
         Vertex Pensacola = new Vertex("Pensacola");
         Vertex Peoria = new Vertex("Peoria");
         Vertex Phoenix = new Vertex("Phoenix");
         Vertex Pierre = new Vertex("Pierre");
         Vertex Pittsburgh = new Vertex("Pittsburgh");
         Vertex Princeton = new Vertex("Princeton");
         Vertex Pueblo = new Vertex("Pueblo");
         Pendleton.addEdge(Pueblo);
         Pensacola.addEdge(Phoenix);
         Peoria.addEdge(Pueblo);
         Peoria.addEdge(Pittsburgh);
         Phoenix.addEdge(Pittsburgh);
         Phoenix.addEdge(Pueblo);
         Pierre.addEdge(Pendleton);
         Pittsburgh.addEdge(Pensacola);
         Princeton.addEdge(Pittsburgh);
         Pueblo.addEdge(Pierre);
         vertices.add(Pendleton);
         vertices.add(Pensacola);
         vertices.add(Peoria);
         vertices.add(Phoenix);
         vertices.add(Pierre);
         vertices.add(Pittsburgh);
         vertices.add(Princeton);
         vertices.add(Pueblo);
         return vertices;
      
      }
     
      public static List<Vertex> read2() throws FileNotFoundException
      {
         Scanner keyboard = new Scanner(System.in);  
         System.out.println("List of Cities: ");
			String s=keyboard.nextLine();
         Scanner cities = new Scanner(new File(s));
         System.out.println("Adjacency Matrix: ");
			String s1=keyboard.nextLine();
         Scanner matrix = new Scanner(new File(s1));
         List<Vertex> list=new ArrayList<Vertex>();
			while(cities.hasNext())
				list.add(new Vertex(cities.nextLine()));
			for(int i=0;i<matrix.nextInt();i++)
				for(int k=0;k<matrix.nextInt();k++)
					if(matrix.nextInt()==1)
						list.get(i).addEdge(list.get(k));
			return list;
      }
      public static List<Vertex> findReachableDepth(Vertex v)
      {
         Stack<Vertex> st=new Stack<Vertex>();
         List<Vertex> list=new ArrayList<Vertex>();
         st.push(v);
         while(!st.empty())
         {
            Vertex a=st.pop();
            list.add(a);
            for(Vertex x:a.getEdges())
            {
               if(!list.contains(x))
                  st.push(x);
            }
         }
			return list;
      }
    // xiexieeric@gmail.com   public static List<Vertex> findReachableBreadth(Vertex v)
   //       {
   //       
   //       }
   //        public static List<Vertex> findReachableRecur(Vertex v)
   //       {
   //          ArrayList<Vertex> reachable = new ArrayList<Vertex>();
   //          findReachableRecurHelper(v, reachable);
   //          return reachable;
   //       }  
   //    	
   //        private static void findReachableRecurHelper(Vertex v, ArrayList<Vertex> reachable)
   //       {
   //       
   //       }
   }