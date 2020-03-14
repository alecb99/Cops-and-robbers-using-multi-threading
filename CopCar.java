import java.awt.Graphics;
public class CopCar extends Car{
	private  double rx;
	private  double ry;

	
	public CopCar()
		{
		super("cop-car.jpg", "cop", 30, 5000, 2);//giving the description for the cop car and its gas tank, max speed and mpg
		super.fillUp();
        rx = Math.random()*(11)-5; //random function i found online for the x and y coordinates
		ry = Math.random()*(11)-5;

	}
	public void updateImage(Graphics g) {

		//super.drive(20,rx,ry);//calling the car class using the super method and giving its distance as well as passing in x and y coordinates 
		super.updateImage(g);
	}
	public void updateState()
	{
		super.drive(2,rx,ry);
	}
	public void updateScene(int width, int height)
	{
		
		if (super.getX() > width || super.getX() < 0)
		{
			rx = rx*(-1);

		}
		if (super.getY() > height || super.getY() < 0)
		{
			ry = ry*(-1);

		}

		}
	}

