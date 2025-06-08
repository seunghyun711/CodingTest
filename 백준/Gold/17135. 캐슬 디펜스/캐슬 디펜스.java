/*
1. N, M, D 입력
2. 격자판의 상태 입력
3. 궁수의 배치에 따른 적 제거 및 제거할 수 있는 적의 최대 수 계산
4.결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N, M, D;
    static int[][] map;
    static int[][] tmpMap;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. N, M, D 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // 2. 격자판의 상태 입력
        map = new int[N + 1][M + 1];
        tmpMap = new int[N + 1][M + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                tmpMap[i][j] = map[i][j]; // 궁수의 위치를 변경할 때 격자판을 초기화하기 위한 2차원 배열
            }
        }
        List<Integer> archer = new ArrayList<>(); // 궁수가 위치한 열을 담을 리스트

        // 3. 궁수의 배치에 따른 적 제거 및 제거할 수 있는 적의 최대 수 계산
        findArchers(1, M, 0, archer);

        // 4.결과 출력
        System.out.println(result);
    }

    // map을 초기화하는 메서드
    static void init(){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                map[i][j] = tmpMap[i][j];
            }
        }
    }

    // 거리 구하는 메서드
    static int getDistance(int r1, int r2, int c1, int c2){
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    // 궁수의 위치를 지정하여 공격을 실행하는 메서드
    static void findArchers(int start, int turns, int count, List<Integer> archer){
        if(count == 3){ // 3명의 궁수가 배치된 경우 공격 시작
            init(); // 궁수의 위치별로 최초의 격자판 상태에서 공격을 해야하기 때문에 map 초기화
            attack(archer);
            return;
        }
        for(int i = start; i <= turns; i++){
            archer.add(i);
            findArchers(i + 1, turns, count + 1, archer);
            archer.remove(archer.size() - 1);
        }
    }

    // 공격 메서드
    static void attack(List<Integer> archer){
        int tmp = 0;

        for(int k = 1; k <= N; k++){
            boolean[][] visited = new boolean[N + 1][M + 1];

            for(int i = 0; i < archer.size(); i++){
                int archerCol = archer.get(i); // 궁수가 있는 열의 좌표
                int minDistance = Integer.MAX_VALUE; // 적과 궁수 간 최단 거리
                int minRow = Integer.MAX_VALUE; // 최단 거리의 행
                int minCol = Integer.MAX_VALUE; // 최단 거리의 열

                // 맵에서 궁수와 적 간의 최단 거리 도출
                for(int r = 1; r <= N; r++){
                    for(int c = 1; c <= M; c++){
                        if(map[r][c] == 1){ // 해당 위치에 적이 있는 경우
                            int distance = getDistance(r, N + 1, c, archerCol); // 현재 적과 궁수 간의 거리
                            if(minDistance >= distance){
                                if(minDistance > distance){ // 새로 계산한 궁수-적 거리가 기존의 궁수-적의 최소 거리보다 짧은 경우
                                    minDistance = distance; // 최단 거리 최신화
                                    minRow = r;
                                    minCol = c;
                                }else{ // 새로 게산한 궁수-적의 거리가 기존의 궁수-적의 최단 거리와 같은 경우
                                    if(minCol > c){ // 가장 왼쪽 적부터 처리
                                        minRow = r;
                                        minCol = c;
                                    }
                                }
                            }
                        }
                    }
                }
                // 거리 계산 후 최단 거리가 D이하면 해당 위치 방문 처리(궁수의 사정 거리 내에 있는 적의 위치)
                if(minDistance <= D){
                    visited[minRow][minCol] = true;
                }
            }
            // visited = trrue인 좌표의 적 제거
            for(int r = 1; r <= N; r++){
                for(int c = 1; c <= M; c++){
                    if(visited[r][c]){
                        map[r][c] = 0;
                        tmp++;
                    }
                }
            }

            // 한 턴이 종료 되어 맵 상태 최신화
            for(int r = N; r >= 1; r--){
                for(int c = 1; c <= M; c++){
                    map[r][c] = map[r - 1][c];
                }
            }
        }
        result = Math.max(result, tmp);
    }
}