   import java.util.*;
   public class McRonaldPriorityQueue_6_Xie
   {
      public static void main(String [] args)
      {
         HeapPriorityQueue_6_Xie<Customer> line=new HeapPriorityQueue_6_Xie<Customer>();
         Customer[] service={null,null,null};
         ArrayList<Integer> time0=new ArrayList<Integer>();
         ArrayList<Integer> time1=new ArrayList<Integer>();
         ArrayList<Integer> time2=new ArrayList<Integer>();
         ArrayList<Integer> time3=new ArrayList<Integer>();
         for(int j=1;j<=18*60;j++)
         {
            if(Math.random()<0.5)
            {
               line.add(new Customer(j));
            }
            for(int i=0;i<service.length;i++)
               if(service[i]==null&&!line.isEmpty())
               {
                  service[i]=line.remove();
                  service[i].setStart(j);
               }
            for(int i=0;i<service.length;i++)
               if(service[i]!=null&&service[i].ready(j))
               {
                  int grade=service[i].getID();
                  if(grade==0)
                     time0.add(service[i].getServed(j));
                  if(grade==1)
                     time1.add(service[i].getServed(j));
                  if(grade==2)
                     time2.add(service[i].getServed(j));
                  if(grade==3)
                     time3.add(service[i].getServed(j));
                  service[i]=null;
               }
         }
         int finish=18*60+1;
         while(!line.isEmpty())
         {
            for(int i=0;i<service.length;i++)
               if(service[i]==null)
               {
                  service[i]=line.remove();
                  service[i].setStart(finish);
               }
            for(int i=0;i<service.length;i++)
               if(service[i]!=null&&service[i].ready(finish))
               {
                  int grade=service[i].getID();
                  if(grade==0)
                     time0.add(service[i].getServed(finish));
                  if(grade==1)
                     time1.add(service[i].getServed(finish));
                  if(grade==2)
                     time2.add(service[i].getServed(finish));
                  if(grade==3)
                     time3.add(service[i].getServed(finish));
                  service[i]=null;
               }
            finish++;
         }
         System.out.println("Grade\tTotalServed\tLongestWait\tAverageWait");
         double sum=0;
         int max=0;
         for(int i:time0)
         {
            sum+=i;
            if(i>max)
               max=i;
         }
         System.out.println("Senior\t"+time0.size()+"\t\t"+max+"\t\t"+(sum/time0.size()));
         sum=0;
         max=0;
         for(int i:time1)
         {
            sum+=i;
            if(i>max)
               max=i;
         }
         System.out.println("Junior\t"+time1.size()+"\t\t"+max+"\t\t"+(sum/time1.size()));
         sum=0;
         max=0;
         for(int i:time2)
         {
            sum+=i;
            if(i>max)
               max=i;
         }
         System.out.println("Soph\t"+time2.size()+"\t\t"+max+"\t\t"+(sum/time2.size()));
         sum=0;
         max=0;
         for(int i:time3)
         {
            sum+=i;
            if(i>max)
               max=i;
         }
         System.out.println("Fresh\t"+time3.size()+"\t\t"+max+"\t\t"+(sum/time3.size()));
      }
   }
   class Customer implements Comparable<Customer>
   {
      private int arrive;
      private int wait;
      private int start;
      private int id;
      public Customer(int arrive)
      {
         Random gen=new Random();
         id=gen.nextInt(4);
         this.arrive=arrive;
         wait=(int)(Math.random()*6)+2;
         start=0;
      }
      public boolean ready(int time)
      {
         if(time-start==wait)
            return true;
         return false;
      }
      public int getID()
      {
         return id;
      }
      public int getServed(int time)
      {
         return time-arrive;
      }
      public String toString()
      {
         return arrive+"";
      }
      public void setStart(int time)
      {
         start=time;
      }
      public int compareTo(Customer c)
      {
         if(id>c.getID())
            return 1;
         if(id==c.getID())
            return 0;
         if(id<=c.getID())
            return -1;
         return -1;
      }
   }
   