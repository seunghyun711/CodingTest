/*
1. 총 금액과 구매 물건의 종류 개수 입력
2. 구매 물건의 종류 개수 만큼 물품의 가격과 구매 개수 입력
3. 총 합계 금액이 처음에 입력한 총 금액과 같으면 Yes, 다르면 No를 출력
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 1. 총 금액과 구매 물건의 종류 개수 입력
        int totalPrice = sc.nextInt(); // 총 금액
        int priceCount = sc.nextInt(); // 구매한 물건의 종류 개수
        
        // 2. 구매 물건의 종류 개수 만큼 물품의 가격과 구매 개수 입력
        int result = 0; // 총 계산 금액
        int price; // 물건 가격
        int count; // 물건 구매 개수
        for(int i = 0; i < priceCount; i++){
            price = sc.nextInt();
            count = sc.nextInt();
            result += price * count;
        }
        
        // 3. 총 합계 금액이 처음에 입력한 총 금액과 같으면 Yes, 다르면 No를 출력
        if(totalPrice == result){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        
    
    }
}