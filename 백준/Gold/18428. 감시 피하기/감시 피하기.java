/*
1. N 입력
2. 복도의 정보 입력
3. dfs로 복도를 탐색하면서 장애물 설치
4. 장애물이 3개가 설치되면 bfs를 이용해 감시범위인지 확인
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static char[][] bokdo; // 복도
    // 복도에서 이동할 수 있는 범위
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc=  {0, 0, -1, 1};
    static int N;
    
    static class Node{ // 위치를 저장하기 위해 사용되는 클래스
        int row;
        int col;
        
        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N 입력
        N = Integer.parseInt(br.readLine());
        bokdo = new char[N][N];
        
        // 2. 복도의 정보 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                bokdo[i][j] = st.nextToken().charAt(0);
            }
        }
        
        // 3. dfs로 복도를 탐색하면서 장애물 설치
        dfs(0);
        
        System.out.println("NO");
    }
    
    static void dfs(int obstacle){
        // 4. 장애물이 3개가 설치되면 bfs를 이용해 감시범위인지 확인
        if(obstacle == 3){ 
            if(bfs()){ // 장애물의 설치로 더 이상 감시할 수 없다면 YES 출력 후 프로그램 종료
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(bokdo[i][j] == 'X'){
                    bokdo[i][j] = 'O';
                    dfs(obstacle + 1);
                    bokdo[i][j] = 'X'; 
                }
            }
        }
    }
    
    static boolean bfs(){
        Queue<Node> q = new LinkedList<>();
        // 선생님의 위치 파악 후 queue에 저장
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(bokdo[i][j] == 'T'){
                    q.add(new Node(i,j));
                }
            }
        }
        
        while(!q.isEmpty()){
            Node node = q.poll();
            // 현재 선생님의 위치를 기준으로 복도 탐색
            for(int i = 0; i < 4; i++){
                // 현재 위치
                int nr = node.row;
                int nc = node.col;
                
                // 상하좌우 1칸만 탐색하는 것이 아니라 분기 지점이 나올 때까지 탐색
                while(true){
                    // 현재 위치에서 이동
                    nr += dr[i];
                    nc += dc[i];
                    
                    // 이동한 후의 위치가 복도의 범위를 넘어가면 break
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N){
                        break;
                    }
                    
                    // 탐색 중 장애물을 만나면 breka
                    if(bokdo[nr][nc] == 'O'){
                        break;
                    }
                    
                    // 탐색하는 위치가 학생의 위치인 경우 false 리턴
                    if(bokdo[nr][nc] == 'S'){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}