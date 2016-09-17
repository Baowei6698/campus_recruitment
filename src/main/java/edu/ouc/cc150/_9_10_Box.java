package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述

有一堆箱子，每个箱子宽为wi，长为di，高为hi，现在需要将箱子都堆起来，而且为了使堆起来的箱子不到，
上面的箱子的宽度和长度必须小于下面的箱子。请实现一个方法，求出能堆出的最高的高度，这里的高度即堆起来的所有箱子的高度之和。

给定三个int数组w,l,h，分别表示每个箱子宽、长和高，同时给定箱子的数目n。请返回能堆成的最高的高度。保证n小于等于500。
测试样例：

[1,1,1],[1,1,1],[1,1,1]

返回：1

 * @author wqx
 *
 */
public class _9_10_Box {

	/**
	 * 思路：可以看做是最大递增子序列(LIS)的二维版本，只需要对某个维度（宽或长）先进行排序，
	 * 然后对另外一个维度求LIS，过程中记录高度。
	 * 
	 * @param w
	 * @param l
	 * @param h
	 * @param n
	 * @return
	 */
	public int getHeight(int[] w, int[] l, int[] h, int n) {
		BoxEntry[] arr = new BoxEntry[n];
		for(int i = 0; i < n; i++){
			arr[i] = new BoxEntry(w[i],l[i],h[i]);
		}
		//对长排序
		Arrays.sort(arr,new Comparator<BoxEntry>(){
			public int compare(BoxEntry b1,BoxEntry b2){
				return b2.l.compareTo(b1.l);
			}
		});
		//对宽进行LIS查询
		int f[] = new int[n];
		f[0] = arr[0].h;
		int maxHeight = f[0];
		for(int i = 1; i < n; i++){
			f[i] = arr[i].h;
			int tmp = 0;
			for(int j = i-1; j >= 0; j--){
				if(arr[i].w < arr[j].w && arr[i].l < arr[j].l){
					tmp = Math.max(tmp,f[j]);
				}
			}
			f[i] += tmp;
			maxHeight = Math.max(maxHeight,f[i]);
		}
		return maxHeight;
	}
	static class BoxEntry{
		Integer w,l,h;
		public BoxEntry(int w,int l, int h){
			this.w = w; this.l = l; this.h = h;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
