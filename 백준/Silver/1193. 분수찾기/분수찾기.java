/*
대각선 방향으로 순서가 부여된다.
분자와 분모의 합이 홀수 and 대각선 칸의 개수가 짝수인 경우 오른쪽 위에서 왼쪽 아래 순
분자와 분모의 합이 짝수 and 대각선 칸의 개수가 홀수인 경우 왼쪽 아래에서 오른쪽 위 순

1. x 입력
2. 대각선 칸의 개수 + 현재 위치의 대각선 직전까지 칸의 누적합을 이용해 범위 계산
    2-1. 대각선의 개수가 홀수인 경우(cross-(x-prevCrossSum-1)) / (x-prevCrossSum)
    2-2. 대각선의 개수가 홀수인 경우 2-1의 역순으로 출력
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. x 입력
        int x = Integer.parseInt(br.readLine());
        
        int cross = 1; // 대각선 칸의 개수
        int prevCrossSum = 0; // 현재 위치의 대각선 직전까지의 칸의 누적합
        
        // 2. 대각선 칸의 개수 + 현재 위치의 대각선 직전까지 칸의 누적합을 이용해 범위 계산
        while(true){
            // 2-1. 대각선의 개수가 홀수인 경우(cross-(x-prevCrossSum-1)) / (x-prevCrossSum)
            if(x <= prevCrossSum + cross){
                if(cross % 2 == 1){
                    System.out.print((cross-(x-prevCrossSum-1)) + "/" + (x-prevCrossSum));
                    break;
                }
                // 2-2. 대각선의 개수가 홀수인 경우 2-1의 역순으로 출력
                else{
                    System.out.print((x-prevCrossSum) + "/" + (cross-(x-prevCrossSum-1)));
                    break;
                }
            }else{ // 현재 위치 대각선 직전까지 칸의 누적합과 대각선 칸의 개수 최신화
                prevCrossSum += cross;
                cross++;
            }
        }
    }
}