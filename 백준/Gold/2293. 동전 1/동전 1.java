/*
1. n, k 입력
2. 동전 가치 입력
3. dp를 이용해 결과 계산
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 1. n, k 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 2. 동전 가치 입력
        int[] coin = new int[n];
        for(int i = 0; i < n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        // 3. dp를 이용해 결과 계산
        int[] dp = new int[k+1]; // 계산 결과를 저장할 dp 배열
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= k; j++){
                // 'k >= 현재 탐색 중인 동전의 가치'인 경우 dp[k] = dp[k] + dp[k - coin[i]]임을 이용한다.
                if(j >= coin[i]){
                    dp[j] = dp[j] + dp[j - coin[i]];
                }
            }
        }
        
        // 4. 결과 출력
        System.out.println(dp[k]);
    }
}