package edu.ouc.cc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * ���ϵ��Ӽ�
 * 
��Ŀ����

���дһ������������ĳ���ϵ����зǿ��Ӽ���

����һ��int����A������Ĵ�Сint n���뷵��A�����зǿ��Ӽ�����֤A��Ԫ�ظ���С�ڵ���20����Ԫ�ػ��졣
���Ӽ��ڲ��Ӵ�С����,�Ӽ�֮���ֵ��������򣬼�������
����������

[123,456,789]

���أ�{[789,456,123],[789,456],[789,123],[789],[456 123],[456],[123]}



 * @author wqx
 *
 */
public class _9_4_Subsets {

	public static ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> seq = new ArrayList<Integer>();
		dfs(A,0,result,seq,n);
		//�Ӽ�֮���ֵ�������
		Collections.sort(result,new Comparator<ArrayList<Integer>>(){
			public int compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
				String str1 = Arrays.toString(arr1.toArray());
				String str2 = Arrays.toString(arr2.toArray());
				if(str1.startsWith(str2.substring(0,str2.length()-1))){
					return -1;
				}
				if(str2.startsWith(str1.substring(0,str1.length()-1))){
					return 1;
				}
				return str2.compareTo(str1);
			}
		});
		return result;
	}
	@SuppressWarnings("unchecked")
	public static void dfs(int[] A ,int index, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> seq, int n){
		if(index == n){
			if(seq.size() > 0){
				ArrayList<Integer> list = (ArrayList<Integer>) seq.clone();
				//�Ӽ��ڲ��Ӵ�С����
				Collections.sort(list, new Comparator<Integer>(){
					public int compare(Integer a,Integer b){
						return b.compareTo(a);
					}
				});
				res.add(list);
			}
		}else{
			seq.add(A[index]);
			dfs(A,index+1,res,seq,n);
			seq.remove(Integer.valueOf(A[index]));
			dfs(A,index+1,res,seq,n);
		}
	}
	public static void main(String[] args) {
		int[] A = {123,456,789};
		int n = 3;
		ArrayList<ArrayList<Integer>> result = getSubsets(A,n);
		System.out.println("size:" + result.size());
		for(int i = 0; i < result.size(); i++){
			ArrayList<Integer> res = result.get(i);
			System.out.println(Arrays.toString(res.toArray()));
		}
	}

}
