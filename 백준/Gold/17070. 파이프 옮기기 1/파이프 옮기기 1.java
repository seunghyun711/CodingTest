/*
1. N 입력
2. 집의 상태 입력
3. dfs를 이용해 방향별로 파이프를 옮길 수 있는 위치 탐색 및 목적지까지 이동하는 경우의 수 계산
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int[][] home; // 집의 상태를 나타내는 2차원 배열
    static int result = 0; // 결과
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N 입력
        N = Integer.parseInt(br.readLine());
        
        // 2. 집의 상태 입력
        home = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 3. dfs를 이용해 방향별로 파이프를 옮길 수 있는 위치 탐색 및 목적지까지 이동하는 경우의 수 계산
        dfs(0,1,0);
        
        System.out.println(result);
    }
    
    // dfs로 오른쪽, 아래, 대각선으로 움직이면서 목적지까지 이동하는 경우의 수를 계산
    static void dfs(int row, int col, int direction){ 
        /*
        direction : 방향 
        0 : → 
        1 : ↓ 
        2 : ↘ 
        */
        if(row > (N-1) || col > (N-1) || home[row][col] == 1){ // 집의 범위를 넘어가는 경우 return
            return;
        } 
        if(direction == 2){
            if(home[row][col-1] == 1 || home[row-1][col] == 1){ // 대각선 주변 빈칸이어야 하는 위치가 빈칸이 아닌 경우 return
                return;
            }
        }
        if(row == (N-1) && col == (N-1)){ // 목적지에 도달한 경우
            result++;
            return;
        }
        if(direction == 0){ // → 방향인 경우
            dfs(row, col + 1, 0); // 오른쪽으로 이동
            dfs(row + 1, col + 1, 2); // 대각선 아래로 이동
        }
        else if(direction == 1){ // ↓ 방향인 경우
            dfs(row + 1, col, 1); // 아래로 이동
            dfs(row + 1, col + 1, 2); // 대각선 아래로 이동 
        }
        else if(direction == 2){ // ↘ 방향인 경우
            dfs(row, col + 1, 0); // 오른쪽으로 이동
            dfs(row + 1, col, 1); // 아래로 이동
            dfs(row + 1, col + 1, 2); // 대각선 아래로 이동
        }
        
    }
}