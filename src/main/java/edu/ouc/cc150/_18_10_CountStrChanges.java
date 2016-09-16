package edu.ouc.cc150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 字符串变换
 * 
 * 题目描述

现有一个字典，同时给定字典中的两个字符串s和t，给定一个变换，每次可以改变字符串中的任意一个字符，
请设计一个算法，计算由s变换到t所需的最少步数，同时需要满足在变换过程中的每个串都是字典中的串。

给定一个string数组dic，同时给定数组大小n，串s和串t，请返回由s到t变换所需的最少步数。若无法变换到t则返回-1。
保证字符串长度均小于等于10，且字典中字符串数量小于等于500。
测试样例：

["abc","adc","bdc","aaa”],4,”abc","bdc"

返回：2

 * @author wqx
 *
 */
public class _18_10_CountStrChanges {

	/**
	 * 思路：
	 * 变换过程可以模拟成一个有向图，图中每个节点是代表一个字符串，而每个有向边则代表着一次字符变换。
	 * 
	 * 题意是要找出最小的变换步数，那么就是对该图进行广度优先搜索即可。
	 * 
	 * @param dic
	 * @param n
	 * @param s
	 * @param t
	 * @return
	 */
    public int countChanges(String[] dic, int n, String s, String t) {
    	Queue<String> queue = new LinkedList<String>();
    	queue.offer(s);
    	boolean[] visited = new boolean[n];
    	int count = 0;
    	while(!queue.isEmpty()){
    		int size = queue.size();
    		//遍历同一深度的节点
    		for(int i = 0; i < size; i++){
    			String str = queue.poll();
    			if(str.equals(t)){
    				return count;
    			}
    			//对每个节点，寻找可能的下一个状态节点
    			for(int j = 0; j < dic.length; j++){
    				if(check(str,dic[j]) && !visited[j]){
    					visited[j] = true;
    					queue.offer(dic[j]);
    				}
    			}
    		}
    		count++;
    	}
    	return count;
    }
    public boolean check(String src,String dest){
    	int differs = 0;
    	if(src.length() != dest.length()) return false;
    	for(int i = 0; i < src.length(); i++){
    		if(src.charAt(i) != dest.charAt(i)){
    			differs++;
    		}
    		if(differs > 1)	return false;
    	}
    	if(differs == 1)
    		return true;
    	return false;
    }
	public static void main(String[] args) {
		String[] dic = {"abc","adc","bdc","aaa"};
		int n = 4;
		String s = "abc", t = "bdc";
		System.out.println("res:" + new _18_10_CountStrChanges().countChanges(dic, n, s, t));
	}

}
