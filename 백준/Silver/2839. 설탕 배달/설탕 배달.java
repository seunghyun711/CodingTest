/*
1. N 입력
2. N이 4나 7의 배수인 경우, 3,5로 나누어 떨어지지 않기 때문에 -1 출력
3. N이 5로 나누어 떨어지는 경우 N을 5로 나눈 몫이 결과값
4. N이 5로 나누어 떨어지지 않는 경우, count를 증가시키고 N-=3을 하여 반복문 수행
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        int count = 0; // 봉지 개수
        
        while(true){
            // 2. N이 3,5로 나누어 떨어지지 않는 경우 결과는 -1
            if(N < 0){
                count = -1;
                break;
            }
            
            // 3. N이 5로 나누어 떨어지는 경우 N을 5로 나눈 몫이 결과값
            if(N % 5 == 0){
                count += N / 5;
                break;
            }
            // 4. N이 5로 나누어 떨어지지 않는 경우, count를 증가시키고 N-=3을 하여 반복문 수행
            else{
                count++;
                N -= 3;
            }
        }
        System.out.println(count);
        
    }
}