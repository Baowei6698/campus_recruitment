package edu.ouc.cc150;

/**
 * 
��Ŀ����

��һ��NxM���������󣬾�����к��ж��Ǵ�С��������ġ������һ����Ч�Ĳ����㷨�����Ҿ�����Ԫ��x��λ�á�

����һ��int�������mat��ͬʱ��������Ĵ�Сn��m�Լ���Ҫ���ҵ�Ԫ��x���뷵��һ����Ԫ���飬
�����Ԫ�ص��кź��к�(�����㿪ʼ)����֤Ԫ�ػ��졣
����������

[[1,2,3],[4,5,6]],2,3,6

���أ�[1,2]

 * 
 * (1)DFS������֮�е�TLE -_-!!!
 * (2)���ֲ��ң��ȶ�λ�У��ٶ�λ�У������У��޷���λ��
 * (3)���Ƕ��ֲ��ң�������������зֿ飨ò�ƿ��Խ��ķֲ���^_^��
 * ˼·������������������������ľ���������С����һ��λ�����Ͻǣ����������϶�λ�����½�
 * row��col�ֱ�Ϊ��������ֵ���ҵ���������ĵ㣨i,j����i=row/2,j=col/2����������һ��Ϊ�ģ�
 *  1 | 2
 * ������|������
 *  3 | 4
 * ����1����Сֵ��0,0�������ֵ��i,j��
 * ����2����Сֵ��0,j+1�������ֵ��i,col-1��
 * ����3����Сֵ��i+1,0�������ֵ��row-1,j+1��
 * ����4����Сֵ��i+1,j+1�������ֵ��row-1,col-1��
 * �Ƚ�target���ĸ��Ӿ�������ֵ����Сֵ��ȷ��target���ĸ�����
 * ���ֵ�ʲô����¾Ͳ��û����ˣ�
 * ���Ӿ���Ϊ���л���ʱ�Ͳ���Ҫ�����ˣ���ʱͨ��˳��ȽϾͿ��ԡ�(��������������)
 * 
 * �ܽ᣺
 * AC����ϸ�����룬��ʵ���Ƿ��ε�˼·��
 * 1.��η֣��Ծ������ĵ㣨i,j�����зֿ�,��һ��������Ϊ�ĸ�С���Ӿ�������ÿ���Ӿ�������ͬ���Ĳ���
 * 2.�ֵ���ʱ�����Ӿ������о�����о����ʱ�򣬴�ʱ�Ͳ���Ҫ�ٻ����ˡ�
 * 3.����Σ����õ����о�����о�����Ӿ���ֻҪ���������Ƚ�ÿ��Ԫ�غ�target��ֵ�Ƿ���ͬ���ɡ�
 *
 * @author wqx
 */
public class _11_6_FindElementInMatrix {
	
	private static boolean result;
	/**
	 * (startRow��startCol)Ϊ��������Ͻ�����
	 * (endRow��endCol)Ϊ��������½�����
	 */
	public static void search(int[][] matrix, int target,int startRow,int startCol,int endRow,int endCol,int[] res) {
		if(startRow == endRow){
			while(startCol <= endCol){
				if(matrix[startRow][startCol++] == target){
					res[0] = startRow;
					res[1] = startCol-1;
					result = true;
				}
			}
		}else if(startCol == endCol){
			while(startRow <= endRow){
				if(matrix[startRow++][startCol] == target){
					res[0] = startRow - 1;
					res[1] = startCol;
					result = true;
				}
			}
		}else{
			int midRow = (startRow+endRow)/2,midCol = (startCol+endCol)/2;
			System.out.println("midRow:" + midRow + ",midCol:" + midCol);
			//(startRow,startCol)(endRow,endCol)����ľ�����(midRow,midCol)Ϊ����һ��Ϊ�ģ��ж�targetλ����һ��������
			if(target >= matrix[startRow][startCol] && target <= matrix[midRow][midCol]){
				search(matrix,target,startRow,startCol,midRow,midCol,res);
			}
			if(target >= matrix[startRow][midCol+1] && target <= matrix[midRow][endCol]){
				search(matrix,target,startRow,midCol+1,midRow,endCol,res);
			}
			if(target >= matrix[midRow+1][startCol] && target <= matrix[endRow][midCol]){
				search(matrix,target,midRow+1,startCol,endRow,midCol,res);
			}
			if(target >= matrix[midRow+1][midCol+1] && target <= matrix[endRow][endCol]){
				search(matrix,target,midRow+1,midCol+1,endRow,endCol,res);
			}
		}
	}
    public int[] findElement(int[][] mat, int n, int m, int x) {
    	int [] res = new int[2];
    	search(mat,x,0,0,n-1,m-1,res);
    	return res;
    }
	public static void main(String[] args) {
		int[][] mat = {{1,2,3},{4,5,6}};
		int[] arr = new _11_6_FindElementInMatrix().findElement(mat,2,3,6);
		System.out.println("x:" + arr[0] + ",y:" + arr[1]);
	}

}
