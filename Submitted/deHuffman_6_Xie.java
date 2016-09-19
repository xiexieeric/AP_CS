// Name:              Date:
   import java.util.Scanner;
   import java.io.*;
   public class deHuffman_6_Xie
   {
      public static void main(String[] args) throws IOException
      {
			System.out.print("Scheme filename: ");
			Scanner keyboard=new Scanner(System.in);
			String filename=keyboard.next();
			Scanner infile=new Scanner(new File(filename));
			System.out.print("Message filename: ");
			String msg=keyboard.next();
			Scanner msgFile=new Scanner(new File(msg));
			TreeNode root=huffmanTree(infile);
			System.out.println(dehuff(msgFile.nextLine(),root));
			
      }
      public static TreeNode huffmanTree(Scanner huffLines)
      {
         String code;
         String letter;
         String temp;
         TreeNode root=new TreeNode(null);
         TreeNode traversal=root;
         while(huffLines.hasNext())
         {
         	traversal=root;
            temp=huffLines.nextLine();
            letter=temp.substring(0,1);
            code=temp.substring(1);
            for(int i=0;i<code.length()-1;i++)
            {
               if(code.substring(i,i+1).equals("0"))
               {
						if(traversal.getLeft()==null)
							traversal.setLeft(new TreeNode(null));
                  traversal=traversal.getLeft();
               }
               else
               {
						if(traversal.getRight()==null)
                 		traversal.setRight(new TreeNode(null));
                  traversal=traversal.getRight();
               }	
            }
            if(code.substring(code.length()-1).equals("0"))
               traversal.setLeft(new TreeNode(letter));
            else
               traversal.setRight(new TreeNode(letter));
         }
			return root;
      	
      }
      public static String dehuff(String text, TreeNode root)
      {
			String result="";
			TreeNode originial=root;
			for(int i=0;i<text.length();i++)
			{
				if(root.getValue()!=null)
				{
					result+=root.getValue()+"";
					root=originial;
				}
				if(text.charAt(i)=='0')
					root=root.getLeft();
				if(text.charAt(i)=='1')
					root=root.getRight();
				
			}
			if(root.getValue()!=null)
			{
					result+=root.getValue()+"";
					root=originial;
			}
			return result;
      }
   }
