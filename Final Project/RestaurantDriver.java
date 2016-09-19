   import javax.swing.JFrame;
   public class RestaurantDriver
   {
		public static JFrame frame;
      public static void main(String[] args) throws Exception
      {
         frame = new JFrame("Which Restuarant?");
         frame.setSize(1000, 1000);
         frame.setLocation(200, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new RestaurantPanel());
         frame.setVisible(true);
      }
   }