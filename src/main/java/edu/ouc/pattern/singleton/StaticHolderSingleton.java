package edu.ouc.pattern.singleton;


public class StaticHolderSingleton {
	
	private StaticHolderSingleton(){
		System.out.println("instance is created!");
	}
	
	private static StaticHolderSingleton instance ;
	
	/**
	 * ʹ�þ�̬�ڲ���ʵ�ֵ���
	 * 
	 */
	private static class SingletonHolder{
		private static StaticHolderSingleton instance = new StaticHolderSingleton();
	}
	public static StaticHolderSingleton getInstance(){
		return SingletonHolder.instance;
	}
}
