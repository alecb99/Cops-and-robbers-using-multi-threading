public class GasTank 
{
	private int Max_capacity;
	private double current_level;
	
	GasTank(int Max_capacity)
	{
		this.Max_capacity = Max_capacity;
		
		current_level = 0.0;
		
		if(Max_capacity < 0)
		{
			Max_capacity = 0;
		}
	}
	
	public void setLevel(double levelIn)
	{
		if(levelIn < 0.0)
		{
			levelIn = 0.0;
		}
		
		else if(levelIn >= Max_capacity)
		{
			levelIn = Max_capacity;
		}
		
			current_level = levelIn;
	}
	
	public int getCapacity()
	{
		return Max_capacity;
	}
	
	public double getLevel()
	{
		return current_level;
	}
}