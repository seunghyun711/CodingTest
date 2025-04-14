/*
1. N 입력
2. K, 사과의 위치 입력
3. 뱁의 방향 전환 횟수, 정보 입력
4. 각 조건을 통해 게임이 몇초에 끝나는지 계산
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int K;
    static int L;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0 ,-1 ,0};
    static List<int[]> snake = new ArrayList<>();
    static Map<Integer, String> dirInfo = new HashMap<>(); // 방향 전환 정보
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        // 2. K, 사과의 위치 입력
        K = Integer.parseInt(br.readLine());
        for(int i = 0; i< K; i++){
            // 사과의 위치 입력
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1; // 사과의 위치
        }
        
        // 3. 뱁의 방향 전환 횟수, 정보 입력
        L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++){
            // 방향 전환 정보 입력
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            dirInfo.put(X, C);
        }
        
        // 4. 각 조건을 통해 게임이 몇초에 끝나는지 계산
        int result = start();
        
        // 5. 결과 출력
        System.out.println(result);
    }
    
    static int start(){
        int movedR = 0;
        int movedC = 0;
        int time = 0;
        int direction = 0;
        
        snake.add(new int[]{0, 0}); // 시작점
        
        while(true){
            time++;
            
            // 이동
            int nr = movedR + dr[direction];
            int nc = movedC + dc[direction];
            
            // 범위를 벗어나거나 자기자신의 몸에 부딪히는 경우 게임 종료
            if(isGameOver(nr, nc)){
                break;
            }
            
            // 사과 존재여부에 따른 처리
            if(map[nr][nc] == 1){ // 이동한 위치가 사과가 있는 곳인 경우
                map[nr][nc] = 0;
                snake.add(new int[]{nr, nc}); // 꼬리가 그대로 있어야 한다.
            }else{ // 이동한 위치가 사과가 없는 곳인 경우
                snake.add(new int[]{nr, nc});
                snake.remove(0); // 몸길이를 줄임
            }
            
            // 방향 전환
            if(dirInfo.containsKey(time)){
                String turnDirection = dirInfo.get(time);
                if(turnDirection.equals("L")){ // 왼쪽 이동
                    direction = (direction + 3) % 4; // 0 -> 3, 1 -> 0, 2 -> 1, 3 -> 2
                } else if(turnDirection.equals("D")){ // 오른쪽 이동
                    direction = (direction + 1) % 4; // 0 -> 1, 1 -> 2, 2 -> 3, 3 -> 0
                }
            }
            
            // 현재 위치
            movedR = nr;
            movedC = nc;
        }
        return time;
    }
    
    // 게임 종료 여부 판단 메서드
    static boolean isGameOver(int r, int c){
        if(r < 0 || c < 0 || r  >= N || c >= N){ // 이동한 위치가 맵의 범위를 벗어나는 경우 게임 종료
            return true;
        }
        
        // 이동한 위치가 뱀과 겹치는 경우 게임 종료
        for(int [] s : snake){
            if(r == s[0] && c == s[1]){
                return true;
            }
        }
        
        return false;
    }
}