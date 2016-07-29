package edu.ouc.pattern.singleton;

public class StaticSingleton {
	private StaticSingleton(){
		System.out.println("instance is created!");
	}
	/**
	 * instance实例化是在类加载阶段进行的，天生线程友好，保证对象唯一性。
	 */
	private static StaticSingleton instance = new StaticSingleton();
	
	public static StaticSingleton getInstance(){
		return instance;
	}
}
