package edu.ouc.offer;

/**
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ����������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,
 * ������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý��������,��������а�������,
 * �Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2,2},
 * ����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)����᲻�ᱻ������ס�� 
 * 
 * @author wqx
 *
 */
public class SumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
    	if(array == null || array.length == 0) return 0;
    	int sum= 0,max = Integer.MIN_VALUE;
    	
        for(int i = 0; i < array.length; i++){
        	if(sum <= 0){
        		sum = array[i];
        	}else{
        		sum += array[i];
        	}
        	if(sum > max){
        		max = sum;
        	}
        }
        return max;
    }
}
