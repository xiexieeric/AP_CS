 import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.util.*;
   import java.io.*;
    public class RestaurantPanel extends JPanel
   {
      private JLabel label;
       public RestaurantPanel() throws Exception
      {
         setLayout(new BorderLayout());
         JPanel panel=new JPanel();
         panel.setLayout(new GridLayout(1,3,10,0));
         add(panel,BorderLayout.CENTER);
         label=new JLabel("Where do you want to eat?",SwingConstants.CENTER);
         label.setFont(new Font("Serif", Font.BOLD, 24));
         label.setForeground(Color.ORANGE);
         add(label,BorderLayout.NORTH);
         ImageIcon mcdonalds = new ImageIcon("images/mcdonalds.jpg");;
         ImageIcon papajohns = new ImageIcon("images/papajohns.gif");
         ImageIcon burgerking = new ImageIcon("images/burgerking.png");
         addButton(panel,mcdonalds,1);
         addButton(panel,papajohns,2);
         addButton(panel,burgerking,3);

      }
       private void addButton(JPanel panel, ImageIcon i,int x)
      {
         JButton button = new JButton(i);
         button.addActionListener(new Listener(x));
         panel.add(button);
      }
       private class Listener implements ActionListener
      {
         private int myX;
          public Listener(int x)
         {
            myX = x;
         }
          public void actionPerformed(ActionEvent e)
         {
				RestaurantDriver.frame.setContentPane(new MenuPanel(myX));
				RestaurantDriver.frame.setVisible(true);
         }
      }
   }
