/*
1. N 입력
2. x,y 좌표 입력
3. 다각형의 넓이 계산
<다각형 넓이 계산 방법>
* x,y 좌표를 나열할 때 가장 마지막에 첫 번째 x,y 좌표를 추가한다.
1. 각 꼭지점의 x좌표를 다음 꼭지점의 y좌표와 곱한 후 모두 더한다.
2. 각 꼭지점의 y좌표를 다음 꼭지점의 x좌표와 곱산 후 모두 더한다.
3. 2번의 결과 - 1번의 결과
4. 3번의 결과 / 2
*/
import java.io.*;
import java.util.*;
public class Main{
    static long calcX = 0; // 각 꼭지점의 x좌표를 다음 꼭지점의 y좌표와 곱한 후 더한 값
    static long calcY = 0; // 각 꼭지점의 y좌표를 다음 꼭지점의 x좌표와 곱산 후 더한 값
    static int N; // 좌표의 개수
    static long[] x; // 각 꼭지점의 x좌표를 담을 배열
    static long[] y; // 각 꼭지점의 y좌표를 담을 배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N 입력
        N = Integer.parseInt(br.readLine());
        
        // 2. x,y 좌표 입력
        x = new long[N + 1]; // 각 꼭지점의 x좌표를 담을 배열
        y = new long[N + 1]; // 각 꼭지점의 y좌표를 담을 배열
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }
        
        // x,y 좌표를 나열할 때 가장 마지막에 첫 번째 x,y 좌표를 추가
        x[N] = x[0];
        y[N] = y[0];
        
        // 3. 다각형의 넓이 계산
        calcX(); // 각 꼭지점의 x좌표를 다음 꼭지점의 y좌표와 곱한 후 더한다.
        calcY(); // 각 꼭지점의 y좌표를 다음 꼭지점의 x좌표와 곱산 후 더한다.
        
        double tmpResult = Math.abs(calcY - calcX) / 2.0;
        String result = String.format("%.1f", tmpResult);
        
        System.out.println(result);
          
    }
    
    // 각 꼭지점의 x좌표를 다음 꼭지점의 y좌표와 곱한 후 더하는 메서드
    static void calcX(){
        for(int i = 0; i < N; i++){
            calcX += x[i] * y[i+1];
        }
    }
    
    // 각 꼭지점의 y좌표를 다음 꼭지점의 x좌표와 곱한 후 더하는 메서드
    static void calcY(){
        for(int i = 0; i < N; i++){
            calcY += y[i] * x[i+1];
        }
    }
}