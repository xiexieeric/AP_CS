   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.util.*;
   import java.io.*;
    public class MenuPanel extends JPanel
   {
		Scanner menuScanner;
		File file;
		static JLabel[] quantity;
		static Edible[] foods;
		static JLabel sum;
       public MenuPanel(int x) throws Exception
      {
			if(x==1)
				file=new File("menus/mcdonalds.txt");
			if(x==2)
				file=new File("menus/papajohns.txt");
			if(x==3)
				file=new File("menus/burgerking.txt");
			try
			{
				menuScanner=new Scanner(file);
			}
			catch(FileNotFoundException e)
			{
				System.out.println("File Not Found!!!");
				System.exit(0);
			}
			setLayout(new GridLayout(11,2,10,0));
			sum=new JLabel("$"+0.00);
			JButton[] button=new JButton[10];
			quantity=new JLabel[10];
			foods=new Food[10];
			for(int i=0;i<foods.length;i++)
			{
				String a=menuScanner.nextLine();
				String b=menuScanner.nextLine();
				double d=Double.parseDouble(b);
				foods[i]=new Food(a,d);
				ImageIcon img=new ImageIcon("images/"+foods[i].getName()+".png");
				button[i]=addButton(button,i,img,foods[i].toString());
				quantity[i]=new JLabel(""+0);
			}
			for(int i=0;i<10;i++)
			{
				add(button[i]);
				add(quantity[i]);
			}
			add(sum);
			JButton checkout=new JButton("CHECKOUT");
			checkout.addActionListener(new Listener2());
			add(checkout);
      }
		private JButton addButton(JButton[] array,int index, ImageIcon i,String s)
      {
         array[index]=new JButton(s,i);
         array[index].addActionListener(new Listener(index));
			return array[index];
      }
       private class Listener implements ActionListener
      {
			int myX;
			
          public Listener(int x)
         {
				myX=x;
         }
          public void actionPerformed(ActionEvent e)
         {
				int current=Integer.parseInt(quantity[myX].getText());
				quantity[myX].setText(""+(current+1));
				double total=0;
				for(int i=0;i<10;i++)
				{
					total+=foods[i].getPrice()*Integer.parseInt(quantity[i].getText());
				}
				sum.setText(""+total);
         }
      }
		 private class Listener2 implements ActionListener
      {
          public Listener2() throws Exception
         {
         }
          public void actionPerformed(ActionEvent e) 
         {
			try
			{
				System.setOut(new PrintStream(new FileOutputStream("receipt.txt")));
			}
			catch(FileNotFoundException ex)
			{
				System.out.println("File Not Found!!!");
				System.exit(0);
			}

  				Calendar cal = new GregorianCalendar();
  				int month = cal.get(Calendar.MONTH);
  				int year = cal.get(Calendar.YEAR);
  				int day = cal.get(Calendar.DAY_OF_MONTH);
  				System.out.println((month+1) + "/" + day + "/" + year);
				double total=0;
				for(int i=0;i<10;i++)
				{
					if(Integer.parseInt(quantity[i].getText())==0)
						{
						}
					else
					{
						System.out.print(Integer.parseInt(quantity[i].getText())+"x ");
						System.out.print(foods[i].getName()+"\t\t");
						System.out.print((foods[i].getPrice()*Integer.parseInt(quantity[i].getText())));
						total+=foods[i].getPrice()*Integer.parseInt(quantity[i].getText());
						System.out.println();
					}
				}
				System.out.println("Your total is: $"+total);
				System.out.println("Thanks For Coming!");
				System.exit(0);
         }
      }

   }
