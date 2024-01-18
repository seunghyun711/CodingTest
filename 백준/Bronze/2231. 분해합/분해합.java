/*
1. 입력받을 수의 자리수 계산
2. N 입력
3. 각 자리수 합 계산
4. 생성자를 찾은 경우 해당 값 리턴
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 입력받을 수의 자리수 계산
        String str = br.readLine();
        int nLength = str.length(); // 입력받을 수(N이 될 수)의 자리수
        
        // 2. N 입력
        int N = Integer.parseInt(str);
       
        int result = 0; // 결과 변수
        
        // 3. 각 자리수 합 계산
        /*
        N = k + k1+k2+k3... 로 계산을 하는데 각 자리수의 합이 최대일 때는 각 자리수가 전부 9인 경우다
        따라서 N-(N의 자리수 * 9) 미만의 수는 생성자가 될 수 없으니 
        N-(N의 자리수 * 9)부터 탐색을 시작한다.
        */
        for(int i = (N - (nLength * 9)); i < N; i++){
            int num = i;
            int sum = 0; // 각 자리수의 합
            
            while(num != 0){
                sum += num % 10;
                num /= 10;
            }
            
            // 4. 생성자를 찾은 경우 해당 값 리턴
            if(sum + i == N){ // // 각 자리수의 합과 i(각 자리수를 이어 붙인 수(ex: 각 자리수가 1,2,3 이면 i는 123))
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}