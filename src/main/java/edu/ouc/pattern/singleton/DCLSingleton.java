package edu.ouc.pattern.singleton;

public class DCLSingleton implements java.io.Serializable{

	private volatile static Boolean isSingle = false;
	/**
	 * 私有的构造函数
	 */
	private DCLSingleton(){
//		synchronized(isSingle){
//			if(!isSingle){
//				isSingle = !isSingle;
//			}else{
//				try {  
//					throw new Exception("duplicate instance exception : " + DCLSingleton.class.getName());  
//				} catch (Exception e) {  
//					e.printStackTrace();  
//				} 
//			}
//		}
	}

	private volatile static DCLSingleton instance;

	public static DCLSingleton getInstance(){
		if(instance == null){
			synchronized(DCLSingleton.class){
				if(instance == null){
					instance = new DCLSingleton();
				}
			}
		}
		return instance;
	}
	private Object readResolve(){
			return instance;
	}
}
