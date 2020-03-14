import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.*;
class Model
{
    //private Sprite sprite;
	private static ArrayList<Sprite> spriteA = new ArrayList<Sprite>(); 
	static int g = 0;//this is going to act as my counter variable
    
	Model(int a) throws IOException {
		synchronized(spriteA) {
		spriteA.add(new Bank());
		}
	}
    public void update(Graphics g) {
    	synchronized(spriteA) {
		
		for(int i = 0; i < spriteA.size(); i++)//simply updating the sprite array
		{
			spriteA.get(i).updateImage(g);
		}
    	}
    }
	    static void clickFunction(int x, int y)
	    {
    	if(g%2 == 1)//this statement keeps track of the clicks and allows the alternation of the cops and robbers
	    	{
	    		//Sprite pad = new Sprite("cop-car.jpg");
	    		CopCar pad = new CopCar();
	    		pad.setX(x);
		    	pad.setY(y);
		    	spriteA.add(pad); 
	    	}
	    	
	    	else { //same thing as the if statement above, just for the robber car
		    	//Sprite mouse = new Sprite("red-car.jpg"); 
	    		RobberCar mouse = new RobberCar();
	    		mouse.setX(300);
		    	mouse.setY(300);
		    	spriteA.add(mouse);
	    	} 
	       	g++;
	    }
	    /*public static void refuel()//function to refeul the cars after they have run out of gas
	    {
	    	for(int i = 0; i < spriteA.size(); i ++)
	    	{
	    		((Car) spriteA.get(i)).fillUp();
	    	}
	    }*/

	    public void updateScene(int width, int height)
	    {
	   synchronized(spriteA)
	    {
		   Iterator <Sprite> iter = spriteA.iterator();
		   while (iter.hasNext()) 
		   {
		    Sprite NextSprite = iter.next();    	
		    if(iter instanceof RobberCar)
	    	{
	    	  if (((RobberCar)NextSprite).isEscaped())
				{
	    			iter.remove();
				}
	    	}
		   }
	    	for(int i = 0; i < spriteA.size(); i++)
	    	{
	    		spriteA.get(i).updateScene(width, height);
	    		spriteA.get(i).updateState();
	    		//Sprite sprite1 = spriteA.get(i);
	    		
	    		if((spriteA.get(i) instanceof CopCar))
	    		{
	    			for(int n = 0; n < spriteA.size(); n++)
	    			{
	    				if((spriteA.get(n) instanceof RobberCar) && (spriteA.get(n).overlaps(spriteA.get(i))))
	    				{
	    					//System.out.println("Gotcha!");
	    	    			((RobberCar)spriteA.get(n)).captured(); 
	    				}
	    			}

	    		}
	    	
	    	}	
	    }
	    }
	    
	    public void initialize()
	    {
	    	synchronized(spriteA)
	    	{
	    	spriteA.clear();
	    	spriteA.add(new Bank()); 
	    	RobberCar.numCaptured = 0;
	    	RobberCar.numEscaped = 0;
	    	}
	    }
}

	    	
	    	
	    
	    

