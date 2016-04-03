package edu.ouc.offer;

public class DuplicateNum {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
    	for(int i = 0; i < length; i++){
    		for(int j = i+1; j < length; j++){
    			if(numbers[j] == numbers[i]){
    				duplication[0] = numbers[j];
    				return true;
    			}
    		}
    	}
    	return false;
    }
    /**
     * numbers[i] ��0��n-1֮��
     * 
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	   for ( int i= 0 ; i<length; i++) {
    	        int index = numbers[i];
    	        if (index >= length) {
    	            index -= length;
    	        }   
    	        if (numbers[index] >= length) {
    	            return true;
    	        }
    	        numbers[index] = numbers[index] + length;
    	    }   
    	    return false;  
    }
}
