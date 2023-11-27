/*
1. N입력
2. N개의 좌표 입력
3. x 좌표의 최댓값 & 최솟값 / y 좌표의 최댓값 & 최솟값 구하기 
4. (x 좌표의 최댓값 - x 좌표의 최솟값) * (y 좌표의 최댓값 - y 좌표의 최솟값) = 결과
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. N입력
        int N = Integer.parseInt(br.readLine());
        
        int[] x = new int[N]; // x 좌표 값을 담을 배열
        int[] y = new int[N]; // y 좌표 값을 담을 배열
        
        // 2. N개의 좌표 입력
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. x 좌표의 최댓값 & 최솟값 / y 좌표의 최댓값 & 최솟값 구하기 
        Arrays.sort(x); // x 값 배열 정렬
        Arrays.sort(y); // y 값 배열 정렬
        
        // 4. (x 좌표의 최댓값 - x 좌표의 최솟값) * (y 좌표의 최댓값 - y 좌표의 최솟값) = 결과
        System.out.println((x[x.length - 1] - x[0]) * (y[y.length - 1] - y[0]));
    }
}