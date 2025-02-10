/*
1. 갇힌 돌섬으로부터 탈출구까지의 거리 d, 작은 돌섬의 수 n, 제거할 수 있는 작은 돌섬의 수 m 입력
2. 갇힌섬으로부터 각 작은 돌섬이 얼마나 떨어져 있는지를 나타내는 수 입력
3. 리스트를 오름차순으로 정렬
4. 매개변수 탐색을 이용해 점프할 수 있는 최소거리의 최댓값 도출
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. 갇힌 돌섬으로부터 탈출구까지의 거리 d, 작은 돌섬의 수 n, 제거할 수 있는 작은 돌섬의 수 m 입력
        st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 2. 갇힌섬으로부터 각 작은 돌섬이 얼마나 떨어져 있는지를 나타내는 수 입력
        int[] dolsum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dolsum[i] = Integer.parseInt(br.readLine());
        }
        
        // 3. 리스트를 오름차순으로 정렬
        Arrays.sort(dolsum);
        
        // 4. 매개변수 탐색을 이용해 점프할 수 있는 최소거리의 최댓값 도출
        int left = 0;
        int right = d;
        int result = 0; 
        
        while(left <= right){
            int mid = (left + right) / 2; // 기준 최소 점프 거리
            int current = 0; // 현재 돌섬 위치
            int count = 0; // 삭제된 돌섬의 개수
            for(int i = 1; i <=n; i++){
                // 현재위치와 i번째 돌섬 간의 거리가 기준 최소 점프거리 이상이면 i번째 돌섬으로 점프
                if(mid <= dolsum[i] - dolsum[current]){
                    current = i; // 현재 위치 이동
                }else{ // 아니면 돌섬 제거
                    count++; 
                }
            }
            // 삭제한 돌섬의 개수가 m 보다 큰 경우 right를 mid-1로 변경하여 기준 최소 점프 거리를 줄인다.
            // 삭제한 돌섬의 개수가 많아졌다는 것은 현재 기준 최소 점프 거리가 너무 긴 것임.
            if(count > m){ 
                right = mid - 1;
            }else{ // result 값을 mid 값으로 설정 후 left를 mid + 1로 하여 다음 상황 탐색
                result = mid; 
                left = mid + 1;
            }
        }
        
       
        // 5. 결과 출력
        System.out.println(result);
    }
}