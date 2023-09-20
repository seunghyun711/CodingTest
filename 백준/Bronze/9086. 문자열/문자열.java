/*
1. 테스트 케이스 개수 입력
2. 문자열 입력
3. 문자열의 첫번째 글자와(0번 인덱스) 마지막 글자(문자열.length()-1)추출하여 출력
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 1. 테스트 케이스 개수 입력
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            // 2. 문자열 입력
            String s = sc.next();
                
            // 3. 문자열의 첫번째 글자와(0번 인덱스) 마지막 글자(문자열.length()-1)추출하여 출력
            String first = String.valueOf(s.charAt(0)); // 첫 번쨰 글자
            String last = String.valueOf(s.charAt(s.length()-1)); // 마지막 글자
            
            System.out.println(first + last);
        }
    }
}