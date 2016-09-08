package edu.ouc.cc150;

import java.util.Arrays;

/**
 * ��С��������

��Ŀ����

��һ���������飬���дһ���������ҳ�����m��n��ֻҪ��m��n֮���Ԫ���ź������������������ġ�
ע�⣺n-mӦ��ԽСԽ�ã�Ҳ����˵���ҳ�����������������С�

����һ��int����A������Ĵ�Сn���뷵��һ����Ԫ�飬�����������е������յ㡣
(ԭ����λ�ô�0��ʼ���,��ԭ�������򣬷���[0,0])����֤A��Ԫ�ؾ�Ϊ��������
����������

[1,4,6,5,9,10],6

���أ�[2,3]

 * @author wqx
 *
 */
public class _17_6_Rearrange {

	/**
	 * ˼·�������������������ֱ�����������������飬
	 * reverse[i]=j��arr[i]���ұ߱�arr[i]С�����ĸ���
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public int[] findSegment(int[] A, int n) {
		int N = 0, M = 0;
		int max = A[0];
		for(int i = 1; i < n; i++){
			if(A[i] >= max){
				max = A[i];
			}else{
				N = i;
			}
		}
		int min = A[n-1];
		for(int i = n-2; i >= 0; i--){
			if(A[i] <= min){
				min = A[i];
			}else{
				M = i;
			}
		}
		int[] res = new int[2];
		res[0] = M;res[1] = N;
		return res;
	}
	public static void main(String[] args) {
		int[] A = {1,2,3,3,8,9};
		int n = 6;
		int res [] = new _17_6_Rearrange().findSegment(A, n);
		System.out.println(res[0] + "," + res[1]);
	}

}
