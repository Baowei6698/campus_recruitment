package edu.ouc.offer;

/**
 * 
��Ŀ����
��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.
�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��

 * @author wqx
 *
 */
public class ReplaceSpaceInString {
	public static void main(String[] args){
		StringBuffer str = new StringBuffer("We Are Happy.");
		System.out.println(replaceSpace(str));
	}
    public static String replaceSpace(StringBuffer str) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < str.length(); i++){
    		if(str.charAt(i) == ' '){
    			sb.append("%20");  
    		}else{
    			sb.append(str.charAt(i));
    		}
    	}
    	return sb.toString();
    }
}
