package edu.ouc.cc150;

import java.util.ArrayList;
import java.util.List;

/**
 * 
��Ŀ����

��һƪ�����ں�������ʣ��ָ����������ʣ������һ����Ч�㷨��
�ҳ��������������ʵ���̾���(����������ĵ�����,Ҳ��������������������λ�õĲ�ľ���ֵ)��

����һ��string����article�������������£�
ͬʱ�������µĵ�����n�ʹ����ҵ���������x��y���뷵���������ʵ���̾��롣
��֤�������ʾ������г����Ҳ���ͬ��ͬʱ��֤���µ�����С�ڵ���1000��


 * @author wqx
 *
 */
public class _18_5_DistanceOfTwoString {

	/**
	 * ˼·��
	 * ����article��
	 * �ҳ�����x,y���ֵ�λ�ã������ж�����õ�����λ������posX,poxY,�ֱ��ŵ���x��y���ֵ�����ֵ��
	 * ����ʱ�临�Ӷ�O(N)
	 * 
	 * ��posX��posY�������ƹ鲢�����еĹ鲢�����������м�¼����Ԫ�ص���С��ֵ������ǽ��
	 * 
	 * ����ʱ�临�Ӷ�O(N)
	 * 
	 * @param article
	 * @param n
	 * @param x
	 * @param y
	 * @return
	 */
    public int getDistance(String[] article, int n, String x, String y) {
        List<Integer> posX = new ArrayList<>(0);
        List<Integer> posY = new ArrayList<>(0);
        
        for(int i = 0; i < n; i++){
        	if(x.equals(article[i])){
        		posX.add(i);
        	}
        	if(y.equals(article[i])){
        		posY.add(i);
        	}
        }
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while(i < posX.size() && j < posY.size()){
        	if(min > Math.abs(posX.get(i) - posY.get(j))){
    			min = Math.abs(posX.get(i) - posY.get(j));
    		}        	
        	if(posX.get(i) < posY.get(j)){
        		i++;
        	}else{
        		j++;
        	}
        }
        System.out.println("min:" + min);
        return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
