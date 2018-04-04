public class Circle
{
	private double radius;
	private String color;

	public Circle(double radius, String color)
	{
		this.radius = radius;
		this.color = color;
	}

	public Circle(double radius)
	{
		this.radius = radius;
	}
	
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	public double getRadius()
	{
		return this.radius;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public String getColor()
	{
		return this.color;
	}

	public double getArea()
	{
		return Math.PI*Math.pow(this.radius, 2);
	}
}