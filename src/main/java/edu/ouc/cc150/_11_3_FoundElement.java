package edu.ouc.cc150;

/**
 * 
��Ŀ����

��һ���Ź�������飬����n����������������������������һ�����ȵ���λ�����磬ԭ����Ϊ[1,2,3,4,5,6]��
������λ5��λ�ü������[6,1,2,3,4,5],���ڶ�����λ������飬��Ҫ����ĳ��Ԫ�ص�λ�á�
�����һ�����Ӷ�Ϊlog������㷨����������

����һ��int����A��Ϊ��λ������飬ͬʱ���������Сn����Ҫ���ҵ�Ԫ�ص�ֵx���뷵��x��λ��(λ�ô��㿪ʼ)��
��֤������Ԫ�ػ��졣

����������

[6,1,2,3,4,5],6,6

���أ�0

 * @author wqx
 *
 */
public class _11_3_FoundElement {

	/**
	 * ˼·��
	 * ��λǰ����ͨ�����ֲ���ʵ��logn����ʱ�临�Ӷ�
	 * 
	 * 
	 * @param A
	 * @param n
	 * @param x
	 * @return
	 */
    public static int findElement(int[] A, int n, int x) {
    	int left,right;
    	left = 0;right = n-1;
    	while(left <= right){
    		int mid = (left + right) / 2;
    		if(x == A[mid])
    			return mid;
    		else if(x < A[mid]){//xδ��һ����left-midֱ�ӣ�������mid�ұ�
    			if(A[mid] > A[left] && x < A[left] ){
    				left = mid + 1;
    			}else{
    				right = mid - 1;    				
    			}
    		}else{
    			if(A[mid] < A[right] && x > A[right]){
    				right = mid - 1;    				
    			}else{
    				left = mid + 1;
    			}
    		}
    	}
    	return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {43,44,45,46,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42};
		System.out.println(findElement(arr, 46, 5));
	}

}
