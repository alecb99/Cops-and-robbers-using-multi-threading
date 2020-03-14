import java.awt.Graphics;
public class Car extends Sprite
{
	private String car_name;
	
	
	private GasTank gastank;
	private Engine engine;
	
	public Car(String jpgName, String carname, int max_fcapacity, int MPG, int Maxspeed)
	{
		
		super(jpgName);
		gastank = new GasTank(max_fcapacity);//creating a new gas tank for every car
		engine = new Engine("robber or cop car", MPG, Maxspeed);//creating a new engine for either car
		
		if (carname.length() == 0)
		{
			car_name = "Generic Car";
		}
			else
				car_name = carname;
		
		
		gastank = new GasTank(max_fcapacity);
		
		if (engine == null)
			{
				this.engine = new Engine(" ", 0, 0); 
			}
		else
			this.engine = engine;

		
	}

	public double getFuelLevel()
	{
		 return gastank.getLevel();
	}
	public int getMPG()
	{ 
	return engine.get_mpg();
	}
	public void fillUp()
	{
		gastank.setLevel(gastank.getCapacity());
	}
	public int getMaxSpeed()
	{
		return engine.get_max_speed();
	}
	public double drive(int distance, double xRatio, double yRatio)
	{
		double hypotenuse = Math.sqrt((xRatio*xRatio) + (yRatio*yRatio));//made the coordinates in a triangle and stored the values using pythagorean theorem into the hypotenuse
		double leftovergas = ((double)distance/engine.get_mpg());
		
		if(leftovergas <= gastank.getLevel())
			{
				gastank.setLevel(gastank.getLevel()-leftovergas);
			}
		else
			{
				distance = (int)(gastank.getLevel()*engine.get_mpg());
				gastank.setLevel(gastank.getLevel()-leftovergas);
			}
		double cardistance = distance/hypotenuse;
		
		super.setX((int)(getX()+((xRatio*cardistance))));
		super.setY((int)(getY()+((yRatio*cardistance))));
		
		return distance;
	}
	public void updateImage(Graphics g) {
		//super.setX(super.getX() + 1);
		//super.setY(super.getY() + 1);
		super.updateImage(g);
	}
	
	public void stopCar()
	{
		gastank.setLevel(0); 
		
	}

}
