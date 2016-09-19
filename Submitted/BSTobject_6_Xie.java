 //name:    date:  
   import java.util.*;
   import java.io.*;
   public class BSTobject_6_Xie
   {
      public static void main( String[] args ) throws Exception
      {
		//F Tree
         BSTobject<String> tree = new BSTobject<String>("F");
         System.out.print(tree);
            		//	System.out.print(tree.toString());
         System.out.println(tree.size());
         System.out.println(tree.isEmpty()); 
		//Input String Tree
		tree = new BSTobject<String>();
         System.out.print("Enter a string: ");
            	Scanner keyboard=new Scanner(System.in);
            	String input=keyboard.next();
            	for(int i=0;i<input.length();i++)
      				tree.add(input.substring(i,i+1));
      			System.out.print(tree);
      			System.out.println(tree.size());
		//Widget Tree
         BSTobject<Widget> wTree = new BSTobject<Widget>();
         Scanner infile=new Scanner(new File("widget.txt"));
         while(infile.hasNext())
         {
            wTree.add(new Widget(infile.nextInt(),infile.nextInt()));
         }
			System.out.print(wTree);
      	
      }
   }
   	////////////////////////////////
   class BSTobject <E extends Comparable<E>> implements BSTinterface<E>
   {
      // 2 fields 
      private Node<E> root;
      private int mySize;
      // 2 constructors, one default and one one-arg
      public BSTobject()
      {
         root=null;
         mySize=0;
      }
      public BSTobject(E element)
      {
         root=new Node(element,null,null);
         mySize=1;
      }
      
      //methods
      public E add(E element)
      {
         mySize++;
         root=insert(root,element);
         return element;
      }
      public Node<E> insert(Node<E> n,E item)
      {
         if(n==null)
            return new Node<E>(item,null,null);
         if(item.compareTo(n.getValue()) < 0)
            n.setLeft(insert(n.getLeft(), item));
         //else if the item is greater set the right node and recur to the right
         else
            n.setRight(insert(n.getRight(), item));
         return n;
      }
      public boolean isEmpty()
      {
         return root==null;
      }
      public int size()
      {
         return mySize;
      }
      public String toString()
      {
         return display(root, 0);
      }
      public String display(Node<E> t, int level)
      {
         if(t == null)
            return "";
         String s = "";
         s = display(t.getRight(), level + 1); //recurse right
         for(int k = 0; k < level; k++)
            s += "\t";
         s += t.getValue()+"\n";
         s += display(t.getLeft(), level + 1); //recurse left
         return s;      
      }
      public E remove(E element)
      {
         return removeHelper(root, element);
      }
      public E removeHelper(Node<E> current, E target)
      {
         boolean side=true;
         if(current==null)
            return null;
         Node<E> parent = null;
         int compare=100;
         while(compare!=0)
         {
            if(current==null)
               return null;
            compare = (target).compareTo(current.getValue());
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
            return target;
         }
         if(current.getLeft()==null&&current.getRight()!=null)
         {
            if(side)
               parent.setLeft(current.getRight());
            else
               parent.setRight(current.getRight());
            return target;
         }
         if(current.getLeft()!=null&&current.getRight()==null)
         {
            if(side)
               parent.setLeft(current.getLeft());
            else
               parent.setRight(current.getLeft());
            return target;
         }
         if(current.getLeft()!=null&&current.getRight()!=null)
         {
            current.setValue(min(current.getRight()).getValue());
            deleteHelper(current.getRight(),current.getValue(),current);
            return target;
         }         
         return null;  //never reached
      
      }
      public void deleteHelper(Node<E> current, E target, Node<E> prev)
      {
         Node<E> parent = prev;
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
   
      public Node<E> min(Node<E> root)
      {
         if (root.getLeft() == null)
            return root;
         else
            return min(root.getLeft());
      }
      public boolean contains( E element )
      {
         while(root!=null)
         {
            if(root.getValue()==element)
               return true;
            if(root.getValue().compareTo(element) > 0)
               root = root.getLeft();
            else
               root = root.getRight();
         }
         return false;
      }
   	
      
      
      
      /***************************private inner class **************/  
      private class Node<E>
      {
         private E value; 
         private Node<E> left, right;
      
         public Node(E initValue)
         { 
            value = initValue; 
            left = null; 
            right = null; 
         }
      
         public Node(E initValue, Node<E> initLeft, Node<E> initRight)
         { 
            value = initValue; 
            left = initLeft; 
            right = initRight; 
         }
      
         public E getValue()
         { 
            return value; 
         }
      
         public Node<E> getLeft() 
         { 
            return left; 
         }
      
         public Node<E> getRight() 
         { 
            return right; 
         }
      
         public void setValue(E theNewValue) 
         { 
            value = theNewValue; 
         }
      
         public void setLeft(Node<E> theNewLeft) 
         { 
            left = theNewLeft;
         }
      
         public void setRight(Node<E> theNewRight)
         { 
            right = theNewRight;
         }
         
         
      }
   }
	//////////////////////////////////
   interface BSTinterface<E extends Comparable<E>>
   {
      public E add( E element );     //returns the object
      public boolean contains( E element );
      public boolean isEmpty();
      public E remove( E element );  //returns the object
      public int size();
      public String toString();
   }
//////////////////////////////////