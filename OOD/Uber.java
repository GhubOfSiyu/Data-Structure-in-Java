abstract class Vehicle {
	protected Driver driver;
	protected int number;
	protected int size;
	protected float[] location;
	public Vechicle(int number, float[] location, Driver driver) {
		this.number = number;
		this.location = location;
		this.driver = driver;
	}
	public void getNumber(){return number;}
	public void setNumber(int num){this.number = num;}
	public void getSize(){return size;}
	public void setSize(int size){this.size = size;}
	public void setLocation(float[] location){this.location = location;}
	public float[] getLocation(){return location;}
}

class Bus extends Vehicle{
	public Bus(int number, float[] location) {
		super(number, location);
		this.size = 12;
	}
}

class Car extends Vehicle {
	public Car(int number, float[] location) {
		super(number, location);
		this.size = 4;
	}
}

class SuperCar extends vehicle {
	public SuperCar(int number, float[] location) {
		super(number, location);
		this.size = 2;
	}
}

class User {
	private int user_id;
	private String name;
	private int accountNum;
	private float[] location;
	public User() {}
	public pay(int accountNum) {}
}

class Driver {
	private int driverLisence;
	private String name;
	private String address;
	private int accountNum;

}

class UberManager {
	public List<Vehicle> getNearestCars(User) {
		return search(User);
	}
	
}