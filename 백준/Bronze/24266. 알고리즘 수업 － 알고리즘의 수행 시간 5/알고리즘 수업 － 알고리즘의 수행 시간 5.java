/*
1. n 입력
2. 알고리즘의 시간 복잡도는 O(n^3)
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. n 입력
        Long n = Long.parseLong(br.readLine());
        
        // 2. 알고리즘의 시간 복잡도는 O(n^3)
        System.out.println(n * n * n); // 수행 횟수
        System.out.println(3); // 최고차항 차수
    }
}