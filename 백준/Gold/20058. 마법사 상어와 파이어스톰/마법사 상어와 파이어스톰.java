/*
1. N, Q 입력
2. 각 칸의 얼음의 양 입력
3. 마법사 상어가 시전한 단계
4. 부분 격자 90도 회전
5. 얼음이 있는 칸 3개 또는 그 이상과 인접해있지 않은 칸은 얼음의 양 - 1
6. 남아있는 얼음의 합 & 가장 큰 덩어리가 차지하는 칸의 개수 계산
7. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N, Q;
    static int[][] A;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int totalIce; // 남아있는 얼음의 합
    static int dungeories; // 가장 큰 덩어리가 차지하는 칸의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 1. N, Q 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        N = (int) Math.pow(2, N);
        A = new int[N][N];
        
        // 2. 각 칸의 얼음의 양 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 3. 마법사 상어가 시전한 단계
        st = new StringTokenizer(br.readLine());
        int[] L = new int[Q];
        for(int i = 0; i < Q; i++){
            L[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < Q; i++){
            // 4. 부분 격자 90도 회전
            A = rotation(L[i]); 
            // 5. 얼음이 있는 칸 3개 또는 그 이상과 인접해있지 않은 칸은 얼음의 양 - 1
            A = melt();
        }
        
        // 6. 남아있는 얼음의 합 & 가장 큰 덩어리가 차지하는 칸의 개수 계산
        totalIce = 0;
        dungeories = 0;
        findTotalKansAndBigIce();
        
        // 7. 결과 출력
        sb.append(totalIce).append("\n").append(dungeories);
        System.out.println(sb);
       
    } 
    static int[][] rotation(int L){
        int[][] tmp = new int[N][N];
        int kans = (int) Math.pow(2, L); // 90도 회전할 칸의 개수
        for(int i = 0; i < N; i+=kans){
            for(int j = 0; j < N; j+=kans){
                rotate(i, j, kans, tmp);
            }
        }
        return tmp;
    }
    
    // 90도 회전
    static void rotate(int r, int c, int L, int[][] tmp){
        for(int i = 0; i < L; i++){
            for(int j = 0; j < L; j++){
                tmp[r + j][c + (L - 1 - i)] = A[r + i][c + j];
            }
        }
    }
    
    static int[][] melt(){
        int[][] tmp = new int[N][N];
        for(int i = 0; i < N; i++){
            tmp[i] = Arrays.copyOf(A[i], N);
        }
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < N; j++){
                int count = 0;
                if(A[i][j] == 0){
                    continue;
                }
                for(int k = 0; k < 4; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(nr >= 0 && nc >= 0 && nr < N && nc < N){
                        if(A[nr][nc] > 0){ // 얼음이 존재하는 칸
                            count++;
                        }
                    }
                }
                if(count < 3){ // 주변에 얼음이 존재하는 칸이 3칸 보다 적은 경우 해당 칸은 얼음-1 
                    tmp[i][j]--;
                }
            }
            
        }
        return tmp;
        
    }
    
    static void findTotalKansAndBigIce(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                totalIce += A[i][j]; // 얼음의 합 계산
                if(A[i][j] > 0 && !visited[i][j]){ // 얼음 덩어리 칸의 수 계산
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    int count = 1;
                    
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];
                        
                        for(int k = 0; k < 4; k++){
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            
                            if(nr >= 0 && nc >= 0 && nr < N && nc < N){
                                if(A[nr][nc] > 0 && !visited[nr][nc]){
                                    visited[nr][nc] = true;
                                    q.add(new int[]{nr, nc});
                                    count++;
                                }
                            }
                        }
                        
                    }
                    dungeories = Math.max(dungeories, count);
                }
                
            }
        }
    }
}