public class Engine 
{
	private String engine_type;
	private int mpg = 0;
	private int max_speed = 0;
	
	public Engine(String enginetype, int mpg1, int maxspeed)
	{

		if(enginetype.length() == 0)
			engine_type = "Generic Engine";
		else 
			engine_type = enginetype;
		
		if(mpg1 < 0)
			{
			mpg = 0;
			}
		else
			mpg = mpg1;
		
		if(maxspeed <=0)
			{
			max_speed =0;
			}
		else 
			max_speed = maxspeed;
	}
	
	public String getEngine_type()
	{
		return engine_type;
	}
	
	public int get_mpg()
	{
		return mpg;
	}
	
	public int get_max_speed()
	{
		return max_speed;
	}
	
	public String get_description()
	{
		return ("Engine is " + getEngine_type() + " mpg is " + get_mpg() + " max speed is " + get_max_speed());
		

	}
	
	public int stopCar()
	{
		max_speed = 0;
		return max_speed;
	}

}