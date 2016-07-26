package edu.ouc.offer;

import java.util.Arrays;

/**
 * 
��Ŀ����
LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,
������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
�����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�
Ϊ�˷������,�������Ϊ��С����0��


 * @author wqx
 *
 */
public class ContinuousPoker {

    public static boolean isContinuous(int [] numbers) {
    	if(numbers == null || numbers.length != 5) return false;
    	
    	Arrays.sort(numbers);
    	int jokers = 0, i = 0;
    	while(numbers[i] == 0){
    		jokers++;
    		i++;
    	}
    	System.out.println("jokers:" + jokers);
    	boolean flag = true;
    	for(i++; i < 5; i++){
    		int gap = numbers[i] - numbers[i-1];
    		if(gap != 1){
    			jokers -= (gap-1);
    		}
    		if(jokers < 0 || gap == 0){
    			flag = false;
    			break;
    		}
    	}
    	return flag;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {1,3,0,7,0};
		int [] arr1 = {1,0,0,1,0};
		System.out.println("result:" + isContinuous(arr1));
	}

}
