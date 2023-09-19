/*
1. 바구니 개수와 바구니 순서를 바꾸는 횟수를 입력
2. 바구니 배열에 1부터 n까지 숫자 삽입
3. 순서를 바꾸는 횟수만큼 바구니의 범위를 지정하여 바구니 순서를 변경
4. 바구니 순서를 바꾸는 시작점은 1씩 증가하면서, 끝점은 1씩 감소하면서 바구니의 순서 변경
*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //1. 바구니 개수와 바구니 순서를 바꾸는 횟수를 입력
        int n = sc.nextInt(); // 바구니 개수
        int m = sc.nextInt(); // 바구니 순서를 바꾸는 횟수
        
        int[] basket = new int[n];
        
        // 2. 바구니 배열에 1부터 n까지 숫자 삽입
        for(int i = 0; i < basket.length; i++){
            basket[i] = i+1;
        }
        
        // 3. 순서를 바꾸는 횟수만큼 바구니의 범위를 지정하여 바구니 순서를 변경
        for(int i = 0; i < m; i++){
            // basketMin과 basketMax에 -1을 하는 이유는 배열이 0부터 시작하기 때문에 배열에 맞추기 위해서다.
            int basketMin = sc.nextInt()-1; // 바구니 순서를 바꾸는 시작 범위
            int basketMax = sc.nextInt()-1; // 바구니 순서를 바꾸는 끝 범위
            
            // 4. 바구니 순서를 바꾸는 시작점은 1씩 증가하면서, 끝점은 1씩 감소하면서 바구니의 순서 변경
            while(basketMin < basketMax){          
                int tmp = basket[basketMin];
                basket[basketMin] = basket[basketMax];
                basket[basketMax] = tmp; 
                
                basketMin++;
                basketMax--;
                
            }
        }
        
        for(int i = 0; i < basket.length; i++){
            System.out.print(basket[i] + " ");
        }
        
    }
}