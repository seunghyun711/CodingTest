/*
1. n 입력
2. n을 1,2,3의 합으로 나타낼 수 있는 경우의 수를 담을 배열 선언
3. 1,2,3을 각각 1,2,3의 합으로 나타낼 수 있는 경우의 수를 저장
4. n을 1,2,3의 합으로 나타낼 수 있는 경우의 수는 n-1의 경우의 수 + n-2의 경우의 수 + n-3의 개수임을 이용하여 계산한다.
5. n개 숫자 입력, 결과 출력
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. n 입력
        int n = Integer.parseInt(br.readLine());
        
        // 2. n을 1,2,3의 합으로 나타낼 수 있는 경우의 수를 담을 배열 선언
        int[] dp = new int[11];
        
        // 3. 1,2,3을 각각 1,2,3의 합으로 나타낼 수 있는 경우의 수를 저장
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        // 4. n을 1,2,3의 합으로 나타낼 수 있는 경우의 수는 n-1의 경우의 수 + n-2의 경우의 수 + n-3의 개수임을 이용하여 계산한다.
        for(int i = 4; i <= 10; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        // 5. n개 숫자 입력, 결과 출력
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            System.out.println(dp[num]);
        }
    }
}