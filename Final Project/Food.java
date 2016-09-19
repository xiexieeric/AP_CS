public class Food implements Edible
{
	private String name;
	private double price;
	
	public Food(String s,double d)
	{
		name=s;
		price=d;
	}
	public String getName()
	{
		return name;
	}
	public double getPrice()
	{
		return price;
	}
	public void setName(String s)
	{
		name=s;
	}
	public void setPrice(double d)
	{
		price=d;
	}
	public String toString()
	{
		return name+"      $"+price;
	}
}