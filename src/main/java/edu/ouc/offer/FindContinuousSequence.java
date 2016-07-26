package edu.ouc.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

输出描述:

输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序


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
