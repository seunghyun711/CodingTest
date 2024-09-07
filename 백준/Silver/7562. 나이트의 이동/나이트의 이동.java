/*
1. 테스트 케이스 개수 입력
2. 체스판의 한 변의 길이 입력
3. 현재 위치 입력
4. 목표 위치 입력
5. 현재 위치에서 목표 위치까지 이동하는데 걸리는 최소 횟수 계산
6. 5번의 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int l; // 체스판의 한 변의 길이
    static int[][] board; // 체스판을 나타낸 2차원 배열
    // x, y 축으로 이동할 수 있는 칸의 개수
    static int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};
    static boolean[][] visited; // 방문 체크를 위한 배열
    static int startX, startY; // 시작 위치의 x,y 좌표
    static int endX, endY; // 목표 위치의 x,y 좌표
    static Queue<int[]> q = new LinkedList<>(); // bfs를 사용하기 위한 큐
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 1. 테스트 케이스 개수 입력
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            // 2. 체스판의 한 변의 길이 입력
            l = Integer.parseInt(br.readLine());
            
            board = new int[l][l]; // 체스판 선언
            visited = new boolean[l][l];
            
            // 3. 현재 위치 입력
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            
            // 4. 목표 위치 입력
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            
            // 5. 현재 위치에서 목표 위치까지 이동하는데 걸리는 최소 횟수 계산
            bfs();
            
            // 6. 5번의 결과 출력
            sb.append(board[endX][endY]).append("\n");
            
        }
        System.out.println(sb);
    }
    
    static void bfs(){
        int[] start = {startX, startY}; // 시작 지접을 담은 배열
        q.add(start);
        visited[startX][startY] = true;
        
        while(!q.isEmpty()){
            int[] currentPosition = q.poll(); // 현재 위치
            int currentX = currentPosition[0]; // 현재 위치의 x좌표
            int currentY = currentPosition[1]; // 현재 위치의 y좌표
            
            for(int i = 0; i < 8; i++){
                int movedX = currentX + dx[i]; // 이동한 x좌표
                int movedY = currentY + dy[i]; // 이동한 y좌표
                
                // 이동한 위치가 체스판에서 벗어나지 않은 경우 이동 횟수 계산
                if(movedX >= 0 && movedY >= 0 && movedX < l && movedY < l){
                    if(!visited[movedX][movedY]){
                        int[] move = {movedX, movedY};
                        q.add(move);
                        board[movedX][movedY] = board[currentX][currentY] + 1; // 이동횟수 증가
                        visited[movedX][movedY] = true; // 방문 체크
                    }
                }
                
            }
        }
    }
}