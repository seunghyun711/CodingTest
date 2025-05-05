/*
1. N, M 입력
2. 치즈 입력
3. dfs()를 이용해 외부 공기 판별
4. 치즈가 모두 녹는데 걸리는 시간 계산
5. 결과 출력
*/
import java.io.*;
import java.util.*;
class Position{
    int r;
    int c;
    
    Position(int r, int c){
        this.r = r;
        this.c = c;
    }    
}
public class Main{
    static int N;
    static int M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] map;
    static int cheeseCount = 0; // 치즈 개수
    static List<Position> cheese = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N, M 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 2. 치즈 입력
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){ // 입력받은 칸에 치즈가 있는 경우
                    cheese.add(new Position(i, j));
                    cheeseCount++;
                }
            }
        }
        
        int result = 0; // 치즈가 모두 녹는데 걸리는 시간(결과)
        while(cheeseCount > 0){
            result++;
            visited = new boolean[N][M];
            // 3. dfs()를 이용해 외부 공기 판별
            dfs(0, 0);
            // 4. 치즈가 모두 녹는데 걸리는 시간 계산
            calcMeltingTime();
        }
        
        // 5. 결과 출력
        System.out.println(result);
    }
    
    static void dfs(int r, int c){
        visited[r][c] = true;
        map[r][c] = 2; // 외부 공기인 경우 해당 위치를 2로 변경
        
        for(int i = 0; i < 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr >= N || nc >= M || nr < 0 || nc < 0){ // 탐색 범위를 벗어나는 경우
                continue;
            }
            if(visited[nr][nc] || map[nr][nc] == 1){ // 이미 확인했거나 해당 위치에 치즈가 있는 경우
                continue;
            }
            dfs(nr, nc); // 외부 공기인 경우 해당 위치에서 dfs
        }
    }
    
    // 치즈가 녹는데 걸리는 시간을 구하는 메서드
    static void calcMeltingTime(){
        for(int i = 0; i < cheese.size(); i++){
            int r = cheese.get(i).r;
            int c = cheese.get(i).c;
            
            int count = 0; // 치즈가 외부 공기와 접촉한 변의 개수
            
            for(int j = 0; j < 4; j++){
                int nr = r + dr[j];
                int nc = c + dc[j];
                
                if(map[nr][nc] == 2){ // 치즈가 외부공기와 접촉한 경우
                    count++;
                }
            }
            
            if(count >= 2){ // 외부와 접촉한 변이 두 개 이상인 경우 치즈를 녹임
                map[r][c] = 0; 
                cheeseCount--;
                cheese.remove(i);
                i--;
            }
        }
    }
}