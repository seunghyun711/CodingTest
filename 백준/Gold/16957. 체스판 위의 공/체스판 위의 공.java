/*
1. R, C 입력
2. 체스판 정보 입력
3. 각 체스판의 칸에 있는 요소 값에 따라 공 이동
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int R, C;
    static int[][] board;
    static int[][] balls;
    
    // r,c에서 최종적으로 이동하는 위치
    static int[][] parentR;
    static int[][] parentC;

    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 1. R, C 입력
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        // 2. 체스판 정보 입력
        board = new int[R][C];
        balls = new int[R][C]; 
        parentR = new int[R][C]; 
        parentC = new int[R][C]; 
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                parentR[i][j] = -1;
                parentC[i][j] = -1;
            }
        }
        
        // 3. 각 체스판의 칸에 있는 요소 값에 따라 공 이동
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                int[] destination = findDest(i, j); // i,j에서 최종적 목적지
                balls[destination[0]][destination[1]]++;
            }
        }
        
        // 4. 결과 출력
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(balls[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    // 최종 도착지점을 찾는 메서드
    static int[] findDest(int r, int c){
        if(parentR[r][c] != -1 && parentC[r][c] != -1){ // r,c에서 최종 목적지를 구한 경우 해당 위치를 리턴
            return new int[]{parentR[r][c], parentC[r][c]};
        }
        
        int minR = r;
        int minC = c;
        int minValue = board[r][c];
        
        // 현재 위치를 기준으로 인접 8방향 탐색
        for(int i = 0; i < 8; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            // 이동한 위치가 체스판 범위 내에 존재하고 가장 작은 요소를 가지고 있는 경우
            if(isRange(nr, nc) && board[nr][nc] < minValue){
                minValue = board[nr][nc];
                minR = nr; // 최솟값을 가지는 row
                minC = nc; // 최솟값을 가지는 column
            }
        }
        
        if(minR == r && minC == c){ // 현재 위치가 최솟값인 경우
            parentR[r][c] = r;
            parentC[r][c] = c;
        }else{ // 현재 위치가 최소가 아닌경우 다음 탐색 진행
            int[] dest = findDest(minR, minC);
            parentR[r][c] = dest[0];
            parentC[r][c] = dest[1];
        }
        return new int[]{parentR[r][c], parentC[r][c]};
        
    }
    
    // 이동한 위치가 체스판 범위 내 존재 여부 판단 메서드
    static boolean isRange(int r, int c){
        if(r >= 0 && c >= 0 && r < R && c < C){
            return true;
        }
        return false;
    }
    
}