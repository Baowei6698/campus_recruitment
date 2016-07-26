package edu.ouc.xiaomi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 小米Git
 * 
题目描述
git是一种分布式代码管理工具，git通过树的形式记录文件的更改历史，
比如： base'<--base<--A<--A' ^ | --- B<--B' 
小米工程师常常需要寻找两个分支最近的分割点，即base.假设git 树是多叉树，
请实现一个算法，计算git树上任意两点的最近分割点。 
（假设git树节点数为n,用邻接矩阵的形式表示git树：字符串数组matrix包含n个字符串，
每个字符串由字符'0'或'1'组成，长度为n。
matrix[i][j]=='1'当且仅当git树种第i个和第j个节点有连接。
节点0为git树的根节点。）

输入例子:

[01011,10100,01000,10000,10000],1,2

输出例子:

1

 * @author wqx
 *
 */
public class XiaoMiGit {
    /**
     * 返回git树上两点的最近分割点
     * 思路：
     * DFS，记录查询路径，比较两路径得出结果。GET！！！
     * 
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 
     * 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
	static boolean flag;
    public static int getSplitNode(String[] matrix, int indexA, int indexB) {
    	int rows = matrix.length;
    	int[] visited = new int [rows+1];
    	List<Integer> path1 = new ArrayList<Integer>();
    	List<Integer> path2 = new ArrayList<Integer>();
    	flag = false;
    	dfs(matrix,indexA,visited,0,path1);
    	flag = false;
    	visited = new int[rows+1];
    	dfs(matrix,indexB,visited,0,path2);
    	for(int i = path1.size()-1; i >= 0; i--){
    		for(int j = path2.size()-1; j >= 0; j--){
    			if(path2.get(j) == path1.get(i)){
    				return path2.get(j);
    			}
    		}
    	}
    	
    	System.out.println(Arrays.toString(path1.toArray()));
    	System.out.println(Arrays.toString(path2.toArray()));
    	return 0;
    }

    public static void dfs(String [] matrix,int target,int visited[],int num,List<Integer> path){
    	if(flag)return;
    	visited[num] = 1;
    	System.out.println("num:" + num);
    	for(int i = 0; i < matrix[num].length(); i++){
    			if(matrix[num].charAt(i) == '1' && visited[i] == 0){
    				path.add(i);
    				if(target == i){
    					flag = true;
    					return ;
    				}
    				dfs(matrix,target,visited,i,path);
    				if(flag)return;
    				path.remove(path.indexOf(i));
    		}
    	}
    }
    public static void main(String[]args){
    	String[] matrix = {"01011","10100","01000","10000","10000"};
    	int indexA = 1,indexB = 2;
    	System.out.println("result:" + getSplitNode(matrix,indexA,indexB));
    }
}
