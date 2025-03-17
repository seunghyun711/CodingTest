/*
1. N, M 입력
2. 각 앱의 메모리 크기 입력
3. 각 앱의 비활성화 비용 입력
4. dp를 이용해 M 바이트를 확보하기 위한 최소 비용 계산
5. 결과 출력
*/
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N, M 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 2. 각 앱의 메모리 크기 입력
        int[] memory = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            memory[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. 각 앱의 비활성화 비용 입력
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        // 4. dp를 이용해 M 바이트를 확보하기 위한 최소 비용 계산
        int[][] dp = new int[N][(N * 100) + 1];
        
        int result = Integer.MAX_VALUE;
        
        // i : 앱, j : 비용
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= (N * 100); j++){
                if(i == 0){ // 현재 탐색하는 앱이 첫번째인 경우
                    if(j >= cost[i]){
                        dp[i][j] = memory[i];
                    }
                }else if(j >= cost[i]){ // 기존에 계산한 j 비용인 경우의 메모리 크기와 현재 탐색 중인 앱이 포함된 메모리 크기 비교 
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
                if(dp[i][j] >= M){
                    result = Math.min(result, j);
                }
            }
        }
        
        // 5. 결과 출력
        System.out.println(result);
    }
}