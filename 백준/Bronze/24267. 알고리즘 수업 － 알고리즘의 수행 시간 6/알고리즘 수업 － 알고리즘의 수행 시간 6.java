/*
1. n 입력
2. n(n-1)(n-2)/6 의 공식을 이용하면 n에 따른 결과값을 구할 수 있음
3. 3중 for문이므로 최고차항의 차수는 3
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. n 입력
        long n = Long.parseLong(br.readLine());
        
        // 2. n(n-1)(n-2)/6 의 공식을 이용하면 n에 따른 결과값을 구할 수 있음
        System.out.println((n * (n-1) * (n-2)) / 6);
        
        // 3. 3중 for문이므로 최고차항의 차수는 3
        System.out.println(3);
        
        
    }
}