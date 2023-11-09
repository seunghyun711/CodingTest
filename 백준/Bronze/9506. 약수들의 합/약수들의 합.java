/*
1. n 입력
2. n의 약수를 배열에 저장
3. n이전까지의 약수를 모두 더한다.
    3-1. n이전까지의 약수 합 == n 이면 n을 n이 아닌 약수들의 합으로 나타내어 출력
    3-2. n이전까지의 약수 합 != n 이면 'n is NOT perfect.' 출력 
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. n 입력
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == -1){ // n이 -1이면 n 입력 종료
                break;
            }
            
            int[] arr = new int[n]; // n의 약수를 담을 배열
            int sum = 0; // 약수의 합
            int count = 0; // 약수가 담긴 배열의 현재 인덱스
            
            // 3. n이전까지의 약수를 모두 더한다.
            for(int i = 1; i < n; i++){
                if(n % i == 0){ // 약수인 경우
                    arr[count++] = i; // 배열에 약수 저장
                    sum += i; // 약수의 합 계산
                }
            }
            // 3-2. n이전까지의 약수 합 != n 이면 'n is NOT perfect.' 출력 
            if(sum != n){
                System.out.println(n + " is NOT perfect.");
                continue;
            }
            
            // 3-1. n이전까지의 약수 합 == n 이면 n을 n이 아닌 약수들의 합으로 나타내어 출력
            System.out.print(n + " = ");
            for(int i = 0; i < count; i++){
                if(i == count-1){
                    System.out.print(arr[i]);
                }
                else{
                    System.out.print(arr[i] + " + ");
                }
            }
            System.out.println();
        }
    }
}