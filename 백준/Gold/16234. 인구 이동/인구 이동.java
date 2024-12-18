/*
1. N, L, R 입력
2. 각 나라의 인구수 입력
3. bfs를 통해 각 나라의 인구수 차이를 가지고 연합 여부 판단
4. 연합 국가의 인구수를 연합 국가 인구수의 평균으로 최신화
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N, L, R;
    static int TotalYeonhapPop; // 연합국들의 총 인구수
    static int[][] countryMap; // 나라의 인구수를 나타내는 배열
    static boolean[][] visited; 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result; // 결과
    static List<Position> list; // 인구이동한 나라의 위치를 담을 리스트
    
    static class Position{
        int x;
        int y;
        
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N, L, R 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
  
        // 2. 각 나라의 인구수 입력
        countryMap = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                countryMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 3. bfs를 통해 각 나라의 인구수 차이를 가지고 연합 여부 판단 및 결과 출력
        System.out.println(move());
    }
    
    // 인구 이동 메서드
    static int move(){
        result = 0;
        while(true){
            boolean isMove = false; // 인구이동 가능 여부
            visited = new boolean[N][N]; // 1일차의 인구이동을 모두 확인한 후 다음날의 인구이동을 확인하기 위해 새로 초기화
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        int sum = bfs(i, j); // bfs를 통해 인구이동이 가능한 나라들의 인구수 합 계산
                        if(list.size() > 1){ // 인구이동이 있는 경우
                            calcPop(sum); // 인구이동 결과 계산
                            isMove = true;
                        }
                    }
                }
            }
            if(!isMove){
                return result;
            }
            result++;
        }
    }
    
    static int bfs(int x, int y){
        Queue<Position> q = new LinkedList<>();
        list = new ArrayList<>();
        
        q.add(new Position(x, y));
        list.add(new Position(x,y));
        visited[x][y] = true;
        
        int sum = countryMap[x][y];
        
        while(!q.isEmpty()){
            Position pos = q.poll(); // 현재위치
            
            for(int i = 0; i < 4; i++){
                // 현재위치 기준으로 다른 나라 탐색
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]){
                    // 인구이동이 가능한 경우
                    int calc = Math.abs(countryMap[pos.x][pos.y] - countryMap[nx][ny]);
                    if(L <= calc && R >= calc){
                        q.add(new Position(nx, ny));
                        list.add(new Position(nx, ny));
                        sum += countryMap[nx][ny]; // 인구수 합 계산
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return sum;
    }
    
    // 평균 인구수 계산하여 인구이동한 나라에 평균인구수를 저장하는 메서드
    static void calcPop(int sum){
        int avgPop = sum / list.size(); // 평균 인구수
        for(Position p : list){
            countryMap[p.x][p.y] = avgPop; // 인구이동한 나라들의 인구수를 평균 인구수로 저장
        }
    }
}