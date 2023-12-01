/*
1. n 입력
2. MenOfPassion 알고리즘을 수행 과정을 보면 n-1 + n-2 + n-3 ... + 1의 과정을 거쳐 
수행 횟수가 정해진다. 등차가 1인 등차수열이다. 차수는 2
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. n 입력
        Long n = Long.parseLong(br.readLine());
        
        // 2. MenOfPassion 알고리즘을 수행 과정을 보면 n-1 + n-2 + n-3 ... + 1의 과정을 거쳐 
        // 수행 횟수가 정해진다. 등차가 1인 등차수열이다. 차수는 2
        System.out.println(n * (n-1) / 2); // 수행 횟수
        System.out.println(2); // 차수
    }
}