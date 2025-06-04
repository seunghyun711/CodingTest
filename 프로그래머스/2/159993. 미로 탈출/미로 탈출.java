/*
1. 시작 지점, 출구, 레버의 위치 저장
2. 시작지점에서 레버, 레버에서 출구까지의 거리를 계산
3. 결과 출력
*/
import java.io.*;
import java.util.*;
class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public int solution(String[] maps) {
        int answer = -1;
        
        int x = maps.length;
        int y = maps[0].length();
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        
        // 1. 시작 지점, 출구, 레버의 위치 저장
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                char c = maps[i].charAt(j);
                
                if(c == 'S'){
                    start[0] = i;
                    start[1] = j;
                }else if(c == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }else if(c == 'E'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        // 2. 시작지점에서 레버, 레버에서 출구까지의 거리를 계산
        int startToLever = bfs(maps, start, lever);
        int leverToEnd = bfs(maps, lever, end);
        
        // 3. 결과 출력
        if(startToLever != -1 && leverToEnd != -1){
            answer = startToLever + leverToEnd;
        }
        return answer;
    }
    
    static int bfs(String[] maps, int[] start, int[] end){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        int x = start[0];
        int y = start[1];
        
        q.add(new int[]{x, y, 0}); // 0은 거리
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            x = cur[0];
            y = cur[1];
            int time = cur[2]; // 이동 시간
            
            if(x == end[0] && y == end[1]){
                return time;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + dr[i];
                int ny = y + dc[i];
                
                // 미로의 범위를 벗어나는 경우 continue;
                if(nx >= maps.length || ny >= maps[0].length() || nx < 0 || ny <0 || visited[nx][ny] || maps[nx].charAt(ny) == 'X'){
                    continue;
                }
                // 이동거리 증가
                q.add(new int[]{nx, ny, time + 1});
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}