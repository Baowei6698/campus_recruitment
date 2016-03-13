package edu.ouc.offer;


/**
 * 
��Ŀ����
�������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
����һ�����飬�����������е�����Ե�������

 * @author wqx
 *
 */
public class InversePairs {
	/**
	 * ���ù鲢��������У��ֲ��������ԣ����ٱȽϴ���
	 * ʱ�临�Ӷ�O��nlogn��
	 * 
	 * @param array
	 * @return
	 */
	private int total;
    public int InversePairs(int [] array) {
    	mergeSort(array,0,array.length-1);
    	return total;
    }
	public void mergeSort(int nums[],int low,int high){
		int mid = (low+high)/2;
		if(low < high){
			// ����
			mergeSort(nums,low,mid);
			//�Ұ��
			mergeSort(nums,mid+1,high);
			//����������������ϲ�
			merge(nums,low,mid,high);
		}
	}
	
	public void merge(int nums[],int low,int mid,int high){
		int [] tmp = new int[high-low+1];
		int i = low,j = mid+1,k = 0;
		
		while(i <= mid && j <= high){
			if(nums[i]  > nums[j] ){
				tmp[k] = nums[i];
				total += (high-j+1);
				k++;i++;
			}else {
				tmp[k++] = nums[j++];
			}
		}
		while(i <= mid){
			tmp[k++] = nums[i++];
		}
		while(j <= high){
			tmp[k++] = nums[j++];
		}
		//�µ��������鸲�Ǿ�����
		for(int p = 0; p < tmp.length; p++){
			nums[low+p] = tmp[p];
		}
	}
}
