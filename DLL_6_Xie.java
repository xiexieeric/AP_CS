// name:    date:
   public class DLL_6_Xie
   {
      public static void main(String args[])
      {
         DLL list = new DLL();	
      
         list.addLast("Apple");
         list.addLast("Banana");
         list.addLast("Cucumber");
         list.addLast("Dumpling");
         list.addLast("Escargot");
         System.out.println(list);
         System.out.println(list.size());
         Object obj = list.remove(3);
         System.out.println(list);
         System.out.println(list.size());
         System.out.println("Removed "+ obj);
         System.out.print("Add at 3:   ");
         list.add(3,"Cheese");
         System.out.println(list);
         System.out.print("Add first:  ");
         list.addFirst("Anchovie");
         System.out.println(list);
         System.out.println(list.size());
      }
   }

//////////////////////////////////////////////////////////
    
   class DLL        //DoubleLinkedList
   {
      private int size;
      private DLNode head = new DLNode(); //dummy node--very useful--simplifies the code
   
      public int size()
      {
         return size;
      }
    	/* appends obj to end of list; increases size;
   	  @return true  */
      public boolean add(Object obj)
      {
         DLNode insert = new DLNode(obj,null,null);
         DLNode last = head;
         while(last.getNext()!=head)
            last = last.getNext();
         insert.setPrev(last);
         insert.setNext(head);
         last.setNext(insert);
         head.setPrev(insert);
         size++;
         return true;		
      }
      /* inserts obj at position index.  increments size. 
   		*/
      public void add(int index, Object obj)
      {	
         DLNode temp = new DLNode(obj,null,null);
         DLNode next = head.getNext();
         DLNode prev = head;
         for(int i = 1; i < index; i++)
         {
            next = next.getNext();
            prev = prev.getNext();
         }
         prev.setNext(temp);
         temp.setNext(next);
         temp.setPrev(prev);
         next.setPrev(temp);
         size++;    
      }
      /* return obj at position index.  
   		*/
      public Object get(int index)
      {
         for(int i = 0; i < index;i++)
            head = head.getNext();
         return head.getValue();
      }
    /* replaces obj at position index.  
   		*/
      public void set(int index, Object obj)
      {
         for(int i = 0; i < index;i++)
            head = head.getNext();
         head.setValue(obj);
      }
    /*  removes the node from position index.  decrements size.
   	  @return the object at position index.
   	 */
      public Object remove(int index)
      {
         DLNode prev = head;
         DLNode next = head.getNext().getNext();
         DLNode current = head.getNext();
         for(int i = 0; i < index-1; i++)
         {
            prev = prev.getNext();
            current = current.getNext();
            next = next.getNext();
         }
         next.setPrev(prev);
         prev.setNext(next);
         size--;
         return current.getValue();
      }
    /* inserts obj at front of list; increases size;
   	  */
      public void addFirst(Object obj)
      {
         DLNode insert = new DLNode(obj,null,null);
         DLNode prev = head;
         DLNode next = head.getNext();
         insert.setNext(next);
         prev.setNext(insert);
         next.setPrev(prev);
         size++;
      
      }
   	/* appends obj to end of list; increases size;
   	    */
      public void addLast(Object obj)
      {
         DLNode insert = new DLNode(obj,null,null);
         DLNode last = head;
         while(last.getNext()!=head)
            last = last.getNext();
         insert.setPrev(last);
         insert.setNext(head);
         last.setNext(insert);
         head.setPrev(insert);
         size++;
      }
      public Object getFirst()
      {
         return head.getNext().getValue();
      }
      public Object getLast()
      {
         return head.getPrev().getValue();
      }
      public Object removeFirst()
      {
         DLNode prev = head;
         DLNode next = head.getNext().getNext();
         next.setPrev(prev);
         prev.setNext(next);
         size--;
         return head;
      }
      public Object removeLast()
      {
         DLNode prev = head.getPrev().getPrev();
         DLNode next = head;
         next.setPrev(prev);
         prev.setNext(next);
         size--;                
         return head;
      }
      public String toString()
      {
         DLNode temp = head;
         String s = ""; 
         temp = temp.getNext();         
         while(temp!= head)
         {
            if(temp.getValue() != null)
               s = s + temp.getValue()+ " ";
            temp = temp.getNext();
         }
                       
         return s;
      }
   }
	
	///////////////////////////////////////

	  
   class DLNode 
   {
      private Object value;
      private DLNode prev;
      private DLNode next;
      public DLNode(Object arg, DLNode p, DLNode n)
      {
         value=arg;
         prev=p;
         next=n;
      }
      public DLNode()
      {
         value=null;
         next=this;
         prev=this;
      }
      public void setValue(Object arg)
      {
         value=arg;
      }
      public void setNext(DLNode arg)
      {
         next=arg;
      }
      public void setPrev(DLNode arg)
      {
         prev=arg;
      }
      public DLNode getNext()
      {
         return next;
      }
      public DLNode getPrev()
      {
         return prev;
      }
      public Object getValue()
      {
         return value;
      }
   }
