package edu.ouc.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下矩阵： 
1  2  3  4
5  6  7  8 
9 10 11 12 
13 14 15 16 

则依次打印出数字 
1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

 * @author Administrator
 *
 */
public class PrintMatrixClockwise {
	
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int row = matrix.length,col = matrix[0].length;
        
        int totalNum = row * col;
        int cur = 0;
        int r = 0,c = 0;
        int circle = 0;
        while(cur < totalNum){
        	while(c < col-circle && cur < totalNum){result.add(matrix[r][c++]);cur++;}
        	c--;r++;
        	while(r < row-circle && cur < totalNum){ result.add(matrix[r++][c]);cur++;}
        	r--;c--;
        	while(c >= circle && cur < totalNum){result.add(matrix[r][c--]);cur++;}
        	c++;r--;
        	while(r >= circle+1 && cur < totalNum){ result.add(matrix[r--][c]);cur++;}
        	r++;c++;
        	
        	circle++;
        }
        return (ArrayList<Integer>) result;
    }
}
