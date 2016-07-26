package edu.ouc.jd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ѡ����Ϸ
Time Limit: 2000/1000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
Problem Description:
С��������С����������һ������ѡ�ٵ���Ϸ��ѡ����ͨ��ͶƱ�ķ�ʽ���еģ���Ʊ�����˽���ʤ��

С���Ǳ��Ϊ1�ĺ�ѡ�ߣ����⻹�������ĺ�ѡ�߲μ�ѡ�١����ݳ����ĵ������������׼��ͶƱ��С���Ѷ���һ����ͶƱ�����ԣ�
С�����Ҫ���ʤ����������ȡ����׼��Ϊ������ѡ��ͶƱ��С���ѡ�����С������Դ��Ϊ���ޣ���ϣ������С�Ĵ���Ӯ��ʤ����
�����æ������������Ҫ��ȡ��ѡƱ����

����
�����������飬ÿ��������У���һ��Ϊһ��������n��2<=n<=100������ʾ��ѡ�ߵ��������ڶ���Ϊÿ����ѡ��Ԥ�ڵõ���ѡƱ����
�Կո�ֿ���ÿ�˵�Ԥ�ڵ�Ʊ����1��1000֮�䣨����1��1000����
����С������ȡ�󣬿��ܳ��ֺ�ѡ�˵�Ʊ��Ϊ0�򳬹�1000�������
���
��ÿ��������ݣ��������һ�У�����ΪС��������Ҫ��ȡ��ѡƱ����

��������
5
5 1 11 2 8
4
1 8 8 8
2
7 6
�������
4
6
0

 * @author wqx
 *
 */
public class JDProblem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n;
		while(in.hasNext()){
			n = in.nextInt();
			int arr[] = new int[n];
			for(int i = 0; i < n; i++){
				arr[i] = in.nextInt();
			}
			//int pos = partition(arr,0,arr.length-1);
			
			int low = 0,high = arr.length-1;
			int count = 0;
			while(true){
				int pos = partition(arr,low,high);
				//System.out.println(Arrays.toString(arr));
				if(pos == high){
					if(arr[high] == arr[high-1])
						count++;
					break;
				}
				//System.out.println("pos:" + pos);
				for(int i = pos+1; i <= high; i++){
					arr[i]--;
					arr[pos]++;
					count++;
				}
				low = pos;
			}
			System.out.println("count:" + count);
		}
	}
	private static int partition(int array[], int low, int high) {
		int key = array[low];
		while(low < high){
			while(low < high && array[high] > key){
				high--;
			}
			array[low] = array[high];

			while(low < high && array[low] <= key){
				low++;
			}
			array[high] = array[low];
		}
		array[low] = key;
		return low;
	}
}
