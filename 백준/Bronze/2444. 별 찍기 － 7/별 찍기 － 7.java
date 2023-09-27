/*
1. 정수 N 입력
2. 2*N-1 번째 줄을 기준으로 2개로 나눠서 계산 - 2*N-1 기준 상단
    2-1. 공백이 들어갈 패턴 계산
    2-2. *이 출력되는 패턴 계산(공백이 없는 부분까지 출력)
3. 2*N-1 번째 줄을 기준으로 2개로 나눠서 계산 - 2*N-1 기준 하단
    3-1. 공백이 들어갈 패턴 계산
    3-2. *이 출력되는 패턴 계산(공백이 1 칸인 부분부터 출력)
*/
import java.io.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 정수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 2*N-1 번째 줄을 기준으로 2개로 나눠서 계산
        for(int i = 1; i <= N; i++){
            // 2-1. 공백이 들어갈 패턴 계산
            for(int j = 0; j < N-i; j++){
                System.out.print(" ");
            }
            // 2-2. *이 출력되는 패턴 계산(공백이 없는 부분까지 출력)
            for(int j = 0; j < i*2-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        
        // 3. 2*N-1 번째 줄을 기준으로 2개로 나눠서 계산 - 2*N-1 기준 하단
        for(int i = N-1; i >= 0; i--){
            // 3-1. 공백이 들어갈 패턴 계산
            for(int j = 0; j < N-i; j++){
                System.out.print(" ");
            }
            // 3-2. *이 출력되는 패턴 계산(공백이 1 칸인 부분부터 출력)
            for(int j = 0; j < i*2-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}