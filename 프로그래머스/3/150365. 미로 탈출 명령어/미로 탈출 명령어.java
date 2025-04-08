/*
1. 출발 지점과 탈출 지점의 거리를 통해 해당 문제 해결 가능 여부 파악
2. 1번을 통해 문제 해결이 가능한 경우 dfs를 이용해 탈출지점까지의 거리 계산
*/
class Solution {
    static int startX, startY; // 출발 위치
    static int endX, endY; // 탈출 지점
    static int movedDist; // 이동해야 할 거리
    static String tmpAnswer = "";
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static char[] dir = {'d', 'l', 'r', 'u'}; // 방향배열(사전 순)
    static String answer = "impossible";
    static int N;
    static int M;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n;
        M = m;
        startX = x;
        startY = y;
        endX = r;
        endY = c;
        movedDist = k;
        
        // 1. 출발 지점과 탈출 지점의 거리를 통해 해당 문제 해결 가능 여부 파악
        int distance = getDistance(startX, startY);
        if(movedDist < distance ||((movedDist - getDistance(startX, startY)) % 2 != 0)){ // k가 두 지점 간의 거리보다 작은 경우, 이동해야할 거리만큼 이동했을 때 탈출 지점에 도달 할 수 없는 경우 계산을 할 수 없음.
            return answer;
        }
        
        // 2. 1번을 통해 문제 해결이 가능한 경우 dfs를 이용해 탈출지점까지의 거리 계산
        dfs(0, startX, startY, "");

        return answer;
    }
    
    static void dfs(int moved, int x, int y, String tmpAns){
        if(!answer.equals("impossible")){ // 이미 미로를 탈출한 경우 탐색 종료
            return;
        }
        if(movedDist - moved < getDistance(x, y)){ // 남은 거리가 현재 위치와 도착지 간의 거리보다 작은 경우 탐색 종료
            return;
        }
        if(((movedDist - moved) - getDistance(x, y)) % 2 != 0){ // 이동해야 할 거리만큼 이동했을 때 탈출지점에 도달하지 못하는 경우
            return; 
        }
        
        if(moved == movedDist){ // 목적지까지 K번 이동해서 간 경우 문자열 저장
            answer = tmpAns;
            return;
        }
        
        // 방향 탐색
        for(int i = 0; i < 4; i++){
            int nx = x + dr[i];
            int ny = y + dc[i];
            char directions = dir[i];
            if(nx < 1 || ny < 1 || nx > N || ny > M){ // 이동한 위치가 범위에서 벗어나는 경우 continue
                continue;
            }
            
            
            dfs(moved + 1, nx, ny, tmpAns + directions);
        }
    }
    
    // 두 지점 간의 거리를 구하는 메서드
    static int getDistance(int startX, int startY){
        return Math.abs(endX - startX) + Math.abs(endY - startY);
    }
}