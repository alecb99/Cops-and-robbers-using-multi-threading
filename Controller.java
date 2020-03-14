import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;


	class Controller implements MouseListener, KeyListener 
	{
	    Model model;
	    View view;
	    SpriteMover sm;

	    Controller() throws IOException, Exception {
	        model = new Model(0);
	        view = new View(this);

	    }

	    public void update(Graphics g) {
	        model.update(g);
	    }

	    public void mousePressed(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				Model.clickFunction(e.getX(),e.getY());
				view.repaint();
			}
				// Gets here is left mouse button was clicked			}
			else if (SwingUtilities.isRightMouseButton(e))  {;
				model.updateScene(view.getWidth(), view.getHeight());
				view.repaint();
			}
	    }

	    public void mouseReleased(MouseEvent e) {    }
	    public void mouseEntered(MouseEvent e) {    }
	    public void mouseExited(MouseEvent e) {    }
	    public void mouseClicked(MouseEvent e) {    }
	    
	    
	    public void keyTyped(KeyEvent e) 
	    {
	    	if(e.getKeyChar() == 'n')
	    	{
	    	System.out.println("Number of cars escaped " + RobberCar.numEscaped);
	    	System.out.println("Number of cars captured " + RobberCar.numCaptured);
	    	}
	    	if(e.getKeyChar() == 'r')
			{
				model.initialize();
				view.repaint();
			}
	    	if(e.getKeyChar() == 's')
	    	{
	    		Thread t1 = new Thread(new SpriteMover(model, view));
	    		t1.start();
	    		
	    	}
	    }

	    public static void main(String[] args) throws Exception {

	        new Controller();
	    }

		@Override
		public void keyPressed(KeyEvent h) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
