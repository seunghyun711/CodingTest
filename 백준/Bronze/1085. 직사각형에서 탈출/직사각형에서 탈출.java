/*
1. x,y,w,h 입력
2. x-w간 거리 & y-h간 거리 계산 / x-(0,y)간 거리 & y-(x,0)간 거리 계산
3. 2번의 결과로 나온 값 중 작은 값이 최솟값이므로 해당 결과 출력
-> x-w 간 거리와 y-h간 거리 중 더 작은 값과 x-(y,0)간의 거리와 y-(x,0) 중 더 작은 값을 비교해 둘 중 작은 값이 최솟값
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1. x,y,w,h 입력
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        // 2. x-w간 거리 & y-h간 거리 계산 / x-(0,y)간 거리 & y-(x,0)간 거리 계산
        int xw = Math.abs(x-w); // x-w간 거리 단순 거리 계산이므로 절대값으로 표현
        int yh = Math.abs(y-h); // y-h간 거리
        int xy0 = x; // x-(0,y)간 거리
        int yx0 = y; // y-(x,0)간 거리 계산
        
        int result1; // 결과1(x-w 간 거리와 y-h간 거리 중 더 작은 값)
        int result2; // 결과2(x-(y,0)간의 거리와 y-(x,0) 중 더 작은 값)
        
        if(xw >= yh){
            result1 = yh;
        }else{
            result1 = xw;
        }
        
        if(xy0 >= yx0){
            result2 = yx0;
        }else{
            result2 = xy0;
        }
        
        // 3. 2번의 결과로 나온 값 중 작은 값이 최솟값이므로 해당 결과 출력
        if(result1 >= result2){
            System.out.println(result2);
        }else{
            System.out.println(result1);
        }
    }
}