import java.awt.Point;
import java.awt.Color;

public class Ball
{
	private int radius;
	private Point p;
	private Color colour;
	public Ball(int x, int y, int radius, Color colour)
	{
		this.radius = radius;
		p = new Point(x,y);
		this.colour = colour;
	}
	public Ball()
	{
		this(0,0,10,Color.black);
	}
	public void setColour(Color colour)
	{
		this.colour=colour;
	}
	public Color getColour()
	{
		return this.colour;
	}
	public void setRadius(int radius)
	{
		this.radius=radius;
	}
	public int getRadius()
	{
		return this.radius;
	}
	public void setPoint(Point p)
	{
		this.p=p;
	}
	public Point getPoint()
	{
		return this.p;
	}

	public void move(int dx, int dy)
	{
		p.x += dx;
		p.y += dy;
	}
}