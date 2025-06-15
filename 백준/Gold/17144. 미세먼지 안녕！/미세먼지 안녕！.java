/*
1. R, C, T 입력
2. 미세먼지 및 공기청정기 정보 입력
3. 미세먼지 확산(모든 영역에서 동시에 확산)
4. 공기청정기 작동
5. 남은 미세먼지의 양 계산
6. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int R, C, T;
    static int[][] map;
    static List<Integer> ac = new ArrayList<>(); // 공기청정기 위치
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. R, C, T 입력
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        // 2. 미세먼지 및 공기청정기 정보 입력
        map = new int[R][C];
        int num = 0; // 공기청정기 설치 수(최종적으로 위, 아래 2개가 되어야 함)
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                int info = Integer.parseInt(st.nextToken());
                if(num < 2){ // 공기청정기 위치 파악
                    if(info == -1){
                        ac.add(i);
                        num++;
                    }
                }
                map[i][j] = info;
            }
        }
        
        for(int i = 0; i < T; i++){
            // 3. 미세먼지 확산(모든 영역에서 동시에 확산)
            map = moveDust();
            // 4. 공기청정기 작동
            executeAirCleaner();
        }
        
        // 5. 남은 미세먼지의 양 계산
        countDust();
        
        // 6. 결과 출력
        System.out.println(result + 2); // counstDust()에서 미세먼지 칸 -1도 더했기 때문에 해당 부분에 대한 값 복구
    }
    
    // 미세먼지 확산 메서드
    static int[][] moveDust(){
        int[][] tmp = new int[R][C];
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j]== -1){ // 현재 위치에 공기청정기가 있는 경우 넘어감
                    tmp[i][j] = -1;
                    continue;
                }
                tmp[i][j] += map[i][j];
                for(int k = 0; k < 4; k++){ // 미세먼지의 주변 4방향에 확산
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    
                    // map의 범위를 벗어나거나 이동한 위치에 공기청정기가 있는 경우 먼지가 확산되지 않음
                    if(nr < 0 || nc < 0 || nr >=R || nc >= C || tmp[nr][nc] == -1){
                        continue;
                    }
                    // 미세먼지 확산
                    tmp[nr][nc] += (map[i][j] / 5);
                    tmp[i][j] -= (map[i][j] / 5);
                }
            }
        }
        return tmp;
    }
    
    // 공기청정기 작동 메서드
    static void executeAirCleaner(){
        int ac1 = ac.get(0); // i번째 행에 위치한 공기청정기
        int ac2 = ac.get(1); // i + 1번째 행에 위치한 공기청정기
        
        // 위쪽 공기청정기 작동(반시계 방향)
        for(int i = ac1 - 1; i > 0; i--){ // ↓
            map[i][0] = map[i - 1][0];
        }
        
        for(int i = 0; i < C - 1; i++){ // ←
            map[0][i] = map[0][i + 1];
        }
        
        for(int i = 0; i < ac1; i++){ // ↑
            map[i][C - 1] = map[i + 1][C - 1];
        }
        
        for(int i = C - 1; i > 1; i--){ // →
            map[ac1][i] = map[ac1][i - 1];
        }
        map[ac1][1] = 0; // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        
        // 아래쪽 공기청정기 작동(시계 방향)
        for(int i = ac2 + 1; i < R - 1; i++){ // ↑
            map[i][0] = map[i + 1][0];
        }
        
        for(int i = 0; i < C - 1; i++){ // ←
            map[R - 1][i] = map[R - 1][i + 1];
        }
        
        for(int i = R - 1; i > ac2; i--){ // ↓
            map[i][C - 1] = map[i - 1][C - 1];
        }
        
        for(int i = C - 1; i > 1; i--){ // →
            map[ac2][i] = map[ac2][i - 1];
        }
        map[ac2][1] = 0; // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
    }
    
    // 미세먼지 양을 구하는 메서드
    static void countDust(){
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                result += map[i][j];
            }
        }
    }
}