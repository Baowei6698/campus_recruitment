package edu.ouc.cc150;

/**
 * ��Ŀ����

���дһ���㷨����MxN������ĳ��Ԫ��Ϊ0���������ڵ����������㡣

����һ��MxN��int[][]����(C++��Ϊvector>)mat�;���Ľ���n��
�뷵����ɲ������int[][]����(C++��Ϊvector>)����֤nС�ڵ���300�������е�Ԫ��Ϊint��Χ�ڡ�
����������

[[1,2,3],[0,1,2],[0,0,1]]

���أ�[[0,0,3],[0,0,0],[0,0,0]]

 * @author wqx
 *
 */
public class _1_7_ClearZero {

    public int[][] clearZero(int[][] mat, int n) {
    	if(mat == null || mat.length == 0) return mat;
    	n = mat.length;
    	int m = mat[0].length;
        boolean row[] = new boolean[n];
        boolean col[] = new boolean[m];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		if(mat[i][j] == 0){
        			row[i] = true;
        			col[j] = true;
        		}
        	}
        }
        
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < m; j++){
        		if(row[i] || col[j]){
        			mat[i][j] = 0;
        		}
        	}
        }
        return mat;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
