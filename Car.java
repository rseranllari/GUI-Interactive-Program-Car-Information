//Car.java
//Car class used object of GasTank and Engine
//Sets up the car description, the maximum capacity of tank, and an Engine object. 
public class Car {
	
	private String description;
	private int X = 0;
	private int Y = 0; 
	private GasTank tank;
	private Engine engine;
	
	
	public Car(String description, int maxFuel, Engine engine1) {
		if (description.length() == 0) {
			this.description = "Generic car";
		}
		else {
			this.description = description;
		}
		
		tank = new GasTank(maxFuel); 
		
		if (engine1 == null) {
			engine = new Engine("", 0, 0);
		}
		else {
			engine = new Engine(engine1.getEngineType(), engine1.getMpg(), engine1.getMaxSpeed());
		}
	}
	
	public String getDescription() {
		String value =  description + "(engine: "  + engine.getDescription() + "), fuel: " + String.format("%.2f", tank.getLevel()) + "/" + String.valueOf(tank.getCapacity())
			+ ", location: " + String.valueOf(X) + ", " + String.valueOf(Y) + ")"; 
		
		return value; 
	}
	
	public int getX() {
		return X;
	}
	
	public int getY() {
		return Y;
	}
	
	public double getFuelLevel() {
		return tank.getLevel();
	}
	
	public int getMPG() {
		return engine.getMpg(); 
	}
	
	public void fillUp() {
		tank.setLevel(tank.getCapacity());
	}
	
	public int getMaxSpeed() {
		return engine.getMaxSpeed(); 
	}
	
	public double drive(int distance, double xRatio, double yRatio) {
		//int x1 = X;
		//int y1 = Y; 
		
		double maxDistance = engine.getMpg() * tank.getLevel();
		
		
		if (distance < maxDistance) {
			tank.setLevel(tank.getLevel() - ((double)distance / (double)engine.getMpg()));
			X += (((xRatio / (double)Math.sqrt((xRatio * xRatio) + (yRatio * yRatio))) * distance)); 
			Y += (((yRatio / (double)Math.sqrt((xRatio * xRatio) + (yRatio * yRatio))) * distance));
			return distance; 	
		}
		else {
			tank.setLevel(0.00);
			X += (((xRatio / Math.sqrt((xRatio * xRatio) + (yRatio * yRatio))) * maxDistance)); 
			Y += (((yRatio / Math.sqrt((xRatio * xRatio) + (yRatio * yRatio))) * maxDistance)); 
			System.out.printf("The car ran out of gas after driving %.2f%n", maxDistance);
			return maxDistance; 
			
		}
	}

}