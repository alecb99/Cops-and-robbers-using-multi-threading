import java.awt.Graphics;
public class RobberCar extends Car{
	private double rx;
	private double ry;
	private boolean caught = false;
	private boolean escaped = false;
	static int numCaptured = 0;
	static int numEscaped = 0;
	
	public RobberCar()
	{
		super("red-car.jpg", "robber-car", 30, 5000, 4);//giving the description for the robber car and its gas tank, max speed and mpg
		super.fillUp();
		rx = Math.random()*(11)-5; 
		ry = Math.random()*(11)-5;
	}
	public void updateImage(Graphics g) {
		//drive(40,rx,ry);//same explanation I gave in the copcar
		super.updateImage(g);
	}
	public void updateState()
	{	
		//drive(4,rx,ry);
	}
	
	public void updateScene(int width, int height)
	{

		drive(4,rx,ry);
			if((getX() < -60 ||  width < height	|| getY() < -60 ||  height < getY()) && isEscaped() == true)
			{
				escaped = true;

			}
		}
	
	
	public void captured()
	{
		isCaptured();
		super.setImage("jail.jpg");
		caught = true;
		
		super.stopCar();

	}
	
	public boolean isCaptured()
	{
		if(caught == false)
		{
		numCaptured++;
		return true;
		
		}
		else
		return false;
		
	
	}
	
	public boolean isEscaped()
	{
		if(escaped == false)
		{
			numEscaped++;
			return true;

		}
		else
		 return false;
		
	}
}
