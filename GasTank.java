//GasTank.java
//The class creates an object that initializes the capacity of the tank and gas level
public class GasTank {
	private int capacity = 0; 
	private double currentLevel = 0.00; 
	
	public GasTank(int capacity) {
		if (capacity >= 0) {
			this.capacity = capacity;
		}
	}
	
	public int getCapacity() {
		return capacity; 
	}
	
	public double getLevel() {
		return currentLevel; 
	}
	
	public void setLevel(double levelIn) {
		if (levelIn >= capacity) {
			currentLevel = capacity;
		}
		else if (levelIn >= 0) {
			currentLevel = levelIn; 
		}
		else {
			currentLevel = 0; 
		}
	}

}