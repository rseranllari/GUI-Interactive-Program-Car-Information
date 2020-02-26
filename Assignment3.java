
import javax.swing.JFrame; 
import javax.swing.JOptionPane; 

//Assignment3.java
//The class has a main method, and asks the user for information about their car. 
//At the end it displays information on a graph. 
public class Assignment3 {
	
	public static void main (String [] args) {
		
		//Getting the car's description
		String carDescription = JOptionPane.showInputDialog("Please, enter the car's description"); 
		
		//getting the tank's capacity
		//check if less than 0, or if not right type input
		int tankCapacity = 0; 
		do {
			String tankCapacityString = JOptionPane.showInputDialog("Please, enter the fuel tank capacity");
			try {
				tankCapacity = Integer.parseInt(tankCapacityString); 
			} 
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Wrong data entered. Exiting");
				System.exit(0); 
			}
		}while (tankCapacity < 0); 
		
		//getting the engine's description
		String engineDescription = JOptionPane.showInputDialog("Please, enter the engine's description");
		
		//getting the MPG
		//check if it less than 0 or not right type input
		int MPG = 0;
		do {
			String MPGString = JOptionPane.showInputDialog("Please, enter the miles per gallon");
			try {
				MPG = Integer.parseInt(MPGString); 
			} 
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Wrong data entered. Exiting");
				System.exit(0); 
			}
		}while(MPG < 0);
		
		//getting the maximumin speed of the car
		//checking if max speed is less than 0, or not right type input
		int maxSpeed = 0;
		do {
			String maxSpeedString = JOptionPane.showInputDialog("Please, enter the max speed"); 
			try {
				maxSpeed = Integer.parseInt(maxSpeedString);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Wrong data entered. Exiting"); 
				System.exit(0);
			}
		}while(maxSpeed < 0); 
		
		//creating a new engine object
		Engine engine = new Engine(engineDescription, MPG, maxSpeed);
		
		//creating a new car object
		Car car = new Car(carDescription, tankCapacity, engine); 
		
		//printing out the message with the car description
		JOptionPane.showMessageDialog(null, car.getDescription());
		
		//Getting the number of legs for the trip
		int numberLegs = 0;
		
		do {
			String numberLegsString = JOptionPane.showInputDialog("Please, enter the number of legs on the trip");
			try {
				numberLegs = Integer.parseInt(numberLegsString);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Wrong data entered. Exiting");
				System.exit(0);
			}
		}while(numberLegs <= 0 || numberLegs > 10);
		
		//filling up the car
		car.fillUp();
		
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(600, 600);
		
		int x[] = new int[numberLegs + 1]; 
		int y[] = new int[numberLegs + 1];
		
		for (int index = 1; index <= numberLegs; index++) {
			
			x[index - 1] = car.getX();
			y[index - 1] = car.getY();
			
		
			//getting the distance for leg at int index
			int distance = 0;
			do {
				String distanceString = String.format("Please, enter the distance for leg %d", index);
				distanceString = JOptionPane.showInputDialog(distanceString); 

				try {
					distance = Integer.parseInt(distanceString);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Wrong data entered. Exiting");
					System.exit(0);
				}
			}while(distance < 0); 
			
			
			String legOneString = String.format("Please, enter the x ratio for leg %d", index);
			
			legOneString = JOptionPane.showInputDialog(legOneString); 
			double legOne = 0; 
			try {
				legOne = Double.parseDouble(legOneString);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Wrong data entered. Exiting");
				System.exit(0);
			}
			
			String legTwoString = String.format("Please, enter the y ratio for leg %d", index);
			
			legOneString = JOptionPane.showInputDialog(legTwoString); 
			double legTwo = 0; 
			try {
				legTwo = Double.parseDouble(legOneString);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Wrong data entered. Exiting");
				System.exit(0);
			}
			
			car.drive(distance, legOne, legTwo);
			
		
		}
		
		x[numberLegs] = car.getX();
		y[numberLegs] = car.getY();
		
		
		DrivePanel panel = new DrivePanel(x, y, numberLegs + 1);
		application.add(panel);
		application.setVisible(true);
		
		
	}

}