/*
1. 동굴의 크기(N) 입력
2. N !=0 인 경우 동굴의 각 칸에 있는 도둑루피의 크기 입력
3. bfs를 통해 그래프를 탐색하면서 dp 사용
4. 링크가 잃게되는 최소 금액 계산 
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int[][] dp;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] donggul; // 동굴 배열
    static boolean[][] visited;
    static PriorityQueue<Position> q;
    
    static class Position implements Comparable<Position>{ // 현재 위치와 관련된 객체
        int row;
        int col;
        int cost;
        
        Position(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Position p){
            return this.cost - p.cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int problem = 0; // 문제 번호
        
        // 1. 동굴의 크기(N) 입력
        while(true){
            problem++;
            
            // 2. N !=0 인 경우 동굴의 각 칸에 있는 도둑루피의 크기 입력
            N = Integer.parseInt(br.readLine());
            if(N == 0){ // N==0 이면 종료
                break;
            }
            
            visited = new boolean[N][N];
            dp = new int[N][N];
            donggul = new int[N][N];
            
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    donggul[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    dp[i][j] = Integer.MAX_VALUE; // dp 배열 초기화
                }
            }
            
            dp[0][0] = donggul[0][0]; // dp[0][0] 값 초기화
            
            // 3. bfs를 통해 그래프를 탐색하면서 dp 사용(다익스트라 알고리즘 사용)
            bfs();
            
            // 5. 결과 출력
            System.out.println("Problem " + problem + ": " + dp[N - 1][N - 1]);
        }
    }
    
    // 4. 링크가 잃게되는 최소 금액 계산 
    static void bfs(){
        q = new PriorityQueue<>();
        q.add(new Position(0, 0, dp[0][0]));
        
        while(!q.isEmpty()){
            Position p = q.poll();
            // 현재 위치
            int row = p.row;
            int col = p.col;
            int cost = p.cost;
            
            // 이미 최소 금액인 경우 넘어감 
            if(cost > dp[row][col]){
                continue;
            }
            
            for(int i = 0; i < 4; i++){
                // 현재 위치에서 인접한 위치 탐색
                int newR = row + dx[i];
                int newC = col + dy[i];   
                
                // 현재위치가 동굴의 범위를 넘어가지 않는 경우
                if(newR >= 0 && newC >= 0 && newR < N && newC < N){
                    int newCost = dp[row][col] + donggul[newR][newC];
                    // 최소금액 계산
                    if(newCost < dp[newR][newC]){
                        dp[newR][newC] = newCost;
                        q.add(new Position(newR, newC, newCost));
                    }
                }
            }
        }
    }
}