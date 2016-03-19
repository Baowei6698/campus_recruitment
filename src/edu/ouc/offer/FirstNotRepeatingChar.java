package edu.ouc.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
��Ŀ����
��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ���λ�á�
��Ϊ�մ�������-1��λ��������0��ʼ

 * @author wqx
 *
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
    	if(str == null || "".equals(str))return -1;
    	Map<Character,Integer> map = new HashMap<Character,Integer>(str.length());
    	
    	for(int i = 0; i < str.length(); i++){
    		if(map.get(str.charAt(i)) == null){
    			map.put(str.charAt(i),1);
    		}else{
    			map.put(str.charAt(i),map.get(str.charAt(i)) + 1);
    		}
    	}
    	int pos = str.length();
    	Set<Character> sets = map.keySet();
    	Iterator<Character> it = sets.iterator();
    	while(it.hasNext()){
    		Character c = it.next();
    		if(map.get(c) == 1){
    			int index = str.indexOf(c);
    			if(index < pos){
    				pos = index;
    			}
    		}
    	}
        return pos == str.length() ? -1 : pos;
    }
}
