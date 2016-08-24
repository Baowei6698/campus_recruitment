package edu.ouc.cc150;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
��Ŀ����

��һ��nxm������״�ĳ����ﱬ���˺�ˮ����ˮ��(0,0)�ĸ�������������У�������������еĸ�����һЩ������
��ˮֻ����û�н����ĸ����������뷵�غ�ˮ����(n - 1,m - 1)������ʱ��(��ˮֻ�ܴ�һ���������������ڵĸ���
�Һ�ˮ��λʱ���ܴ�һ�������������ڸ���)��

����һ������map��ʾ���У�����map[i][j]��ʾ����Ϊ(i,j)�ĸ��ӣ�ֵΪ1����ø����н�����0����û�н�����
ͬʱ��������Ĵ�Сn��m(n��m��С�ڵ���100)���뷵������(n - 1,m - 1)������ʱ�䡣��֤��ˮһ���������յ㡣


 * @author wqx
 *
 */
public class _9_7_Flood_DFS_BFS {

	/**
	 * ˼·һ��
	 * ��ͼ����������ȱ���DFS����¼·���Ĳ����������Сֵ��
	 * 
	 * ��ʱ������BFS������
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
	 * ��BFS�����������
	 * 
	 * AC��������������������
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
