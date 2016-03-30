package edu.ouc.codeforces.round344;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Kris works in a large company "Blake Technologies". As a best engineer of the company he was assigned a 
 * task to develop a printer that will be able to print horizontal and vertical strips. 
 * First prototype is already built and Kris wants to tests it. He wants you to implement 
 * the program that checks the result of the printing.

Printer works with a rectangular sheet of paper of size n × m. Consider the list as a table 
consisting of n rows and m columns. Rows are numbered from top to bottom with integers from 1 to n, 
while columns are numbered from left to right with integers from 1 to m. Initially,
 all cells are painted in color 0.


Your program has to support two operations:

    Paint all cells in row ri in color ai;
    Paint all cells in column ci in color ai. 

If during some operation i there is a cell that have already been painted, 
the color of this cell also changes to ai.

Your program has to print the resulting table after k operation.

Input

The first line of the input contains three integers n, m and k (1  ≤  n,  m  ≤ 5000, n·m ≤ 100 000, 1 ≤ k ≤ 100 000)
 — the dimensions of the sheet and the number of operations, respectively.

Each of the next k lines contains the description of exactly one query:

    1 ri ai (1 ≤ ri ≤ n, 1 ≤ ai ≤ 109), means that row ri is painted in color ai;
    2 ci ai (1 ≤ ci ≤ m, 1 ≤ ai ≤ 109), means that column ci is painted in color ai. 

Output

Print n lines containing m integers each — the resulting table after all operations are applied.

 * @author wqx
 *
 */
public class B_Print_Check {

	/**
	 * 对于大量操作的测试用例需要进行优化，每次变色操作需要做n or m 次循环（如果n or m 很大，会TLE）
	 * 通过Map保存需要做的操作，如果对某一行或列的操作出现多次，则只执行最后一次（因为每次操作都会覆盖前面的操作）
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		while(in.hasNext()){
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int[][] paper= new int[n+1][m+1];

			Map<String,Integer> map = new HashMap<String,Integer>(k+1);
			String[] record = new String[k+1];
			for(int i = 0; i < k ; i++){
				int isRow = in.nextInt();
				int rowOrCol = in.nextInt();
				int color = in.nextInt();
				String key = isRow + "," + rowOrCol;
				if(map.get(key) == null){
					map.put(key, 1);
				}else{
					map.put(key, map.get(key)+1);
				}
				key += "," + color;
				record[i] = key;
			}
			for(int i = 0; i < k ; i++){
				String key = record[i].substring(0,record[i].lastIndexOf(","));
				String[] keys = record[i].split(",");
				String isRow = keys[0];
				int rowOrCol = Integer.parseInt(keys[1]);
				int color = Integer.parseInt(keys[2]);
				if("1".equals(isRow)){
					if(map.get(key) == 1){
						for(int j = 1;j <= m; j++){
							paper[rowOrCol][j] = color;
						}
					}else{
						map.put(key, map.get(key)-1);
					}
				}else{
					if(map.get(key) == 1){
						for(int j = 1;j <= n; j++){
							paper[j][rowOrCol] = color;
						}
					}else{
						map.put(key, map.get(key)-1);
					}
				}
			}

			for(int p = 1; p <= n; p++){
				for(int q = 1; q <= m; q++){
					System.out.print(paper[p][q] + " ");
				}
				System.out.println();
			}
		}
	}
}
