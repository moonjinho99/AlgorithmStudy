package DP;

import java.util.Scanner;

public class DPEx01 {

	private static int[] dp;
	
	public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        System.out.println("단순 재귀 : "+fibo(n));
        System.out.println("단순 재귀 : "+tdFibo(n));
        System.out.println("단순 재귀 : "+buFibo(n));

    }

    //단순 재귀
	//중복된 계싼을 반복해서 하게 된다. 시간복잡도 O(2^n)으로 x의 수가 커질수록 복잡도가 엄청나게 커짐
    static int fibo(int x){
        if(x == 1 || x ==2) return 1;
        return fibo(x-1) + fibo(x-2);
    }

    //Top-Down
    //하위 문제의 결과 값을 dp[] 배열에 저장해놓고 필요할 때마다 계산된 값을 호출
    static int tdFibo(int x) {
    	if(x == 1 || x == 2) return 1;
    	if(dp[x] != 0) return dp[x];
    	dp[x] = tdFibo(x-1) + tdFibo(x-2);
    	return dp[x];
    }
    
    //Bottom-Up
    static int buFibo(int x) {
    	dp[1] = 1;
    	dp[2] = 1;
    	for(int i=3; i<x+1; i++) {
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	return dp[x];
    }
        
}
