package edu.ouc.cc150;

/**
 * ��Ŀ����

�����һ���㷨�����������n�ʺ����⡣�����n�ʺ�����ָ��һ��nxn�������Ϸ���n�����ӣ�
ʹ��ÿ��ÿ�к�ÿ���Խ����϶�ֻ��һ�����ӣ�����ڷŵķ�������

����һ��int n���뷵�ط���������֤nС�ڵ���10
����������

1

���أ�1

 * @author wqx
 *
 */
public class _9_9_Queen {
	
	private static int count = 0;
	/**
	 * ����һ��dfs���ռ临�Ӷ�O(n*n)
	 * 
	 * @param n
	 * @return
	 */
    public int nQueens(int n) {
    	int[][] map = new int[n][n];
    	dfs(map,0,n);
		return count;
    }
    public void dfs(int[][]map, int row, int n){
    	if(row == n){
    		count++;
    	}else{
    		for(int i = 0; i < n; i++){
    			if(illegal(map,row,i,n)){
    				map[row][i] = 1;
    				dfs(map,row+1,n);
    				map[row][i] = 0;
    			}
    		}
    	}
    }
    public boolean illegal(int[][] map, int row, int col, int n){
    	int i = row , j = col;
    	while(i >= 0){
    		if(map[i--][j] == 1)
    			return false;
    	}
    	i = row ; j = col;
    	//������϶Խ���
    	while(i >= 0 && j >= 0){
    		if(map[i--][j--] == 1)
    			return false;
    	}
    	i = row ; j = col;
    	//������϶Խ���
    	while(i >= 0 && j < n){
    		if(map[i--][j++] == 1)
    			return false;
    	}
    	return true;
    }
	/**
	 * ���������Ľ�dfs�����Ϳռ临�Ӷȵ�O(n)
	 * 
	 * @param n
	 * @return
	 */
    public int nQueens_Opt(int n) {
    	//a[i]=j ��ʾ��i�еĵ�j���Ѿ����ûʺ�
    	int[] a = new int[n+1];
    	dfs2(a,1,n);
		return count;
    }
    public void dfs2(int a[] ,int i, int n){
    	if(i > n){
    		count++;
    	}else{
    		for(int j = 1; j <= n; j++){
    			a[i] = j;
    			//�жϵ�i�е�j���Ƿ�Ϸ�
    			if(illegal2(a,i)){
    				dfs2(a,i+1,n);
    			}
    		}
    	}
    }
    public boolean illegal2(int[] a, int i){
    	for(int k = 1; k < i; k++){
    		if(a[i] == a[k] || ((a[i]-a[k])==(i-k)) || ((a[i]-a[k])==(k - i))){
    			return false;
    		}
    	}
    	return true;
    }
	public static void main(String[] args) {
		int n = 4;
		System.out.println("result:" + new _9_9_Queen().nQueens_Opt(n));
	}

}
