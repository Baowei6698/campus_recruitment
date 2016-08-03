package edu.ouc.cc150;

/**
 * 最近公共祖先
 * 
题目描述

有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。请设计一个算法，
求出a和b点的最近公共祖先的编号。

给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
测试样例：

2，3

返回：1

 * @author wqx
 *
 */
public class _4_7_LCA {

	/**
	 * 利用完全二叉树性质：parentId = childId/2;
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
    public static int getLCA(int a, int b) {
    	if(a > b){
    		a = a + b;
    		b = a - b;
    		a = a - b;
    	}
    	while(true){
    		if(a == b)
    			return a;
    		
    		if( a < b){
    			b /= 2;
    			continue;
    		}
    		if(a > b){
    			a /= 2;
    			continue;
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLCA(5,8));
	}

}
