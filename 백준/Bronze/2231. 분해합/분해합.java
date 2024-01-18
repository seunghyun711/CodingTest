/*
1. N 입력
2. 각 자리수 합 계산
3. 생성자를 찾은 경우 해당 값 리턴
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        int result = 0; // 결과 변수
        
        // 2. 각 자리수 합 계산
        for(int i = 0; i < N; i++){
            int num = i;
            int sum = 0; // 각 자리수의 합
            
            while(num != 0){
                sum += num % 10; // 각 자리수 덧셈
                num /= 10; 
            }
            
            // 3. 생성자를 찾은 경우 해당 값 리턴
            if(sum + i == N){ // 각 자리수의 합과 i(각 자리수를 이어 붙인 수(ex: 각 자리수가 1,2,3 이면 i는 123))
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}