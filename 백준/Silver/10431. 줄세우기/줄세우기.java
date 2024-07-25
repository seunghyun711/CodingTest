/*
1. 테스트 케이스 수 P 입력
2. 테스트 케이스 번호(T), 20개의 양의 정수 입력
3. 반복문을 통해 배열 내 값 비교 후 배열 이동을 한 횟수를 계산
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 테스트 케이스 수 P 입력
        int P = Integer.parseInt(br.readLine());
        
        // 2. 테스트 케이스 번호(T), 20개의 양의 정수 입력
        for(int i = 0; i < P; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            
            int count = 0; // 이동 횟수
            int[] arr = new int[20]; // 20개의 정수를 담을 배열
            
            for(int j = 0; j < 20; j++){
                arr[j] = Integer.parseInt(st.nextToken()); // 20개의 정수 입력
                
            }
            
            // 3. 반복문을 통해 배열 내 값 비교 후 배열 이동을 한 횟수를 계산
            for(int x = 0; x < 20; x++){
                for(int y = 0; y < x; y++){
                    if(arr[x] < arr[y]){ // 현재 위치의 값보다 앞에 있는 값이 더 큰 경우 이동 횟수 증가
                        count++;
                    }
                }
            }
            
            System.out.println(i + 1 + " " + count);
            
        }
        
    }
}
