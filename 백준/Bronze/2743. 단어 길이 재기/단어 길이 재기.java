/*
1. 문자열 입력
2. 문자열의 길이 length()로 구하기
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 1. 문자열 입력
        String s = sc.next();
        
        // 2. 문자열의 길이 length()로 구하기
        int sLength = s.length();
        
        System.out.println(sLength);
    }
}
