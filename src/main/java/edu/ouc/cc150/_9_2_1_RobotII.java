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
   	if(x == 1 || y == 1) return 1;
    	
    	int [][] res = new int[x][y];
    	res[0][0] = 0;
    	for(int i = 0; i < x; i++){
    		if(map[i][0] != 1){//�����ϰ���
    			break;
    		}
    		res[i][0] = 1;
    	}
    	for(int i = 0; i < y; i++){
    		if(map[0][i] != 1){//�����ϰ���
    			break;
    		}
    		res[0][i] = 1;
    	}
    	
    	for(int i = 1; i < x; i++){
    		for(int j = 1; j < y; j++){
    			if(map[i][j] != 1){//�ϰ���
    				res[i][j] = 0;
    			}else{
    				res[i][j] = (res[i-1][j] + res[i][j-1]) % 1000000007;
    			}
    		}
    	}
    	return res[x-1][y-1];
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
    	int[][] map = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,0,1,1},{0,1,1,1},{1,1,1,1},{1,1,1,1}};
    	int res = new _9_2_1_RobotII().countWays(map,11,4);
    	dfs(map,0,0);
    	System.out.println("res:" + res + ",count:" + count);
    }
}
