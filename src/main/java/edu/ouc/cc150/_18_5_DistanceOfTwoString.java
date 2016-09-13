package edu.ouc.cc150;

import java.util.ArrayList;
import java.util.List;

/**
 * 
题目描述

有一篇文章内含多个单词，现给定两个单词，请设计一个高效算法，
找出文中这两个单词的最短距离(即最少相隔的单词数,也就是两个单词在文章中位置的差的绝对值)。

给定一个string数组article，代表所给文章，
同时给定文章的单词数n和待查找的两个单词x和y。请返回两个单词的最短距离。
保证两个单词均在文中出现且不相同，同时保证文章单词数小于等于1000。


 * @author wqx
 *
 */
public class _18_5_DistanceOfTwoString {

	/**
	 * 思路：
	 * 遍历article：
	 * 找出单词x,y出现的位置，可能有多个，得到两个位置数组posX,poxY,分别存放的是x，y出现的索引值。
	 * 遍历时间复杂度O(N)
	 * 
	 * 将posX和posY进行类似归并排序中的归并操作，过程中记录相邻元素的最小差值，这就是结果
	 * 
	 * 整体时间复杂度O(N)
	 * 
	 * @param article
	 * @param n
	 * @param x
	 * @param y
	 * @return
	 */
    public int getDistance(String[] article, int n, String x, String y) {
        List<Integer> posX = new ArrayList<>(0);
        List<Integer> posY = new ArrayList<>(0);
        
        for(int i = 0; i < n; i++){
        	if(x.equals(article[i])){
        		posX.add(i);
        	}
        	if(y.equals(article[i])){
        		posY.add(i);
        	}
        }
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while(i < posX.size() && j < posY.size()){
        	if(min > Math.abs(posX.get(i) - posY.get(j))){
    			min = Math.abs(posX.get(i) - posY.get(j));
    		}        	
        	if(posX.get(i) < posY.get(j)){
        		i++;
        	}else{
        		j++;
        	}
        }
        System.out.println("min:" + min);
        return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
