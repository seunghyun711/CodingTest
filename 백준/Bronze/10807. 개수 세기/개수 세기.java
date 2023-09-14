/*
1. 정수의 개수 입력
2. 정수의 개수 만큼 정수 입력
3. 탐색하려는 정수 입력
4. 입력받은 정수들 중 탐색하려는 정수의 개수 파악
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 1. 정수의 개수 입력
        int numCount = sc.nextInt();
        
        // 2. 정수의 개수 만큼 정수 입력
        int[] num = new int[numCount];
        for(int i = 0; i < num.length; i++){
            num[i] = sc.nextInt(); // 정수 입력
        }
        
        // 3. 탐색하려는 정수 입력
        int findNum = sc.nextInt();
        
        // 4. 입력받은 정수들 중 탐색하려는 정수의 개수 파악
        int count = 0; // 정수 개수 파악한 결과를 담을 변수
        for(int i = 0; i < num.length; i++){
            if(num[i] == findNum){
                count++;
            }
        }
        
        System.out.println(count);
    }
}