package edu.ouc.netease;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ŀ����
	����������ļ��ϣ����ϵ�ÿ��Ԫ�ض���һ�η�Χ�����佻����
	���缯��{[4,8],[9,13]}��{[6,12]}�Ľ���Ϊ{[6,8],[9,12]}
	
 * @author wqx
 *
 */
public class InterSet {
	
	public static List<ArrayList<Integer>> getIntersection(List<List<Integer>> list1,List<List<Integer>> list2){
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int i = 0,j = 0;
		while(i < list1.size() && j < list2.size()){
			List<Integer> a = list1.get(i);
			List<Integer> b = list2.get(j);
			ArrayList<Integer> r = new ArrayList<Integer>();
			if(a.get(0) > b.get(1)){ 
				j++;
			}else if(a.get(1) < b.get(0)){
				i++;
			}else if(a.get(0) >= b.get(0) && a.get(0) <= b.get(1)){
				r.add(a.get(0));
				if(a.get(1) <= b.get(1)){
					r.add(a.get(1));
					i++;
				}else{
					r.add(b.get(1));
					j++;
				}
				result.add(r);
			}else if(b.get(0) >= a.get(0) && b.get(0) <= a.get(1)){
				r.add(b.get(0));
				if(b.get(1) <= a.get(1)){
					r.add(b.get(1));
					j++;
				}else{
					r.add(a.get(1));
					i++;
				}
				result.add(r);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "81*(3-21)+3";
		String[] result = str.split("\\D");
		
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i] + ",");
		}
		
	}
}
