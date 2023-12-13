/*
1. N 입력
2. N의 소인수분해 결과 계산
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. N의 소인수분해 결과 계산
        for(int i = 2; i <= Math.sqrt(N); i++){
            while(N % i == 0){
                System.out.println(i);
                N /= i;
            }
        }
        if(N != 1){
            System.out.println(N);
        }
    }
}