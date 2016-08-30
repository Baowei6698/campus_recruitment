package edu.ouc.cc150;

/**
 * 
题目描述

有一个NxM的整数矩阵，矩阵的行和列都是从小到大有序的。请设计一个高效的查找算法，查找矩阵中元素x的位置。

给定一个int有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，请返回一个二元数组，
代表该元素的行号和列号(均从零开始)。保证元素互异。
测试样例：

[[1,2,3],[4,5,6]],2,3,6

返回：[1,2]

 * 
 * (1)DFS：意料之中的TLE -_-!!!
 * (2)二分查找：先定位行，再定位列（不可行，无法定位）
 * (3)还是二分查找：对整个矩阵进行分块（貌似可以叫四分查找^_^）
 * 思路：对于如题中所述行列有序的矩阵，其中最小的数一定位于左上角，而最大的数肯定位于右下角
 * row，col分别为矩阵行列值，找到矩阵的中心点（i,j）（i=row/2,j=col/2），将矩阵一分为四：
 *  1 | 2
 * ———|———
 *  3 | 4
 * 矩阵1：最小值（0,0），最大值（i,j）
 * 矩阵2：最小值（0,j+1），最大值（i,col-1）
 * 矩阵3：最小值（i+1,0），最大值（row-1,j+1）
 * 矩阵4：最小值（i+1,j+1），最大值（row-1,col-1）
 * 比较target和四个子矩阵的最大值和最小值，确定target在哪个矩阵。
 * 划分到什么情况下就不用划分了？
 * 当子矩阵为单行或单列时就不需要划分了，此时通过顺序比较就可以。(哈哈哈哈。。。)
 * 
 * 总结：
 * AC后仔细想了想，其实就是分治的思路：
 * 1.如何分：对矩阵按中心点（i,j）进行分块,把一个大矩阵分为四个小的子矩阵，再在每个子矩阵中做同样的操作
 * 2.分到何时：当子矩阵是行矩阵或列矩阵的时候，此时就不需要再划分了。
 * 3.如何治：当得到了行矩阵或列矩阵的子矩阵，只要挨个遍历比较每个元素和target的值是否相同即可。
 *
 * @author wqx
 */
public class _11_6_FindElementInMatrix {
	
	private static boolean result;
	/**
	 * (startRow，startCol)为矩阵的左上角坐标
	 * (endRow，endCol)为矩阵的右下角坐标
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
			//(startRow,startCol)(endRow,endCol)代表的矩阵以(midRow,midCol)为中心一分为四，判断target位于哪一个矩阵内
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
