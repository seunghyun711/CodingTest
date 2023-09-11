/*
입력받은 불기 연도에서 543을 빼서 출력
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int bulgi = sc.nextInt(); // 불기 연도 입력
        int seogi = bulgi - 543; // 서기 연도
        
        System.out.println(seogi);
    }
}