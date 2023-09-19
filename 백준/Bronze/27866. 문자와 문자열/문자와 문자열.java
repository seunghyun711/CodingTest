/*
1. 문자열 입력
2. 몇번째 문자를 출력할지 입력
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 1. 문자열 입력
        String s = sc.next();
        
        // 2. 몇번째 문자를 출력할지 입력
        int n = sc.nextInt()-1; // 배열의 인덱스는 0부터 시작이므로 그에 맞추기 위해 1을 뺀다.
        
        System.out.println(s.charAt(n));
    }
}