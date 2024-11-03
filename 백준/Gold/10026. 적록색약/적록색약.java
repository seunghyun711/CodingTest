/*
1. N 입력
2. 색 입력
3. bfs를 이용해 구역의 개수 계산
4. bfs를 통해 일반인이 보는 구역의 개수를 구한다.
5. bfs를 통해 적록 색약이 보는 구역의 개수 계산
6. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static char[][] colorMap;
    // colorMap에서 이동하는 범위
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc=  {0, 0, -1, 1};
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 1. N 입력
        N = Integer.parseInt(br.readLine());
        
        int count = 0; // 구역의 개수
        
        colorMap = new char[N][N]; // 색이 칠해진 그림 배열
        visited = new boolean[N][N];
        
        // 2. 색 입력
        for(int i = 0; i < N; i++){
            String color = br.readLine();
            for(int j = 0; j < N; j++){
                colorMap[i][j] = color.charAt(j);
            }
        }
        
        // 3. bfs를 이용해 구역의 개수 계산
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    count++;
                    bfs(i, j);
                }
                // colorMap에서 초록색인 구간을 빨간색으로 변경(적록 색맹의 구역 탐색 결과 도출을 위해 변경)
                if(colorMap[i][j] == 'G'){
                    colorMap[i][j] = 'R';
                }
            }
        }
        sb.append(count + " ");
        
        // 5. bfs를 통해 적록 색약이 보는 구역의 개수 계산
        count = 0; // count 초기화
        visited = new boolean[N][N]; // 방문 처리 배열 초기화
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    count++;
                    bfs(i, j);
                }
                
            }
        }
        sb.append(count);
        
        // 6. 결과 출력
        System.out.println(sb);
        
    }
    
    // 4. bfs를 통해 일반인이 보는 구역의 개수를 구한다.
    static void bfs(int r, int c){
        q.offer(new int[]{r, c});
        visited[r][c] = true; // 방문처리
        
        while(!q.isEmpty()){
            int[] position = q.poll();
            // 현재 위치
            int cRow = position[0];
            int cColumn = position[1];
            
            for(int i = 0; i < 4; i++){ // colorMap을 이동하면서 구역 탐색
                int nr = cRow + dr[i];
                int nc = cColumn + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < N && nc < N){
                    // 방문하지 않은 위치면서 현재 위치와 다음에 탐색할 위치의 색이 같으면 구역 탐색 계속 진행
                    if(!visited[nr][nc] && colorMap[nr][nc] == colorMap[cRow][cColumn]){
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            
        }
    }
}