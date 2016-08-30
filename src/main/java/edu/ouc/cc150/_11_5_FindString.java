package edu.ouc.cc150;

/**
 * 
��Ŀ����

��һ���Ź�����ַ������飬���������в�����һЩ���ַ����������һ���㷨���ҳ������ַ�����λ�á�
�㷨�Ĳ��Ҳ��ֵĸ��Ӷ�Ӧ��Ϊlog����

����һ��string����str,ͬʱ���������Сn����Ҫ���ҵ�string x���뷵�ظô���λ��(λ�ô��㿪ʼ)��
����������

["a","b","","c","","d"],6,"c"

���أ�3


 * @author wqx
 *
 */
public class _11_5_FindString {

	/**
	 * ˼·��
	 * 		ͬ���Ƕ��ֲ��Ҽ���������,���str[mid]�ǿ��ַ���
	 * 
	 * @param str
	 * @param n
	 * @param x
	 * @return
	 */
    public static int findString(String[] str, int n, String x) {
    	int left = 0, right = n-1;
    	int mid = 0;
    	while(left <= right){
    		mid = findPos(str,n,left,right,x);
    		if(str[mid].equals(x)){
    			return mid;
    		}else if(str[mid].compareTo(x) < 0){
    			left = mid + 1;
    		}else{
    			right = mid - 1;    			
    		}
    	}
    	return -1;
    }
    /**
     * �ҵ�mid��ʹ��A[mid]��Ϊ���ַ���
     * 
     * @param str
     * @param n
     * @param left
     * @param right
     * @param x
     * @return
     */
    public static int findPos(String [] str, int n, int left , int right, String x){
    	int mid = (left + right) / 2;
    	int i = mid;
    	while(i <= right && str[i].equals("")) i++;
    	if(i <= right && str[i].compareTo(x) <= 0)
    		return i;
    	i = mid;
    	while(i >= left && str[i].equals(""))i--;
    	if(i >= left && str[i].compareTo(x) >= 0)
    		return i;
    	return 0;
    }
	public static void main(String[] args) {
		String[] str = {"","","CFWW","JUNMFCVE","KBVPO","LLQHRIN","P","RDDK","UFEYPGVKFO"};
		int n = 9; 
		String x = "RDDK";
		System.out.println(findString(str,n,x));
	}

}
