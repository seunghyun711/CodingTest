/*
n번째 점 개수 = n번째 한 변의 점 개수 ^ 2
0번째 : 2 ^ 2 
1번째 : 3 ^ 2
2번째 : 5 ^ 2
3번째 : 9 ^ 2
(0,1,2 -> +1, +2, +4 증가)
n번째 한 변의 점 개수는 2 ^ n + 1의 규칙

1. N 입력
2. N을 규칙에 대입하여 점의 개수 반환
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. N을 규칙에 대입하여 점의 개수 반환
        System.out.println((int)Math.pow(Math.pow(2, N) + 1, 2));
    }
}