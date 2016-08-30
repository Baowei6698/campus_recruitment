package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述

叠罗汉是一个著名的游戏，游戏中一个人要站在另一个人的肩膀上。为了使叠成的罗汉更稳固，
我们应该让上面的人比下面的人更轻一点。现在一个马戏团要表演这个节目，为了视觉效果，
我们还要求下面的人的身高比上面的人高。请编写一个算法，计算最多能叠多少人，注意这里所有演员都同时出现。

给定一个二维int的数组actors，每个元素有两个值，分别代表一个演员的身高和体重。
同时给定演员总数n，请返回最多能叠的人数。保证总人数小于等于500。
测试样例：

[[1,2],[3,4],[5,6],[7,8]],4

返回：4

 * @author wqx
 *
 */
public class _11_7_2_LIS_II {

	/**
	 * 二维LIS,先按升高维度排序，在对体重进行LIS求解
	 * 
	 * @param actors
	 * @param n
	 * @return
	 */
    public int getHeight(int[][] actors, int n) {
    	Actor[] actorList = new Actor[n];
    	for(int i = 0; i < n; i++){
    		Actor act = new Actor(actors[i][0],actors[i][1]);
    		actorList[i] = act;
    	}
    	//按身高维度排序
    	Arrays.sort(actorList,new Comparator<Actor>(){
			@Override
			public int compare(Actor o1, Actor o2) {
				// TODO Auto-generated method stub
				return o1.height - o2.height;
			}
    	});
    	int f[] = new int[n];
    	f[0] = 1;
    	int res = 1;
    	for(int i = 1; i < n; i++){
    		f[i] = 1;
    		for(int j = 0; j < i; j++){
    			if(actorList[j].weight < actorList[i].weight && f[j] + 1 > f[i]){
    				f[i] = f[j] + 1;
    				if(f[i] > res)
    					res = f[i];
    			}
    		}
    	}
    	return res;
    }
    static class Actor{
    	int height;
    	int weight;
    	public Actor(int height, int weight){
    		this.height = height;
    		this.weight = weight;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
