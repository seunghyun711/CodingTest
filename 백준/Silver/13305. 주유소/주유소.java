/*
1. N 입력
2. 각 도시 간 거리 입력
3. 주유소 리터당 가격 입력
4. 비용 계산
5. 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0; // 총 비용
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        int[] distance = new int[N - 1]; // 각 도시 간 거리
        int[] cost = new int[N]; // 주유소 별 리터당 가격
        
        // 2. 각 도시 간 거리 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < distance.length; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. 주유소 리터당 가격 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        // 4. 비용 계산
        int minCost = cost[0]; // 리터당 최소 가격
        for(int i = 0; i < distance.length; i++){
            // 현재 위치 주유소의 리터당 가격 보다 다음 주유소의 리터당 가격이 낮은 경우 다음 주유소에서 충전
            if(cost[i] < minCost){
                minCost = cost[i]; // 충전 후 리터당 최소 가격 최신화
            }
            
            result += (minCost * distance[i]); 
        }
        
        // 5. 출력
        System.out.println(result);
    }
}