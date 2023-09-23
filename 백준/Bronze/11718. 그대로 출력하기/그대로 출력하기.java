/*
1. 반복문을 통해 문자열 입력
2. 문자열이 없을 때까지 반복하여 출력
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s; // 입력받은 문자열
        
        // 1. 반복문을 통해 문자열 입력
        while((s = br.readLine()) != null){
            // 2. 문자열이 없을 때까지 반복하여 출력
            System.out.println(s);
        }
    }
}