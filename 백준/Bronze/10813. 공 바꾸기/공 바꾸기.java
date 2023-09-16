/*
1. 바구니 개수, 공을 바꿀 횟수를 입력
2. 각 바구니에 해당하는 번호의 공을 바구니에 넣기
3. 공을 바꾸는 횟수만큼 바구니에 있는 공 교체
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 1. 바구니 개수, 공을 바꿀 횟수를 입력
        int n = sc.nextInt(); // 바구니 개수
        int m = sc.nextInt(); // 공 교체 횟수
        
        int[] basket = new int[n]; // 바구니
        
        // 2. 각 바구니에 해당하는 번호의 공을 바구니에 넣기
        for(int i = 0; i < basket.length; i++){
            basket[i] = i+1;
        }
        
        // 3. 공을 바꾸는 횟수만큼 바구니에 있는 공 교체
        for(int k = 0; k < m; k++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            
            // tmp를 통해 i번 바구니와 j번 바구니에 있는 공을 교체
            int tmp = basket[i-1]; 
            basket[i-1] = basket[j-1];
            basket[j-1] = tmp;
        }
        
        for(int x = 0; x < basket.length; x++){
            System.out.print(basket[x] + " ");
        }
        
    }
}
