/*
1. scv의 수(N) 입력
2. scv의 체력 입력
3. dp를 이용해 공격 횟수 계산
*/
import java.io.*;
import java.util.*;
public class Main{
    static int[] scv = new int[3]; // scv의 체력을 담은 배열
    static int[][][] dp; // dp 배열
    // 모든 공격의 경우의 수
    static int[][] damage = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        
        // 1. scv의 수(N) 입력
        int N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        // 2. scv의 체력 입력
        for(int i = 0; i < N; i++){
            scv[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[scv[0] + 1][scv[1] + 1][scv[2] + 1]; // dp 배열 초기화
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                Arrays.fill(dp[i][j], -1); // dp 배열의 값을 -1로 초기화
            }
        }
        
        // 3. dp를 이용해 공격 횟수 계산
        System.out.println(attack(scv[0], scv[1], scv[2]));
    }
    
    // 뮤탈의 공격 횟수를 구하는 메서드
    static int attack(int scv1, int scv2, int scv3){
        scv1 = Math.max(scv1, 0);
        scv2 = Math.max(scv2, 0);
        scv3 = Math.max(scv3, 0);
        
        // 모든 scv의 체력이 0인 경우
        if(scv1 == 0 && scv2 == 0 && scv3 == 0){
            return 0;
        }
        
        // 이미 공격 횟수를 계산한 경우
        if(dp[scv1][scv2][scv3] != -1){
            return dp[scv1][scv2][scv3];
        }
        
        int result = Integer.MAX_VALUE;
        
        // 모든 공격의 경우의 수를 계산하여 최소 공격 횟수를 도출
        result = Math.min(result, attack(scv1-damage[0][0], scv2-damage[0][1], scv3-damage[0][2]) + 1);
        result = Math.min(result, attack(scv1-damage[1][0], scv2-damage[1][1], scv3-damage[1][2]) + 1);
        result = Math.min(result, attack(scv1-damage[2][0], scv2-damage[2][1], scv3-damage[2][2]) + 1);
        result = Math.min(result, attack(scv1-damage[3][0], scv2-damage[3][1], scv3-damage[3][2]) + 1);
        result = Math.min(result, attack(scv1-damage[4][0], scv2-damage[4][1], scv3-damage[4][2]) + 1);
        result = Math.min(result, attack(scv1-damage[5][0], scv2-damage[5][1], scv3-damage[5][2]) + 1);
        
        dp[scv1][scv2][scv3] = result;
        
        return dp[scv1][scv2][scv3];
    }
}