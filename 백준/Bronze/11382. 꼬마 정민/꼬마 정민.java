/*
세 개의 숫자를 공백을 포함해서 입력하고 각각의 숫자를 모두 더한 겂을 출력
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 세 개의 숫자를 공백을 포함해서 입력
        long num1 = sc.nextLong();
        long num2 = sc.nextLong();
        long num3 = sc.nextLong();
        
        // 각각의 숫자를 더한 값을 출력
        System.out.println(num1 + num2 + num3);
    }
}