   //Name:      Date:
   import java.util.Scanner;
	/****************************************************************
	Practice with a Binary Search Tree. Uses TreeNode.
		Prompt the user for an input string.  Build a Binary Search Tree 
	using Comparables.  Display it as a sideways tree (take the code 
	from TreeLab).  Prompt the user for a target and delete that node, if it
	exists. 
	*****************************************************************/
   public class BinarySearchTreeDelete_6_Xie
   {
      public static void main(String[] args)
      {
         Scanner sc = new Scanner(System.in);
         System.out.print("Input string: ");
         String s = sc.nextLine();
      								//Case 1:  		ECSBPWANR 
      								//Case 2a:  	SNTPOR    
      								//Case 2b:	   HBRNVJSZIK  
      								//Case 3.a.i:  DBNACFSEJHM 
      								//Case 3.a.ii: NFSAKPXGQ 
      								//Case 3b:     RNVGPCAE  
         TreeNode t = null;
         for(int x = 0; x<s.length(); x++)
            t = insert(t, s.substring(x, x+1));
         display(t, 0);
      
         System.out.print("Delete? ");
         String target = sc.next();
         if(delete(t, target))
            System.out.println("\n" + target+" deleted.");
         else
            System.out.println("\n" + target+" not found");
         display(t, 0);        
      }
      
      public static TreeNode insert(TreeNode t, String s)
      {  	
         if(t==null)
         {
            t=new TreeNode(s);
         }
         else
         {
            if(s.compareTo((String)t.getValue()) <= 0)
            {
               t.setLeft(insert(t.getLeft(),s));
            }
            else
            {
               t.setRight( insert(t.getRight(),s));
            }
         }
         return t;
      }
      
      public static void display(TreeNode t, int level)
      {
         if(t == null)
            return;
         display(t.getRight(), level + 1); //recurse right
         for(int k = 0; k < level; k++)
            System.out.print("\t");
         System.out.println(t.getValue());
         display(t.getLeft(), level + 1); //recurse left
      }
   	
      private static boolean delete(TreeNode current, Object target)
      {
			boolean side=true;
			if(current==null)
				return false;
         TreeNode parent = null;
         int compare=100;
			while(compare!=0)
			{
				if(current==null)
					return false;
				compare = ((Comparable)target).compareTo(current.getValue());
				if(compare<0)
				{
					parent=current;
					current=current.getLeft();
					side=true;
				}
				if(compare>0)
				{
					parent=current;
					current=current.getRight();
					side=false;
				}
			}
			if(current.getLeft()==null&&current.getRight()==null)
			{
				if(side)
					parent.setLeft(null);
				else
					parent.setRight(null);
				return true;
			}
			if(current.getLeft()==null&&current.getRight()!=null)
			{
				if(side)
					parent.setLeft(current.getRight());
				else
					parent.setRight(current.getRight());
				return true;
			}
			if(current.getLeft()!=null&&current.getRight()==null)
			{
				if(side)
					parent.setLeft(current.getLeft());
				else
					parent.setRight(current.getLeft());
				return true;
			}
			if(current.getLeft()!=null&&current.getRight()!=null)
			{
				current.setValue(min(current.getRight()).getValue());
				deleteHelper(current.getRight(),current.getValue(),current);
				return true;
			}         
         return false;  //never reached
      }
		public static void deleteHelper(TreeNode current, Object target, TreeNode prev)
		{
         TreeNode parent = prev;
         int compare=100;
			while(compare!=0)
			{
				compare = ((Comparable)target).compareTo(current.getValue());
				if(compare<0)
				{
					parent=current;
					current=current.getLeft();
				}
				if(compare>0)
				{
					parent=current;
					current=current.getRight();
				}
				
			}
			if(current.getLeft()==null&&current.getRight()==null)
			{
				compare = ((Comparable)target).compareTo(parent.getValue());
				if(compare<0)
					parent.setLeft(null);
				else
					parent.setRight(null);
			}

		}
		public static TreeNode min(TreeNode root)
		{
			TreeNode temp=root;
			while(temp.getLeft()!=null)
				temp=temp.getLeft();
			return temp;
		}
   }