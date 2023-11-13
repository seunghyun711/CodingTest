/*
1. N과 N개의 숫자 입력
2. N개의 제곱근 까지의 수를 통해 약수 확인
    2-1. 소수인 경우 true, 소수가 아닌 경우 false로 구분
3. 약수의 개수가 총 2개면 소수 -> 소수 개수 카운트
4. 총 소수의 개수 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. N과 N개의 숫자 입력
        br.readLine(); // N입력
        int count = 0; // 소수의 개수
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 2. N개의 제곱근 까지의 수를 통해 약수 확인
        while(st.hasMoreTokens()){
            // 2-1. 소수인 경우 true, 소수가 아닌 경우 false로 구분
            boolean isPrime = true;
            
            int num = Integer.parseInt(st.nextToken());
            
            if(num == 1){ // 입력받은 수가 1인 경우 계속 진행
                continue;
            }
            
            // 3. 약수의 개수가 총 2개면 소수 -> 소수 개수 카운트
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0){ // 1과 num 이외의 값으로 나누어 떨어지므로 소수가 아님
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){ // 소수인 경우 count증가
                count++;
            }
        }
        // 4. 총 소수의 개수 출력
        System.out.println(count);
    }
}