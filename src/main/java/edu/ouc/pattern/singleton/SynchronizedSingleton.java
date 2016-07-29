package edu.ouc.pattern.singleton;

public class SynchronizedSingleton {

	private SynchronizedSingleton(){}
	
	private static SynchronizedSingleton instance;

	public synchronized static SynchronizedSingleton getInstance(){
		if(instance == null){
			instance = new SynchronizedSingleton();
		}
		return instance;
	}
}
