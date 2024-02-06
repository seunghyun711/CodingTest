/*
1. N 입력
2. 집을 칠하는 비용을 담을 2차원 배열 선언
3. 비용 입력
4. i번째 색이 빨간색일 때 + i-1번째의 초록색이거나 파란색일 때 최소값을 이용해 계산한다.
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 집을 칠하는 비용을 담을 2차원 배열 선언
        int[][] cost = new int[N + 1][3];
        
        // 3. 비용 입력
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int red = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            
            // 4. i번째 색이 빨간색일 때 + i-1번째의 초록색이거나 파란색일 때 최소값을 이용해 계산한다.
            cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + red;
            cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + green;
            cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + blue;
        }
        System.out.println(Math.min(cost[N][0], Math.min(cost[N][1], cost[N][2])));
    } 
}