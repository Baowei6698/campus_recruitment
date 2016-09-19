package edu.ouc.cc150;

/**
 * 
��Ŀ����

��һ��XxY������һ��������ֻ���߸����ֻ�����һ������ߣ�Ҫ�����Ͻ��ߵ����½ǡ������һ���㷨������������ж������߷���
ע����ε���������Щ�ϰ����ǲ����ߵġ�

����һ��int[][] map(C++ ��Ϊvector >),��ʾ����ͼ����map[i][j]Ϊ1��˵���õ㲻���ϰ��㣬������Ϊ�ϰ���
�������int x,int y����ʾ����Ĵ�С��
�뷵�ػ����˴�(0,0)�ߵ�(x - 1,y - 1)���߷�����Ϊ�˷�ֹ������뽫���Mod 1000000007����֤x��y��С�ڵ���50

 * @author wqx
 *
 */
public class _9_2_1_RobotII {

	/**
	 * ˼·���ܵ��߷�-·���ϰ�����߷�
	 * 
	 * ��·���ϰ�����߷�ʱ������Щ�߷��ظ�����������Ҫ�ر����
	 * 
	 * @param map
	 * @param x
	 * @param y
	 * @return
	 */
    public int countWays(int[][] map, int x, int y) {
    	int result = 0;
    	
//    	int total = countWaysOpt(x,y);
    	
    	for(int i = 0; i < x; i++){
    		for(int j = 0; j < y; j++){
    			if(map[i][j] == 1){
    				
    			}
    		}
    	}
    	
    	return result;
    }
    private static int count = 0;
    
    /**
     * ��Ȼ���� TLE ����������������
     * 
     * @param map
     * @param x
     * @param y
     */
    public static void dfs(int[][] map,int x,int y){
    	//Խ����
    	if(x < 0 || x >= map.length || y < 0 || y >= map[0].length) return ;
    	//�ϰ���
    	if(map[x][y] == 0) return;
    	
    	if(x == map.length-1 && y == map[0].length-1){
    		count++;
    		count %= 1000000007;
    		return ;
    	}
    	dfs(map,x+1,y);
    	dfs(map,x,y+1);
    }
    public static void main(String[] args) {
    	//int[][] map = {{0,1,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    	int[][] map = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,0,1,1},{0,1,1,1},{1,1,1,1},{1,1,1,1}};
    	
    	dfs(map,0,0);
    	System.out.println("count:" + count);
    }
    public static int countWaysWithNoBarrier(int x, int y) {
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

}
