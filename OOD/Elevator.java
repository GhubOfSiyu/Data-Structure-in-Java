public class Passenger {
	private int weight;
	public void setWeight(int weight) {this.weight = weight;}
	public int getWeight() {return weight;}
}
public class Elevator {
	private boolean available;
	private int currentLevel;
	private int weight;

	public Elevator() {}
	public void goUp() {}
	public void goDown(){}
	public void stop() {}
	public void open() {}
	public void close() {}
	public void moveTo(int level) {}
	public void load() {}
	public void unload() {}
	public int checkWeight() {}
	public void notifyOverWeight() {}

}


public class Request {
	private Passenger p;
	private int level;
	//requestLoad, moveTo, open, close,
	private int command;
	public Request(Passenger p, int level) {
		this.p = p;
		this.level = level;
	}
}

public class Controller {
	private Elevator e;
	LinkedList<Request> queue;
	public Controller() {
		queue = new LinkedList<>();
		e = new Elevator();
	}

	public void addCommand(Request r) {
		queue.add(r);
	}

	public void executeCommand() {
		Request r = queue.poll();
		if(r.command == 0)  {
			e.moveTo(r.level);
			e.load(r.p);
		}
		else if(r.command == 1) {
			e.moveTo(r.level);
			e.unload(r.p);
		}
		else if (r.command == 3) {
			e.open();
		}
		else {
			e.close();
		}

	}

}