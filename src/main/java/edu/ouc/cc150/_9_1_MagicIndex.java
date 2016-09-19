package edu.ouc.cc150;

/**
 * 魔术索引I
题目描述

在数组A[0..n-1]中，有所谓的魔术索引，满足条件A[i]=i。给定一个升序数组，元素值各不相同，编写一个方法，
判断在数组A中是否存在魔术索引。请思考一种复杂度优于o(n)的方法。

给定一个int数组A和int n代表数组大小，请返回一个bool，代表是否存在魔术索引。
测试样例：

[1,2,3,4,5]

返回：false

 * @author wqx
 *
 */
public class _9_1_MagicIndex {

	/**
	 * 给定序列为升序
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
    public static boolean findMagicIndex(int[] A, int n) {
    	return dfs(A,0);
    }
    /**
     * 给定序列为非升序，可能存在相同的值
     * if(A[mid] < mid) findMagic(A,mid+1,end);就不成立了
     * 
     * A[index] < index时，若A[index-1] == A[index]则需要继续向左查找
     * A[index] > index时同理。
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
        	//查看右侧是否有相等的元素
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
