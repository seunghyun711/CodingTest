/*
1. n 입력
2. MenOfPassion 알고리즘의 시간 복잡도는 O(N^2)
3. n을 입력하면 n^2만큼 수행, 최고차항의 차수는 2
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. n 입력
        Long n = Long.parseLong(br.readLine());
        
        // 2. MenOfPassion 알고리즘의 시간 복잡도는 O(N^2)
        // 3. n을 입력하면 n^2만큼 수행, 최고차항의 차수는 2
        
        System.out.println(n * n); // 알고리즘 수행 횟수
        System.out.println(2); // 최고차항 차수
    }
}