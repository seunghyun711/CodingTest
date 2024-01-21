/*
1. a~f에 들어갈 정수 입력
2. 연립 방정식을 계산하여 x,y값을 구한다.
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1. a~f에 들어갈 정수 입력
        /*
        ax + by = c
        dx + ey = f
        */
        int a = Integer.parseInt(st.nextToken()); 
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        
        // 2. 연립 방정식을 계산하여 x,y값을 구한다.
        /*
        연립 방정식 x,y 값 구하는 방식(예시)
        <x값>
        1.
        by = c - ax
        ey = f - dx
        
        2. 
        y = (c/b) - (ax/b)
        y = (f/e) - (dx/e)
        
        3.
        (c/b) - (ax/b) = (f/e) - (dx/e)
        (c/b) - (f/e) = (ax/b) - (dx/e)
        
        4. 
        (c*e) - (f*b) = (ax*e) - (dx*b)
        (c*e) - (f*b) = ((a*e) - (d*b)) * x
        ((c*e) - (f*b)) / ((a*e) - (d*b)) = x  
        
        y값도 같은 방식으로 구한다.
        */
        int x = ((c*e) - (f*b)) / ((a*e) - (d*b));
        int y = ((c*d) - (a*f)) / ((b*d) - (a*e));
        
        System.out.println(x + " " + y);
        
    }
}