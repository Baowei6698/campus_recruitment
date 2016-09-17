package edu.ouc.cc150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ��Ŀ����

��һ�����ӣ�ÿ�����ӿ�Ϊwi����Ϊdi����Ϊhi��������Ҫ�����Ӷ�������������Ϊ��ʹ�����������Ӳ�����
��������ӵĿ�Ⱥͳ��ȱ���С����������ӡ���ʵ��һ������������ܶѳ�����ߵĸ߶ȣ�����ĸ߶ȼ����������������ӵĸ߶�֮�͡�

��������int����w,l,h���ֱ��ʾÿ�����ӿ����͸ߣ�ͬʱ�������ӵ���Ŀn���뷵���ܶѳɵ���ߵĸ߶ȡ���֤nС�ڵ���500��
����������

[1,1,1],[1,1,1],[1,1,1]

���أ�1

 * @author wqx
 *
 */
public class _9_10_Box {

	/**
	 * ˼·�����Կ�����������������(LIS)�Ķ�ά�汾��ֻ��Ҫ��ĳ��ά�ȣ���򳤣��Ƚ�������
	 * Ȼ�������һ��ά����LIS�������м�¼�߶ȡ�
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
		//�Գ�����
		Arrays.sort(arr,new Comparator<BoxEntry>(){
			public int compare(BoxEntry b1,BoxEntry b2){
				return b2.l.compareTo(b1.l);
			}
		});
		//�Կ����LIS��ѯ
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
