/*
volatile keyword: one change, every thread will know.
sychronized keyword: allow one thread to access at a time
*/

class Singleton {
	private volatile static Singleton singleton = null;
	private Singleton() {}
	public static SingletoncreateSingleton() {
		if(singleton == null) {
			synchronized(Singleton.class) {
				if(singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}


