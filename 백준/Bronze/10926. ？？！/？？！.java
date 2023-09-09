/*
1. 사용자가 아이디를 입력했을 때 ??!를 문자열에 붙여서 출력
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String inputId = sc.nextLine();
        System.out.println(inputId + "??!");
    }
}