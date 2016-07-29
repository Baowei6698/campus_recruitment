package edu.ouc.pattern.singleton;


public class EnumSingleton {

	/**
	 * ö������ʵ��
	 */
	enum SingletonHoler{
		holder;
		private EnumSingleton instance;
		
		SingletonHoler(){
			instance = new EnumSingleton();  
		}
		public EnumSingleton getInstance(){
			return instance;
		}
	}
	public static EnumSingleton getInstance(){
		return SingletonHoler.holder.getInstance();
	}
}
