package ouc.edu.huawei;

import java.util.Scanner;
public class MaxSocre {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			int N = sc.nextInt();
			int M = sc.nextInt();
			int []score = new int[N+1];
			int i = 0;
			for(i = 0; i < N; i++){
				score[i] = sc.nextInt();
			}
			
			for(i=0; sc.hasNext() && i< M; i++){
				String operator = sc.next();
				int A = sc.nextInt();
				int B = sc.nextInt();
				if("Q".equals(operator)){
					System.out.println(max(score,A-1,B-1));
				}else if("U".equals(operator)){
					score[A-1] = B;
				}
			}
		}
	}
	public static int max(int arr[],int a,int b){
		int end = Math.max(a, b);
		int start = Math.min(a, b);
		int max = arr[start];
		for(int i = start; i <= end; i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
		return max;
	}
}
