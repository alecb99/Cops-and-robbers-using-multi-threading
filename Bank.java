import java.awt.Graphics;

public class Bank extends Sprite{

	public Bank() {
		
		super("bank.png");
		setX(300);
		setY(300);
	}
	
	public void updateImage(Graphics g) {
		//super.setX(super.getX() + 1);
		//super.setY(super.getY() + 1);
		super.updateImage(g);
	}

}
