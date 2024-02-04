/*
1. n 입력
2. 경우의 수를 담을 배열 선언
3. 2*n의 사각형을 채우는 경우의 수는 '2*(n-1)의 경우의수 + 2*(n-2)의 경우의 수'임을 이용하여 계산
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. n 입력
        int n = Integer.parseInt(br.readLine());
        
        // 2. 경우의 수를 담을 배열 선언
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        // 3. 2*n의 사각형을 채우는 경우의 수는 '2*(n-1)의 경우의수 + 2*(n-2)의 경우의 수'임을 이용하여 계산
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}