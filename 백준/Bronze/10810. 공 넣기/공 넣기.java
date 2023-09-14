/*
1. 바구니 수(N), 공을 넣을 횟수(M) 입력
2. 공을 넣을 횟수 만큼 공을 넣음
3. 공을 담은 배열 출력
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 1. 바구니 수(N) 입력, 공을 넣을 횟수(M) 입력
        int n = sc.nextInt(); // 바구니 수
        int m = sc.nextInt(); // 공을 넣을 횟수
        
        // 2. 공을 넣을 횟수 만큼 공을 넣음
        int[] basket = new int[n]; // 공을 담을 배열
        
        int basketMin; // 바구니 범위(시작 범위)
        int basketMax; // 바구니 범위(끝 범위)
        int ballNum; // 공 번호
        for(int i = 0; i < m; i++){
            basketMin = sc.nextInt();
            basketMax = sc.nextInt();
            ballNum = sc.nextInt();
            
            // 설정한 바구니 범위 내에 ballNum번의 공 삽입
            for(int j = basketMin - 1; j < basketMax; j++){                
                basket[j] = ballNum;  
            }
           
        }
        
        // 3. 공을 담은 배열 출력
        for(int i = 0; i < basket.length; i++){
            System.out.print(basket[i] + " ");
        }
        
    }
}