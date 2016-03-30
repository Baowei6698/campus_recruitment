package edu.ouc.codeforces.round344;

import java.util.Scanner;

/**
 * Blake is a CEO of a large company called "Blake Technologies". 
 * He loves his company very much and he thinks that his company 
 * should be the best. That is why every candidate needs to pass 
 * through the interview that consists of the following problem.

We define function f(x, l, r) as a bitwise OR of integers xl, xl + 1, ..., xr, 
where xi is the i-th element of the array x. You are given two arrays a and b 
of length n. You need to determine the maximum value of sum f(a, l, r) + f(b, l, r) 
among all possible 1 ≤ l ≤ r ≤ n.


 * @author wqx
 *
 */
public class A_Interview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int a,b;
			long sum1 = 0,sum2 = 0;
			for(int i = 1;i <= n; i++){
				sum1 |= in.nextInt();
			}
			for(int i = 1;i <= n; i++){
				sum2 |= in.nextInt();;
			}
			System.out.println(sum1+sum2);
		}
	}

}
