package edu.ouc.offer;

/**
 * 
��Ŀ����
��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
ÿһ�ж����մ��ϵ��µ�����˳�����������һ��������
����������һ����ά�����һ���������ж��������Ƿ��и�������

��������:
array�� �����ҵĶ�ά����
target�����ҵ�����

�������:
���ҵ�����true�����Ҳ�������false


 * @author wqx
 *
 */
public class FindNumInMatrix {
	/**
	 * ����
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
    	//�о���
    	if(startRow == endRow){
    		while(startCol <= endCol){
    			if(matrix[startRow][startCol++] == target) result = true;
    		}
    	}else if(startCol == endCol){//�о���
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
