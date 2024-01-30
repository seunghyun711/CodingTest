/*
1. N 입력
2. 666 부터 1씩 증가시키면서 666을 포함하는 경우 그 위치가 N이라면 해당 수 출력
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 666 부터 1씩 증가시키면서 666을 포함하는 경우 그 위치가 N이라면 해당 수 출력
        int num = 666; // 첫 번째 수
        int count = 1; // 666이 포함된 수의 순서(666인 경우 count는 1, 1666인 경우 count는 2)
        
        while(count != N){
            num++;
            if(String.valueOf(num).contains("666")){ // num이 666을 포함한 경우 count++
                count++;
            }
        }
        System.out.println(num);
    }
}