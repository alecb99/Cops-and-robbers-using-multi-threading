import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


class Sprite
{
	//private  String jpgName;
	private int locationX;
	private int locationY;
	private Image image;

	public Sprite(String jpgName)//allows the program to take in the different jpgs
	{
		setImage(jpgName);
		locationX = 0;
		locationY = 0;
	}
	
	public int getX() {	return locationX; }
	public int getY() {	return locationY; }
	public void setX(int x) { locationX = x; }
	public void setY(int y) { locationY = y; }
	
	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }	
	
	public void updateImage(Graphics g) {

		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
	
	public void updateState()
		{
		
		}
	public void updateScene(int width, int height)
	{
		
	}
	
	public boolean overlaps(Sprite s)
	{
		boolean flag = false; 
		
		if(getX() < s.getX() + 60 && getX() + 60 > s.getX() && getY() < s.getY() + 60 && getY() + 60 > s.getY())
		{
			flag = true; 
		}
		return flag;
	}
	}