package edu.ouc.offer;

/**
 * 
题目描述
在一个二维数组中，每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，
输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

输入描述:
array： 待查找的二维数组
target：查找的数字

输出描述:
查找到返回true，查找不到返回false


 * @author wqx
 *
 */
public class FindNumInMatrix {
	/**
	 * 分治
	 * @param array
	 * @param target
	 * @return
	 */
	public boolean result;
    public boolean Find(int [][] array,int target) {
		search(array,target,0,0,array.length,array[0].length);
		return result;
    }
    public void search(int[][] matrix,int target,int startRow,int startCol,int endRow,int endCol){
    	//行矩阵
    	if(startRow == endRow){
    		while(startCol <= endCol){
    			if(matrix[startRow][startCol++] == target) result = true;
    		}
    	}else if(startCol == endCol){//列矩阵
            while(startRow <= endRow){
                if(matrix[startRow++][startCol] == target) result = true;
            }
        }else{
        	int midRow = (startRow+endRow)/2,midCol = (startCol+endCol)/2;
        	if(target >= matrix[startRow][startCol] && target <= matrix[midRow][midCol]){
        		search(matrix,target,startRow,startCol,midRow,midCol);
        	}
        	if(target >= matrix[startRow][midCol+1] && target <= matrix[midRow][endCol]){
        		search(matrix,target,startRow,midCol+1,midRow,endCol);
        	}
        	if(target >= matrix[midRow+1][startCol] && target <= matrix[endRow][midCol]){
                search(matrix,target,midRow+1,startCol,endRow,midCol);
            }
            if(target >= matrix[midRow+1][midCol+1] && target <= matrix[endRow][endCol]){
                search(matrix,target,midRow+1,midCol+1,endRow,endCol);
            }
        }
    }
}
