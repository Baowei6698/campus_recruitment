package edu.ouc.cc150;

/**
 * ħ������I
��Ŀ����

������A[0..n-1]�У�����ν��ħ����������������A[i]=i������һ���������飬Ԫ��ֵ������ͬ����дһ��������
�ж�������A���Ƿ����ħ����������˼��һ�ָ��Ӷ�����o(n)�ķ�����

����һ��int����A��int n���������С���뷵��һ��bool�������Ƿ����ħ��������
����������

[1,2,3,4,5]

���أ�false

 * @author wqx
 *
 */
public class _9_1_MagicIndex {

	/**
	 * ��������Ϊ����
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
    public static boolean findMagicIndex(int[] A, int n) {
    	return dfs(A,0);
    }
    /**
     * ��������Ϊ�����򣬿��ܴ�����ͬ��ֵ
     * if(A[mid] < mid) findMagic(A,mid+1,end);�Ͳ�������
     * 
     * A[index] < indexʱ����A[index-1] == A[index]����Ҫ�����������
     * A[index] > indexʱͬ��
     * 
     * @param A
     * @param n
     * @return
     */
    public static boolean findMagicIndex2(int[] A, int n) {
    	return findMagic(A,0,n);
    }
    static boolean findMagic(int[] A,int start, int end){
    	System.out.println("start:" + start + ",end:" + end);
        if(start >= end) return false;
        int mid = (start+end)/2;
        if(mid == A[mid]) return true;
        else if(A[mid] < mid){
        	//�鿴�Ҳ��Ƿ�����ȵ�Ԫ��
        	int index = mid;
        	while(A[index] == A[index-1] && A[index] == --index)return true;
        	return findMagic(A,mid+1,end);
        } else{
        	int index = mid;
        	while(A[index] == A[index+1] && A[index] == ++index)return true;
        	return findMagic(A,start,mid);
        }
    }
    public static boolean dfs(int[] A, int index){
    	if(index >= A.length) return false;
    	if(A[index] == index) return true;
    	boolean left = dfs(A,index * 2 + 1);
    	if(!left) return false;
    	return dfs(A,index * 2 + 2);
    }
	public static void main(String[] args) {
		int[] A = {0,0,1,1,3};
		System.out.println("result:" + findMagicIndex2(A,A.length));
	}

}
