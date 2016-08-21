package edu.ouc.cc150;

/**
 * ��Ŀ����

��һ��XxY������һ��������ֻ���߸����ֻ�����һ������ߣ�Ҫ�����Ͻ��ߵ����½ǡ�
�����һ���㷨������������ж������߷���

��������������int x,int y���뷵�ػ����˵��߷���Ŀ����֤x��yС�ڵ���12��
����������

2,2

���أ�2

 * @author wqx
 *
 */
public class _9_2_Robot {
	
	/**
	 * �������
	 * 
	 * �ռ临�Ӷ� O(n*m)
	 * 
	 * ����ʱ�䣺28ms
	 * ռ���ڴ棺646k
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
    public int countWays(int x, int y) {
    	if(x == 1 || y == 1) return 1;
    	
    	int [][] res = new int[x][y];
    	res[0][0] = 0;
    	for(int i = 0; i < x; i++){
    		res[i][0] = 1;
    	}
    	
    	for(int i = 0; i < y; i++){
    		res[0][i] = 1;
    	}
    	
    	for(int i = 1; i < x; i++){
    		for(int j = 1; j < y; j++){
    			res[i][j] = res[i-1][j] + res[i][j-1];
    		}
    	}
    	return res[x-1][y-1];
    }
	/**
	 * �������
	 * 
	 * �ռ临�Ӷ�:O(min(n,m))
	 * 
	 * �����ʵ��Ż�����res[i][j] ֻ��Ҫres[i-1][j]��res[i][j-1]�������ݣ�
	 * Ҳ����˵����ֻ��Ҫi,i-1�������ݾ��У���ʱ�ռ临�Ӷȿ��Ż�ΪO(min(n,m))
	 * 
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
    public static int countWaysOpt(int x, int y) {
    	if(x == 1 || y == 1) return 1;
    	
    	int [][] res = new int[2][y];
    	res[0][0] = 0;
    	for(int i = 0; i < 2; i++){
    		res[i][0] = 1;
    	}
    	
    	for(int i = 0; i < y; i++){
    		res[0][i] = 1;
    	}
    	
    	for(int i = 1; i < x; i++){
    		int posX = (i % 2 == 1 ? 0 : 1);
    		for(int j = 1; j < y; j++){
    			res[i%2][j] = res[posX][j] + res[i%2][j-1];
    		}
    	}
    	return res[(x-1)%2][y-1];
    }
	public static void main(String[] args) {
		System.out.println("res:" + countWaysOpt(3,3));
	}

}
