/*
1. N 입력
2. 도형의 둘레 길이는 N * 4
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. N 입력
        long N = Long.parseLong(br.readLine());
        
        // 2. 도형의 둘레 길이는 N * 4
        System.out.println(N * 4); 
    }
}