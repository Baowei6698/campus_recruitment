package edu.ouc.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
��Ŀ����
С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��û���,
���͵õ���һ������������Ϊ100������:18,19,20,21,22�����ڰ����⽻����,
���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!

�������:

������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��


 * @author wqx
 *
 */
public class FindContinuousSequence {
	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i = 1; i <= sum/2; i++){
			int s = 0;
			for(int j = i; j < sum; j++){
				s += j;
				if(s > sum)break;
				if(s == sum){
					ArrayList<Integer> list = new ArrayList<>();
					for(int t = i; t <= j; t++){
						list.add(t);
					}
					result.add(list);
					break;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 3;
		ArrayList<ArrayList<Integer>> result = FindContinuousSequence(sum);
		for(int i = 0; i < result.size(); i++){
			List<Integer> list = result.get(i);
			for(int j = 0; j < list.size(); j++){
				System.out.print(list.get(j) + ",");
			}
			System.out.println();
		}
	}

}
