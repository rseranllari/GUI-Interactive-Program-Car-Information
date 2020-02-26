import java.awt.Graphics;
import javax.swing.JPanel; 

//DrivePanel.java
//Drive panel draws the lines of the trip information as well as the coordinates displayed
public class DrivePanel extends JPanel{
	int x[] = new int[10]; 
	int y[] = new int[10];
	int size; 
	
	public DrivePanel(int x[], int y[], int size) {
		this.x = x;
		this.y = y; 
		this.size = size;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int index = 1; index < size; index++) {
			
			g.drawLine(x[index -1], getHeight() - y[index -1], x[index], getHeight() - y[index]);
			
			String coordinates = String.format("(%d, %d)", x[index], y[index]);
			
			
			g.drawString(coordinates, x[index] + 10, getHeight() - y[index]);
		}
		
	}

}
