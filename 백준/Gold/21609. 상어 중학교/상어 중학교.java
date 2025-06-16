/*
1. N, M 입력
2. 블록 정보 입력
3. 오토플레이 실행
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int[][] map;
    static int N, M;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int score;
    static List<BlockGroup> groups;
    
    static class BlockGroup implements Comparable<BlockGroup>{
        int r, c; // 행, 열
        int blocks; // 그룹내 블록의 개수
        int rbBlocks; // 그룹내 무지개 블록의 개수
        List<Integer> positions; // 그룹 블록 그룹에 포함된 모든 좌표들의 목록
        BlockGroup(int r, int c, int blocks, int rbBlocks, List<Integer> positions){
            this.r = r;
            this.c = c;
            this.blocks = blocks;
            this.rbBlocks = rbBlocks;
            this.positions = positions;
        }
        
        @Override
        public int compareTo(BlockGroup bg){
            if(this.blocks == bg.blocks){
                if(this.rbBlocks == bg.rbBlocks){
                    if(this.r == bg.r){
                        return bg.c - this.c; // 열이 가장 큰 것 
                    }else{
                        return bg.r - this.r; // 기준 블록의 행이 가장 큰 것
                    }
                }
                return bg.rbBlocks - this.rbBlocks; // 무지개 블록의 수가 가장 많은 그룹
            }
            return bg.blocks - this.blocks; 
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N, M 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 2. 블록 정보 입력
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 3. 오토플레이 실행
        while(true){
            // 가장 큰 블록 그룹을 탐색 및 그룹 점수 계산
            if(!findGroup()){
                break;
            }
            
            // 중력 작용
            gravity(); 
            // 격자가 90도 반시계 방향으로 회전
            rotate();
            // 중력 작용
            gravity();
        }
        
        // 4. 결과 출력
        System.out.println(score);
    }
    
    // 그룹을 찾아 그룹의 점수를 계산하는 메서드
    static boolean findGroup(){
        groups = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] > 0){ // 현재 위치가 첫 방문이면서 기준블록(일반븡록)안 경우
                    bfs(i, j, visited); // bfs를 통해 그룹화 작업
                }
            }
        }

        if(groups.isEmpty()){ // 리스트내에 그룹이 없는 경우
            return false;
        }
        Collections.sort(groups); // 가장 큰 그룹 부터 정렬
        BlockGroup best = groups.get(0); // 가장 큰 그룹

        for (int pos : best.positions) {
            // 그룹의 시작 좌표
            int r = pos / N; 
            int c = pos % N;
            map[r][c] = -2; // 가장 큰 그룹이 있던 칸은 빈칸으로 변경
        }

        score += (int) Math.pow(best.blocks, 2); // 그룹 점수 계산
        return true;
    }
    
    static void bfs(int r, int c, boolean[][] visited){
        int color = map[r][c];
        int rb = 0; // 그룹내 무지개 블록
        boolean[][] tmpV = new boolean[N][N];
        
        // 기준 블록의 좌표 
        int standardR = r;
        int standardC = c;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> position = new ArrayList<>(); // 그룹에 속하는 좌표
        q.offer(r * N + c);
        
        tmpV[r][c] = true;
        position.add(r * N + c);
        
        while(!q.isEmpty()){
            int cur = q.poll(); // 현재 위치의 좌표 배열
            int curR = cur / N;
            int curC = cur % N;
            for(int i = 0; i < 4; i++){
                int nr = curR + dr[i];
                int nc = curC + dc[i];
                
                // 이동한 위치가 격자판에서 벗어나거나 이미 탐색한 위치인 경우 넘어감
                if(nr < 0 || nc < 0 || nr >= N || nc >= N || tmpV[nr][nc]){
                    continue;
                }
                
                // 이동한 위치가 무지개 블록이 아니고, 이전 탐색 위치의 색과 다른 경우 넘어감
                if(map[nr][nc] != 0 && map[nr][nc] != color){
                    continue;
                }
                
                // 이동한 위치가 기준블록과 같은 색의 블록이거나 무지개 블록인 경우 그룹화
                tmpV[nr][nc] = true;
                q.offer(nr * N + nc);
                position.add(nr * N + nc);
                
                if(map[nr][nc] == 0){ // 이동한 위치가 무지개 블록인 경우
                    rb++;
                }else {
                    if(nr < standardR || (nr == standardR && nc < standardC)){ // 기준 블록 위치 갱신
                        standardR = nr;
                        standardC = nc;
                    }
                }
            }
        }
        if(position.size() >= 2){ // 그룹 내 블록 개수가 2이상인 경우 이에 해당하는 그룹객체를 생성하여 리스트에 저장
            groups.add(new BlockGroup(standardR, standardC, position.size(), rb, position));
        }
        for(int p : position){
            int pr = p / N;
            int pc = p % N;
            if(map[pr][pc] != 0){ // 그룹에 속한 블럭이 기본 블럭인 경우에만 해당 위치에 대해 방문처리
                visited[pr][pc] = true;
                // 무지개 블럭은 다른 그룹을 탐색할 때 다시 사용될 수 있기 때문에 방문처리를 따로 하지 않음
            }
        }
    }
    
    
    // 중력 적용 메서드
    static void gravity(){
        for(int j = 0; j < N; j++){
            for(int i = N - 2; i >= 0; i--){
                if(map[i][j] < 0){ // 현재 위치에 검은 블록이나 빈칸인 경우 넘어감
                    continue;
                }
                int nr = i;
                while(nr + 1 < N && map[nr + 1][j] == -2){ // 격자판을 벗어나지 않고, 아래칸이 빈칸인 경우
                    map[nr + 1][j] = map[nr][j]; // 중력 작용
                    map[nr][j] = -2;
                    nr++; // 아래칸 탐색
                }
            }
        }
    }
    
    // 반시계 방향으로 회전하는 메서드
    static void rotate(){
        int[][] tmp = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                tmp[N - 1 - j][i] = map[i][j];
            }
        }
        map = tmp;
    }
}