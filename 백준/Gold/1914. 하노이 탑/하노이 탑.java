/*
1. 장대에 쌓인 원판의 개수 N 입력
2. 하노이 탑 원판 옮기는 개수를 구하고, 원판을 옮긴 횟수와 이동 과정을 출력
*/
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class Main{
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        // 1. 장대에 쌓인 원판의 개수 N 입력
        int N = Integer.parseInt(br.readLine());  
        
        // 2. 원판을 옮긴 횟수와 이동 과정을 출력
        BigInteger count = new BigInteger("1"); // 원판을 옮긴 횟수
        if(N <= 20){ // N이 20이하인 경우에만 이동 과정 출력
            // '하노이 탑 원판을 옮긴 횟수 = 2^(원판의 개수) - 1'
            System.out.println(BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE));
            h(1, 2, 3, N); // 막대기는 3개이므로 1,2,3 입력
            System.out.println(sb);
        }else{ // N이 20보다 큰 경우 원판을 옮긴 횟수만 출력
            System.out.println(BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE));
        }
        
    }
    
    // 하노이 탑 원판 옮기는 횟수를 구하는 메서드
    static void h(int from, int m, int to, int N){
        if(N == 0){
            return;
        }
        
        h(from, to, m, N - 1);
        sb.append(from + " " + to + "\n");
        h(m, from, to, N - 1);
    }
}