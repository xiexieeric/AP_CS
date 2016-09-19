// name:        date: 
   import java.util.*;
   import java.io.*;
   public class Huffman_6_Xie
   {
      public static void main(String[] args) throws IOException
      {
         System.out.print("Enter message: ");
         Scanner keyboard = new Scanner(System.in);
         String message = keyboard.nextLine();
         HashMap<String, Integer> frequency = new HashMap<String, Integer>();
         for(int i = 0; i < message.length(); i++)
         {
            String s = message.charAt(i) + "";
            if(frequency.containsKey(s))
               frequency.put(s, frequency.get(s)+1);
            else
               frequency.put(s, 1);
         }
         PriorityQueue<HuffmanTreeNode> q = new PriorityQueue<HuffmanTreeNode>();
         for(String s : frequency.keySet())
         {
            q.add(new HuffmanTreeNode(s, frequency.get(s)));
         }
         while(q.size() > 1)
         {
            HuffmanTreeNode n1 = q.remove();
            HuffmanTreeNode n2 = q.remove();
            q.add(new HuffmanTreeNode("*", n1.getFreq() + n2.getFreq(), n1, n2));
         }
         HuffmanTreeNode root = q.remove();
         String encode = "";
         for(int i = 0; i < message.length(); i++)
            encode+= code(root, "" + message.charAt(i));
         System.out.println("Desired filename: ");
         String filename = keyboard.nextLine();
         PrintStream outputCode = new PrintStream(new FileOutputStream(new File("message." + filename + ".txt")));
         outputCode.println(encode);
         PrintStream outputScheme = new PrintStream(new FileOutputStream(new File("scheme." + filename + ".txt")));
         for(String s : frequency.keySet())
            outputScheme.println(s + code(root, s));
   
      }
		private static String code(HuffmanTreeNode root, String target)
      {
         if(root == null || root.getString().equals(target))
            return "";
         if(find(root.getLeft(), target))
            return "0" + code(root.getLeft(), target);
			else
         	return "1" + code(root.getRight(), target);
      }
      private static boolean find(HuffmanTreeNode root, String target)
      {
         if(root == null)
            return false;
         if(root.getString().equals(target))
         {
            return true;
         }
         if(find(root.getLeft(), target))
				return true;
         if(find(root.getRight(), target))
         	return true;
			return false;
      }

   }
   
	 
   class HuffmanTreeNode implements Comparable<HuffmanTreeNode>
   {
      private String str;
      private int freq;
      private HuffmanTreeNode left;
      private HuffmanTreeNode right;
   		
      public HuffmanTreeNode(String s, int f)
      {
         str = s;
         freq = f;
         left = right = null;
      }
      public HuffmanTreeNode(String s, int f, HuffmanTreeNode s1, HuffmanTreeNode s2)
      {
         str = s;
         freq = f;
         left = s1;
         right = s2;
      }
   
      public String getString()
      {	
         return str;
      }
      public int getFreq()
      {
         return freq;
      }			
      public HuffmanTreeNode getLeft()
      {
         return left;
      }
      public HuffmanTreeNode getRight()
      {
         return right;
      }
      public void setString(String s)
      {
         str = s;
      }
      public void setFrequency(int n)
      {
         freq = n;
      }
      public void setLeft(HuffmanTreeNode s)
      {
         left = s;
      }
      public void setRight(HuffmanTreeNode s)
      {
         right = s;
      }
   		
      public int compareTo(HuffmanTreeNode s)
      {
         if(freq > s.getFreq())
         {
            return 1;
         }
         if(freq < s.getFreq())
         {
            return -1;
         }
         return 0;
      }
      public boolean equals(HuffmanTreeNode s)
      {
         return compareTo(s) == 0;
      }
   		
      public String toString()
      {
         return str + ":" + freq;
      }
   	
   
   }
