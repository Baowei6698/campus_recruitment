package edu.ouc.cc150;

/**
 * ��Ŀ����

��һ����NxN�����ʾ��ͼ������ÿ��������һ��int��ʾ�����дһ���㷨���ڲ�ռ�ö����ڴ�ռ�������
(����ʹ�û������)����ͼ��˳ʱ����ת90�ȡ�

����һ��NxN�ľ��󣬺;���Ľ���N,�뷵����ת���NxN����,��֤NС�ڵ���500��ͼ��Ԫ��С�ڵ���256��
����������

[[1,2,3],[4,5,6],[7,8,9]],3

���أ�[[7,4,1],[8,5,2],[9,6,3]]

 * @author wqx
 *
 */
public class _1_6_TransformImage {

	/**
	 * ��ռ�ö���ռ�
	 * �ԶԽ���Ϊ����жԻ����ٰ��жԻ���1<->4,2<->3��
	 * 
	 * @param mat
	 * @param n
	 * @return
	 */
    public static int[][] transformImage(int[][] mat, int n) {
    	
        for(int i = 0; i < n; i++){
        	for(int j = i; j < n; j++){
        		int t = mat[i][j];
        		mat[i][j] = mat[j][i];
        		mat[j][i] = t;
        	}
        }
        for(int i = 0; i < n/2; i++){
        	swapColumn(mat,i,n-i-1);
        }
        return mat;
    }
    public static void swapColumn(int[][] mat,int col1,int col2){
    	for(int i = 0; i < mat.length; i++){
    		int tmp = mat[i][col1];
    		mat[i][col1] = mat[i][col2];
    		mat[i][col2] = tmp;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a = {{1,2,3},{4,5,6},{7,8,9}};
		
		transformImage(a,3);
	}

}
