package edu.ouc.pattern.singleton;

public class StaticSingleton {
	private StaticSingleton(){
		System.out.println("instance is created!");
	}
	/**
	 * instanceʵ������������ؽ׶ν��еģ������߳��Ѻã���֤����Ψһ�ԡ�
	 */
	private static StaticSingleton instance = new StaticSingleton();
	
	public static StaticSingleton getInstance(){
		return instance;
	}
}
