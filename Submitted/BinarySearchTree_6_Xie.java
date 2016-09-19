   import java.util.Scanner;
	/****************************************************************
	Practice with a Binary Search Tree. Uses TreeNode.
		Prompt the user for an input string.  Build a Binary Search Tree 
	using Comparables.  Display it as a sideways tree (take the code 
	from Lab01).  Prompt the user for a target and search the tree 
	for it.  Display the tree's minimum and maximum values.  Print 
	the data in order from smallest to largest.
	*****************************************************************/
   public class BinarySearchTree_6_Xie
   {
      public static void main(String[] args)
      {
         Scanner keyboard=new Scanner(System.in);
         System.out.print("Enter a string: ");
         String input=keyboard.nextLine();
			TreeNode root=null;
			for(int i=0;i<input.length();i++)
				root = insert(root,input.substring(i,i+1));
			display(root,0);
			System.out.print("Input target: ");
         String target = keyboard.nextLine();
         if(find(root,target))
				System.out.println("Found: "+target);
			else
				System.out.println(target+" not found");
         System.out.println("Min: " + min(root));
         System.out.println("Max: " + max(root));
         System.out.print("Smallest to Largest: ");
         smallToLarge(root);
        
        
        
      }
   	/**************************
   	Recursive algorithm to build a BST:  if the node is null, insert the 
   	new node.  Else, if the item is less, set the left node and recur to 
   	the left.  Else, if the item is greater, set the right node and recur 
   	to the right.   
   	*****************************/
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
   	/********************
      Iterative algorithm:  create a temporary pointer p at the root.  
   	While p is not null, if the p's value equals the target, return true.  
   	If the target is less than the p's value, go left, otherwise go right.   
   	If the target is not found, return false. 
      
   	Find the target. Recursive algorithm:  If the tree is empty, 
   	return false.  If the target is less than the current node 
   	value, return the left subtree.  If the target is greater, return 
   	the right subtree.  Otherwise, return true.   
   .    	*****************************/    
      public static boolean find(TreeNode t, Comparable x)
      {
         if(t==null)
            return false;
         Comparable c=(String)t.getValue();
         if(c.compareTo(x)<0)
            return find(t.getLeft(),x);
         if(c.compareTo(x)>0)
            return find(t.getRight(),x);
         return true;
      }
      /**************************
   	starting at the root, return the min value in the BST.   
   	Use iteration.   Hint:  look at several BSTs. Where are 
   	the min values always located?  
   	******************************/
      public static Object min(TreeNode t)
      {
         TreeNode temp=t;
			if(temp==null)
				return null;
         while(temp.getLeft()!=null)
            temp=temp.getLeft();
         return temp.getValue();
      }
      /*****************
   	starting at the root, return the max value in the BST.  
   	Use recursion!
   	********************/
      public static Object max(TreeNode t)
      {
			if(t==null)
				return null;
         if(t.getRight()==null)
            return t.getValue();
         else
            return max(t.getRight());
      	
      }
      public static void smallToLarge(TreeNode t)
      {
         if(t!= null )
         {
            smallToLarge(t.getLeft());
            System.out.print(t.getValue()+" ");
            smallToLarge(t.getRight());
         }
      
      }
   }