package edu.ouc.offer;

/**
 * 
��Ŀ����
ͳ��һ�����������������г��ֵĴ�����

 * @author wqx
 *
 */
public class GetNumberOfK {
	
    public int GetNumberOfK(int [] array , int k) {
        int first = -1,last = -1;
        for(int i = 0; i < array.length; i++){
             if(array[i] == k){
                 first = i;
                 break;
             }
         }
         
         for(int i = array.length-1; i >= 0 ; i--){
             if(array[i] == k){
                 last = i;
                 break;
             }
         }
 		if(last == -1 ){
             return 0;
         }else{
             return (last-first+1);
         }
     }
}
