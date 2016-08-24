package edu.ouc.cc150;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
题目描述

在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，在这个矩阵中有的格子有一些建筑，
洪水只能在没有建筑的格子流动。请返回洪水流到(n - 1,m - 1)的最早时间(洪水只能从一个格子流到其相邻的格子
且洪水单位时间能从一个格子流到相邻格子)。

给定一个矩阵map表示城市，其中map[i][j]表示坐标为(i,j)的格子，值为1代表该格子有建筑，0代表没有建筑。
同时给定矩阵的大小n和m(n和m均小于等于100)，请返回流到(n - 1,m - 1)的最早时间。保证洪水一定能流到终点。


 * @author wqx
 *
 */
public class _9_7_Flood_DFS_BFS {

	/**
	 * 思路一：
	 * 对图进行深度优先遍历DFS，记录路径的步数，求出最小值。
	 * 
	 * 超时！！换BFS！！！
	 * 
	 * @param map
	 * @param n
	 * @param m
	 * @return
	 */
	public static int floodFill(int[][] map, int n, int m) {
		Stack<Point> path = new Stack<Point>();
		boolean visited[][] = new boolean[n][m];
		dfs(map,visited,0,0,n,m,path);
		return minPath;
	}
	private static int minPath = Integer.MAX_VALUE;

	private static int[][] step = {{1,0},{-1,0},{0,1},{0,-1}};

	public static void dfs(int[][] map, boolean visited[][],int i, int j, int n, int m, Stack<Point> path){
		if(i < 0 || i >= n || j < 0 || j >=m) return;
		System.out.println("i:" + i + ",j:" + j + ",path.size():" + path.size());
		if(map[i][j] == 0 && visited[i][j] == false){
			if(i == n-1 && j == m-1){
				minPath = minPath > path.size() ? path.size() : minPath;
			}else{
				visited[i][j] = true;
				for(int k = 0; k < 4; k++){
					path.push(new Point(i,j));
					dfs(map,visited,i+step[k][0],j + step[k][1],n,m,path);
					path.pop();
				}
				visited[i][j] = false;
			}
		}
	}
	/**
	 * 用BFS广度优先搜索
	 * 
	 * AC！！！哈哈哈哈。。。
	 * 
	 * @param map
	 * @param n
	 * @param m
	 * @return
	 */
	public static int floodFill_BFS(int[][] map, int n, int m) {
		Queue<Point> queue = new LinkedList<>();
		boolean visited[][] = new boolean[n][m];
		queue.offer(new Point(0,0));
		minPath = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for(int i = 0; i < size; i++){
				Point p = queue.poll();
				visited[p.x][p.y] = true;
				if(p.x == n-1 && p.y == m-1){
					return minPath;
				}
				for(int k = 0; k < 4; k++){
					int posX = p.x + step[k][0];
					int posY = p.y + step[k][1];
					if(posX < 0 || posX >= n || posY < 0 || posY >=m) continue;
					if(visited[posX][posY] == false && map[posX][posY] == 0){
						System.out.println("x:" + posX + ",y:" + posY);
						queue.offer(new Point(posX,posY));
					}
				}
			}
			minPath++;
		}
		return minPath;
	}
	static class Point{
		int x;
		int y;
		public Point(int x,int y){
			this.x = x;this.y = y;
		}
	}
	public static void main(String[] args) {
		int[][] map = {{0,0,0},
				{0,0,0},
				{0,0,0}};
		System.out.println("result:" + floodFill_BFS(map,3,3));
	}

}
