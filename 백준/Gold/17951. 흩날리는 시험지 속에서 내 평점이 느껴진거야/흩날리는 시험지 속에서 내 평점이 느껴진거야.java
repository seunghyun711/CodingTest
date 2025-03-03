/*
1. 시험지의 개수 N, 그룹의 수 K 입력
2. 각 시험지마다 맞은 문제의 개수 x 입력
3. 매개변수 탐색을 통해 결과 계산
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. 시험지의 개수 N, 그룹의 수 K 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 2. 각 시험지마다 맞은 문제의 개수 x 입력
        int[] count = new int[N]; // 맞은 문제의 개수를 담을 배열
        st = new StringTokenizer(br.readLine()); 
        for(int i = 0; i < N; i++){
            count[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. 매개변수 탐색을 통해 결과 계산
        int left = 0;
        int right = 2000000;
        while(left <= right){
            int mid = (left + right) / 2; // 기준 최대 점수
            int sum = 0;
            int groups = 0; // 그룹 개수
            
            for(int i = 0; i < N; i++){
                sum += count[i];
                if(mid <= sum){ // sum이 기준 최대 점수 이상이면 하나의 그룹이 완성
                    sum = 0;
                    groups++;
                }
            }
            
            if(groups >= K){ // groupCount가 K 이상인 경우 기준 최대 점수가 작은 것이므로 left = mid + 1
                left = mid + 1;
            }else{ // groupCount가 K보다 작은 경우 기준 최대 점수가 큰 것이므로 right = mid - 1
                right = mid - 1;
            }
            
        }
        // 4. 결과 출력
        System.out.println(right);
     
    }
}