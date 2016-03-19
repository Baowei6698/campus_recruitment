package edu.ouc.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
题目描述
在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符的位置。
若为空串，返回-1。位置索引从0开始

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
