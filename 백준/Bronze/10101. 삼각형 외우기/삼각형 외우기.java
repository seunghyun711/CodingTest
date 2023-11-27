/*
1. 세 각의 크기 입력
2. 세 각의 크기의 합이 180인 경우 문제에 있는 조건에 따라 삼각형 판별 후 출력
3. 세 각의 크기의 합이 180이 아닌 경우 Error 출력
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 세 각의 크기 입력
        int a = Integer.parseInt(br.readLine());
        
        int b = Integer.parseInt(br.readLine());
        
        int c = Integer.parseInt(br.readLine());
        
        int sum = a + b + c;
        
        // 2. 세 각의 크기의 합이 180인 경우 문제에 있는 조건에 따라 삼각형 판별 후 출력
        if(sum == 180){
            if(a == 60 && b == 60 && c == 60){ // 세 각의 크기가 모두 60이면, Equilateral
                System.out.println("Equilateral"); 
            }
            else if(a == b || a == c || b == c){ // 세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
                System.out.println("Isosceles");
            }else{ // 세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
                System.out.println("Scalene");
            }
        }else{ // 세 각의 합이 180이 아닌 경우에는 Error
            System.out.println("Error");
        }
    }
}