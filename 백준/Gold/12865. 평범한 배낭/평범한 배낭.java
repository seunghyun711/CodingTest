/*
1. N, K 입력
2. 물건의 무게(W)와 가치(V) 입력 
3. dp를 이용해 배낭에 들어갈 수 있는 물건들의 최대 가치합을 구한다.
*/
import java.io.*;
import java.util.*;
public class Main{
    static int[][] dp;
    static int[] W; // 무게
    static int[] V; // 가치
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1. N, K 입력
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        W = new int[N + 1];
        V = new int[N + 1];
        dp = new int[N + 1][K + 1];
        
        // 2. 물건의 무게(W)와 가치(V) 입력 
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. dp를 이용해 배낭에 들어갈 수 있는 물건들의 최대 가치합을 구한다.
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                dp[i][j] = dp[i-1][j]; // 이전 값 복사
                if(j - W[i] >= 0){ // 배낭에 물건을 넣을 수 있는 경우
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-W[i]] + V[i]);
                }
            }
        }
        
        System.out.println(dp[N][K]);
    }
}