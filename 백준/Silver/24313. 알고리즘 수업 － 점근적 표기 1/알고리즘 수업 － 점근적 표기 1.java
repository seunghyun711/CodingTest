/*
1. a1, a0, c, n0 입력
2. a1*n0 + a0 <= c*n0 이 성립하는 경우 1, 아니라면 0 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1. a1, a0, c, n0 입력
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        
        // 2. a*n + a <= c*n 이 성립하는 경우 1, 아니라면 0 출력
        if(a1 * n0 + a0 <= c * n0 && c >= a1){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}