/*
1. M,N 입력
2. boolean 타입의 배열을 N+1 크기로 선언
3. 해당 배열을 에라토스테네스의 체 알고리즘을 적용하여 소수 판별
4. M과 N 사이의 소수 중 최솟값과 소수의 합을 구한다.
*/
import java.io.*;
public class Main{
    public static boolean prime[]; // 소수를 판별한 결과를 담을 배열(false : 소수O, true : 소수X)
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. M,N 입력
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        int sum = 0; // 소수의 합
        int min = Integer.MAX_VALUE; // M~N 사이 소수 중 최솟값
        
        // 2. boolean 타입의 배열을 N+1 크기로 선언
        prime = new boolean[N+1];
        
        // 3. 해당 배열을 에라토스테네스의 체 알고리즘을 적용하여 소수 판별
        primeAlgorithm(); // 에라토스테네스의 체 알고리즘 적용
        
        // 4. M과 N 사이의 소수 중 최솟값과 소수의 합을 구한다.
        for(int i = M; i <= N; i++){
            if(prime[i] == false){ // i가 소수인 경우
                sum += i; 
                if(min == Integer.MAX_VALUE){
                    min = i;
                }
            }
        }
        
        if(sum == 0){ // 소수가 없는 경우 -1 출력
            System.out.println(-1);
        }else{
            System.out.println(sum); // 소수의 합
            System.out.println(min); // 최솟값
        }
    }
    
    // 에라토스테네스의 체 알고리즘
    public static void primeAlgorithm(){
        // 0과 1은 소수가 아니기 때문에 prime[0],prime[1]을 true로 초기화
        prime[0] = true;
        prime[1] = true;
        
        for(int i = 2; i <= Math.sqrt(prime.length); i++){
            if(prime[i]) { // 이미 판별한 인덱스인 경우 continue
                continue;
            }
            for(int j = i * i; j < prime.length; j += i){
                prime[j] = true;
            }
        }
    }
}