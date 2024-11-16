/*
1. N, M 입력
2. 도시 정보 입력
3. 치킨 거리 계산
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int M;
    static boolean[] visited; 
    static int[][] city; // 도시 정보를 담을 배열
    static int result; // 결과
  
    static class Position{ // 위치를 저장하기 위해 사용할 클래스
        int row;
        int col;
        
        public Position(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

  
    static List<Position> homeList; // 각 집의 위치를 담을 리스트
    static List<Position> chickenList; // 각 치킨집의 위치를 담을 리스트
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N, M 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        city = new int[N][N];
        homeList = new ArrayList<>(); 
        chickenList = new ArrayList<>(); 
        
        // 2. 도시 정보 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1){ // 입력한 정보가 집인 경우 집의 위치를 homeList에 저장
                    homeList.add(new Position(i, j));
                }
                if(city[i][j] == 2){ // 입력한 정보가 치킨집인 경우 위치를 chickenList에 저장
                    chickenList.add(new Position(i, j));
                }
            }
        }
        
        visited = new boolean[chickenList.size()];
        
        // 3. 치킨 거리 계산
        result = Integer.MAX_VALUE;
        calChickenDistance(0, 0);
        
        // 4. 결과 출력
        System.out.println(result);
    }
    
    // 각 집의 치킨 거리를 구하는 메서드
    public static void calChickenDistance(int index, int count){
        if(count == M){ // M개의 치킨집을 탐색한 경우 치킨 거리 계산
            int chickenDistance = 0; // 치킨 거리
            
            for(int i = 0; i < homeList.size(); i++){
                int distance = Integer.MAX_VALUE; // 최소 거리를 구하기 위한 비교값
                for(int j = 0; j < chickenList.size(); j++){
                    if(visited[j]){ // 해당 위치의 치킨집이 거리 계산의 대상인 경우
                        // 치킨 거리 계산
                        int tmp = Math.abs(homeList.get(i).row - chickenList.get(j).row)
                            + Math.abs(homeList.get(i).col - chickenList.get(j).col);
                        // 현재 위치와 가장 가까운 치킨집의 거리가 치킨 거리
                        distance = Math.min(tmp, distance);
                    }
                }
                chickenDistance += distance;
            }
            // 결과 계산
            result = Math.min(chickenDistance, result);
            return;
        }
        
        for(int i = index; i < chickenList.size(); i++){
            visited[i] = true;
            calChickenDistance(i + 1, count + 1);
            visited[i] = false; 
        }
    } 
}