   //Name:      Date:
   import java.util.*;

 	/***********************************
	Represents a binary expression tree.
	The BXT can build itself from a postorder expression.  It can
	evaluate and print itself. It also prints an inorder string and a preorder string.  
	************************************/
   class BXT
   {
      private int count;
      private TreeNode root;
   
      public BXT()
      {
         count = 0;
         root = null;
      }
      public BXT(Object obj)
      {
         count = 1;
         root = new TreeNode(obj, null, null);
      }
      /***********************
   	Builds a BXT from a postfix expression.  Uses a helper stack of TreeNodes.
   	****************************/
      public void buildTree(String str)
      {
         Stack<TreeNode> st = new Stack<TreeNode>();
			StringTokenizer tokens = new StringTokenizer(str);
         while(tokens.hasMoreTokens())
         {
            String current = tokens.nextToken();
            if(!isOperator(current))
               st.push(new TreeNode(current));
            else if(isOperator(current))
            {
               TreeNode right = (TreeNode)st.pop();
               TreeNode left = (TreeNode)st.pop();
               TreeNode node = new TreeNode(current, left, right);
               st.push(node);
            }
         }
			root=(TreeNode)st.pop();
      }
      public double evaluateTree()
      {
         return evaluateNode(root);
      }
      private double evaluateNode(TreeNode root)  //recursive
      {
         if(isOperator((String)root.getValue()))
         {
            double a=evaluateNode(root.getLeft());
            double b=evaluateNode(root.getRight());
            return computeTerm((String)root.getValue(), a,b);
         }
         else
            return Double.parseDouble((String)root.getValue());
      }
      private double computeTerm(String s, double a, double b)
      {
         if(s.equals("+"))
            return a + b;
         if(s.equals("-"))
            return a - b;
         if(s.equals("*"))
            return a * b;
         if(s.equals("/"))
            return a / b;
         return 0;
      }
      private boolean isOperator(String s)
      {
         if(s.length()>1)
            return false;
         String operators="+-*/";
         if(operators.contains(s))
            return true;
         return false;
      }
     //display() from TreeLab01
	  public void display()
	  {
	  	display(root,0);
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
   
     // inorder traverse
	  public void inorderTraverse()
	  {
	  	inorderTraverse(root);
	  }
      public static void inorderTraverse(TreeNode t)
      {
         if(t==null)
            return;
         inorderTraverse(t.getLeft());
         System.out.print(t.getValue()+" ");
         inorderTraverse(t.getRight());
      }
     // preorder traverse
	  public void preorderTraverse()
	  {
	  	preorderTraverse(root);
	  }
      public static void preorderTraverse(TreeNode t)
      {
         if(t == null)
         {
            return;
         }
         System.out.print(t.getValue() + " ");  //preorder visit   
         preorderTraverse(t.getLeft());         //recurse left
         preorderTraverse(t.getRight());        //recurse right
      }
   }
	
	/*******************
	Driver for a binary expression tree class.
	Input: a postfix string, each token separated by a space.
	**********************/
   public class BXT_6_Xie
   {
      public static void main(String[] args)
      {
         BXT tree = new BXT();
         Scanner sc = new Scanner(System.in);
         System.out.print("Input postfix string: ");
         String s =  sc.nextLine();   // 14 -5 / ,   3 4 5 + *  ,  2 3 + 5 / 4 5 - *
         tree.buildTree(s);
         tree.display();
         System.out.print("Infix order:  ");
         tree.inorderTraverse();
         System.out.print("\nPrefix order:  ");
         tree.preorderTraverse();
         System.out.print("\nEvaluates to " + tree.evaluateTree());
      }
   }
	
