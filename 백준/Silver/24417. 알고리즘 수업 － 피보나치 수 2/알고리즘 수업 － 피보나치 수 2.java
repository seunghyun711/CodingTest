/*
1. n 입력
2. dp를 이용한 피보나치 수와 실행횟수 계산(dp[n]인 경우 fibo(n)의 값을 의미)
3. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 1. n 입력
        int n = Integer.parseInt(br.readLine());
        
        // 2. dp를 이용한 피보나치 수와 실행횟수 계산(dp[n]인 경우 fibo(n)의 값을 의미)
        int fibo = fiboByDp(n);
        int result = count % 1000000007;
        
        // 4. 결과 출력
        sb.append(fibo).append(" ").append(result);
        System.out.println(sb);
    }
    
    // dp를 이용한 피보나치 수 실행 횟수 계산
    static int fiboByDp(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i = 3; i <= n; i++){
            count++;
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}