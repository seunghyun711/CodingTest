import java.io.*;
/*
1. 돌의 개수 N 입력
2. 상근 -> 창영 순서로 게임이 진행 시 N이 짝수인 경우에는 창근이, N이 홀수인 경우에는 상근이 이긴다.
3. 결과 출력(SK or CY)
*/
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 돌의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 상근 -> 창영 순서로 게임이 진행 시 N이 짝수인 경우에는 창근이, N이 홀수인 경우에는 상근이 이긴다.
        if(N % 2 == 0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
        
    }
}