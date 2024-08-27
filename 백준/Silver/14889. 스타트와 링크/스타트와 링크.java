/*
1. N 입력
2. 능력치 입력
3. 2에서 입력받은 능력치를 기반으로 두 팀의 능력치 차이의 최솟값을 구한다.
*/
import java.io.*;
import java.util.*;
public class Main{
    static int[][] stats; // 능력치를 담을 2차원 배열
    static boolean[] visited; // 방문 여부 파악하는 배열
    static int N;
    static int minStat = 9999; // 능력치 차이의 최솟값 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N 입력
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        
        stats = new int[N][N]; // 능력치 배열 크기 선언
        
        // 2. 능력치 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 3. 2에서 입력받은 능력치를 기반으로 두 팀의 능력치 차이의 최솟값을 구한다.
        matchingTeam(0, 0);
        
        System.out.println(minStat);
    }
    
    // 팀을 매칭하는 메서드
    static void matchingTeam(int count, int index){
        if(count == N/2){ // 한 팀이 완성된 경우(하나의 팀의 인원수는 N/2명)
            calcStat(); // 각 팀의 능력치 차이 계산
            return;
        }
        
        for(int i = index; i < N; i++){
            if(!visited[i]){
                visited[i] = true; // 현재 위치 방문
                matchingTeam(count + 1, i + 1);
                visited[i] = false; // 방문 초기화
            } 
        }
    }
    
    // 각 팀의 능력치 차이를 계산하는 메서드
    static void calcStat(){
        int startTeamStat = 0; // 스타트 팀의 능력치
        int linkTeamStat = 0; // 링크 팀의 능력치
        
        for(int i = 0; i < N - 1; i++){
            for(int j = i+1; j < N; j++){
                if(visited[i] == true && visited[j] == true){ // visited[i]와 visited[j]가 모두 true인 경우 i,j가 한 팀
                    startTeamStat += stats[i][j];
                    startTeamStat += stats[j][i];
                }
                else if(visited[i] == false && visited[j] == false){ // visited[i]와 visited[j]가 모두 false인 경우 i,j가 한 팀
                    linkTeamStat += stats[i][j];
                    linkTeamStat += stats[j][i];
                }
            }
        }
        
        // 스타트 팀과 링크 팀의 능력치 차이 계산
        int calculatedStat = Math.abs(startTeamStat - linkTeamStat);
        
        if(calculatedStat == 0){ // 두 팀 간의 능력치 차이가 0이면 0을 결과로 출력하고, 프로그램 종료
            System.out.println(0);
            System.exit(0);
        }
        
        // 능력치 차이의 최솟값 도출
        minStat = Math.min(calculatedStat, minStat);
    }
}