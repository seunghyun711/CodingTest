/*
1. 수열의 길이 N입력
2. 수열 입력
3. 수열 순서대로 탐색을 하면서 각 탐색위치에 해당하는 연속된 수열의 개수 저장
4. 3번을 통해 얻은 결과들 중 가장 큰 값 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
     
        // 1. 수열의 길이 N입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 수열 입력
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. 수열 순서대로 탐색을 하면서 각 탐색위치에 해당하는 연속된 수열의 개수 저장
        int increase = 1; // 증가하는 수열
        int decrease = 1; // 감소하는 수열
        int max = 1;
        for(int i = 1; i < N; i++){
            // 증가하는 경우
            if(arr[i] >= arr[i - 1]){
                increase++;
            }else{
                increase = 1; // 증가 이후 감소하면 increase를 1로 초기화
            }
            
            // 감소하는 경우
            if(arr[i] <= arr[i - 1]){
                decrease++;
            }else{
                decrease = 1; // 감소 이후 증가하면 decrease를 1로 초기화
            }
            // 4. 3번을 통해 얻은 결과들 중 가장 큰 값 출력
            max = Math.max(max, Math.max(increase, decrease));
        }
        System.out.println(max);
    }
}