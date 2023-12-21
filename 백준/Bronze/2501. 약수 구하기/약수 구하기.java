/*
1. N, K 입력
2. 반복문을 통해 약수를 구하면서 count 변수를 통해 약수의 개수 카운트
3. count == k일 때의 약수를 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 1. N, K 입력
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int count = 0; // 약수의 개수
        int result = 0; // 결과
        
        // 2. 반복문을 통해 약수를 구하면서 count 변수를 통해 약수의 개수 카운트
        for(int i = 1; i <= N; i++){
            // 3. count == k일 때의 약수를 출력
            if(N % i == 0){
                count++;
            }
            
            if(count == K){
                result = i;
                break;
            }
        }
        System.out.println(result);
        
    }
}