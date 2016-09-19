// name:             date:

   import java.io.*;
	import java.util.Scanner;
   import javax.swing.JOptionPane;
	
    public class Josephus_6_Xie
   {
       public static void main(String[] args) throws FileNotFoundException
      {
         int size = Integer.parseInt(JOptionPane.showInputDialog("How many players?"));
         int magic = Integer.parseInt(JOptionPane.showInputDialog("Magic Number?"));
			Scanner numFile = new Scanner ( new File("numbers.txt"));
         Scanner nameFile = new Scanner ( new File("J_names.txt"));
			ListNode num= null;
         ListNode name = null;
         for (int i =0 ; i<size; i++)
         {
            num = insert (num, numFile.next());
            name =insert (name, nameFile.next());
         }
         num=num.getNext();
         print(num);
         System.out.println("");
			for (int i = 0; i<size-1; i++)
         {
            num = remove(num, magic-1);
            print(num);
            System.out.println("");
         }
			int winner = Integer.parseInt(num.getValue().toString());
      	replaceAt(name, "Josephus", winner);
      	 name=name.getNext();
         print(name);
         System.out.println("");
         for (int i = 0; i<size-1; i++)
         {
            name = remove(name, magic-1);
            print(name);
            System.out.println("");
         }
      	    
         System.exit(0);

      }
		
      /* removes the node p after counting n nodes.
		  */      
       private static ListNode remove(ListNode p, int n)
      {
         for (long x =0; x<n-1;x++)
         {
            p=p.getNext();
         }
         p.setNext(p.getNext().getNext());
         return p.getNext();
      }
		
      /* prints the circular linked list.
		  */      
       public static void print(ListNode p)
      {
      	Object a=p.getValue();
			while(p.getNext().getValue()!=a)
			{
				System.out.print(p.getValue()+",");
				p=p.getNext();
			}
			System.out.print(p.getValue()+", ");
      }
    /* helper method to build the list.  Creates the node, then
	    inserts it in the circular linked list.
		 */  
       private static ListNode insert(ListNode p, Object obj)
      {
         if (p==null)
         {
            p=new ListNode(obj,null);
            p.setNext(p);
            return p;
         }
         else
			{
            ListNode temp = new ListNode(obj, p.getNext());
            p.setNext(temp);
            return temp;
         } 
      }
   
   	
   	/* replaces the value (the string) at the winning node.
	       */	
       private static void replaceAt(ListNode p, Object obj, int pos)
      {
         for (int i =0; i<pos; i++)
         {
            p=p.getNext();
         }
         p.setValue(obj);
      }
   }