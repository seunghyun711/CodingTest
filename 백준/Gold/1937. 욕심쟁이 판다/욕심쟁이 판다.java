/*
1. 대나무 숲의 크기 n 입력
2. 대나무 숲의 정보 입력
3. dfs와 dp를 이용해 판다가 이동할 수 있는 칸의 최댓값 계산
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] dp;
    static int[][] map;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. 대나무 숲의 크기 n 입력
        n = Integer.parseInt(br.readLine());
        
        // 2. 대나무 숲의 정보 입력
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp = new int[n][n]; // dp 배열 초기화
        
        // 3. dfs와 dp를 이용해 판다가 이동할 수 있는 칸의 최댓값 계산
        int result = 0;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                result = Math.max(result, dfs(r, c));
            }
        }
        
        // 4. 결과 출력
        System.out.println(result);
    }
    
    // dfs 메서드
    static int dfs(int r, int c){
        if(dp[r][c] != 0){ // dp[x][y]가 0이 아닌 경우 해당 값 리턴(이후에 dp[x][y] = 1을 하기 때문에 0이 아니면 해당 위치는 계산된 것으로 간주)
            return dp[r][c];
        }
        dp[r][c] = 1; // 현재 위치 기준으로 이동한 칸의 개수는 1개(현재 위치)
        
        int movedR = 0;
        int movedC = 0;
        
        // 현재 위치에서 상하좌우를 움직여 이동할 수 있는 칸의 개수 계산
        for(int i = 0; i < 4; i++){
            movedR = r + dr[i];
            movedC = c + dc[i];
            
            // 현재 위치가 범위에 벗어나면 다음 위치로 넘어감
            if(movedR < 0 || movedC < 0 || movedR >= n || movedC >= n){
                continue;
            }
            
            if(map[r][c] < map[movedR][movedC]){
                dp[r][c] = Math.max(dp[r][c], dfs(movedR, movedC) + 1);
            }
        }
        
        return dp[r][c];
    }
}