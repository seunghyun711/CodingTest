/*
1. N, K 입력
2. 반복문으로 N의 약수를 구하기
3. 약수가 나올 때마다 count를 해서 count == K면 반복문 종료하고 값 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1. N, K 입력
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int count = 0; // 약수의 개수
        int result = 0; // 결과
        
        // 2. 반복문으로 N의 약수를 구하기
        for(int i = 1; i <= N; i++){
            // 3. 약수가 나올 때마다 count를 해서 count == K면 반복문 종료하고 값 출력
            if(N % i == 0){
                count++;
            }
            
            if(count == K){
                result  = i;
                break;
            }
        }
        System.out.println(result);
    }
}