//Weather station example

public Interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObserver();
}

public Interface Observer {
	public void update(Subject subj);
}

public Interface DisplayElement {
	public void display();
}

public class WeatherData implements Subject {
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList();
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0) {
			Observers.remove(i);
		}
	}

	public void notifyObservers() {
		for(int i=0; i<observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(this);
		}
	}

	public setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		notifyObservers();
	}
}

public class TempDisplay implements Observer, DisplayEment {
	private float temperature;
	private WeatherData subj;
	public TempDisplay(Subject subj) {
		this.subj = subj;
		subj.registerObserver(this);
	}
	public void update(WeatherData data) {
		this.temperature = data.temperature;
	}
	public void display() {
		System.out.println(this.temperature);
	}
}
