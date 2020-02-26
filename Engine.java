//Engine.java
//The class creates an Engine object that initilizes the engine type, MPG of the engine, and max speed
public class Engine {
	private String engineType;
	private int mpg;
	private int maxSpeed;
	
	public Engine(String engineType, int mpg, int maxSpeed) {
		if (engineType.length() == 0) {
			this.engineType = "Generic engine";
		}
		else {
			this.engineType = engineType;
		}
		
		
		if (mpg <= 0) {
			this.mpg = 0;
		}
		else {
			this.mpg = mpg;
		}
		
	
		if (maxSpeed <= 0) {
			this.maxSpeed = 0; 
		}
		else {
			this.maxSpeed = maxSpeed; 
		}
	}
	
	public String getDescription() {
		String describe = engineType + "(MPG: " + String.valueOf(mpg) + ", Max Speed: " + String.valueOf(maxSpeed) +")";
		return describe; 
	}
	
	public String getEngineType() {
		return engineType; 
	}
	
	public int getMpg() {
		return mpg;
	}
	
	public int getMaxSpeed() {
		return maxSpeed; 
	}
	

}