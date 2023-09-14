/*
1. 정수 입력
2. 입력받은 정수 / 4 만큼 반복하면서 "long "을 붙임
3. 출력
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 1. 정수 입력
        int num = sc.nextInt();        
        String result = ""; // 결과 문자열
        
        // 2. 입력받은 정수 / 4 만큼 반복하면서 "long "을 붙임
        for(int i = 0; i < num / 4; i++){
            result += "long ";
            
            if(i == (num/4-1)){ // 문자열 끝에 "int"를 붙임 
                result += "int";
            }
        }
        
        // 3. 출력
        System.out.println(result);
  
    }
}