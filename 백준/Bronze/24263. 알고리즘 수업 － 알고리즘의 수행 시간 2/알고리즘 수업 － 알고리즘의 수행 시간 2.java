/*
1. n 입력
2. MenOfPassion 알고리즘은 O(n)의 시간 복잡도를 가지는 알고리즘이다.
3. 알고리즘의 수행 횟수와 최고차항의 차수 출력
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        // 1. n 입력
        int n = Integer.parseInt(br.readLine());
    
        // 2. MenOfPassion 알고리즘은 O(n)의 시간 복잡도를 가지는 알고리즘이다.
    
        // 3. 알고리즘의 수행 횟수와 최고차항의 차수 출력 
        System.out.println(n); // 알고리즘 수행 횟수
        System.out.println(1); // 최고차항의 차수
        
    }
    
}