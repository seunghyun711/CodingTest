/*
1. A, B 입력
2. A * B의 값 출력
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. A, B 입력
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        
        // 2. A * B의 값 출력
        System.out.println(A*B);
    }
}