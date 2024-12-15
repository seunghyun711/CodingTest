/*
1. n, m 입력
2. 최소 비용을 나타내는 배열 초기화
3. 버스 정보 입력
4. 플로이드-워셜 알고리즘을 이용해 최소 비용 계산
*/
import java.io.*;
import java.util.*;
public class Main{
    static final int MAX_VALUE = 987654321;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] lowestCost; // 최소 비용
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. n, m 입력
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        // 2. 최소 비용을 나타내는 배열 초기화
        lowestCost = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){ // 출발지 == 도착지인 경우 0으로 초기화
                    lowestCost[i][j] = 0;
                }else{
                    // 출발지!=도착지인 경우 Integer.MAX_VALUE로 초기화
                    lowestCost[i][j] = MAX_VALUE;
                }
                
            }
        }
        
        // 3. 버스 정보 입력
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발지
            int end = Integer.parseInt(st.nextToken()); // 목적지
            int cost = Integer.parseInt(st.nextToken()); // 비용
            
            // 이전에 입력한 경로가 또 입력된 경우
            lowestCost[start - 1][end - 1] = Math.min(lowestCost[start - 1][end - 1], cost);
        }
        
        // 4. 플로이드-워셜 알고리즘을 이용해 최소 비용 계산
        calcCost(lowestCost);
    }
    
    // 플로이드-워셜 알고리즘을 이용한 최소 비용을 구하는 메서드
    static void calcCost(int[][] lowestCost){
        for(int i = 0; i < n; i++){ // 경유지
            for(int j = 0; j < n; j++){ // 출발지
                for(int k = 0; k < n; k++){ // 목적지
                    lowestCost[j][k] = Math.min(lowestCost[j][k], lowestCost[j][i] + lowestCost[i][k]);
                }
            }
        }
        
        // 결과 출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(lowestCost[i][j] == MAX_VALUE){
                    System.out.print(0 + " ");
                }else{
                    System.out.print(lowestCost[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}