package edu.ouc.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
��Ŀ����
����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
���磬����������¾��� 
1  2  3  4
5  6  7  8 
9 10 11 12 
13 14 15 16 

�����δ�ӡ������ 
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
