package edu.ouc.pattern.singleton;


public class StaticHolderSingleton {
	
	private StaticHolderSingleton(){
		System.out.println("instance is created!");
	}
	
	private static StaticHolderSingleton instance ;
	
	/**
	 * 使用静态内部类实现单例
	 * 
	 */
	private static class SingletonHolder{
		private static StaticHolderSingleton instance = new StaticHolderSingleton();
	}
	public static StaticHolderSingleton getInstance(){
		return SingletonHolder.instance;
	}
}
