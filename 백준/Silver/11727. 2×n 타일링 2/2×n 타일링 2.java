/*
1. n 입력
2. dp를 이용해 경우의 수 계산
3. 결과 출력
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. n 입력
        int n = Integer.parseInt(br.readLine());
        
        // 2. dp를 이용해 경우의 수 계산
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }
        
        // 3. 결과 출력
        System.out.println(dp[n]);
        
    }
}
