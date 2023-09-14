/*.
1. 3개의 눈 입력
2. 같은 눈 3개가 나오면 상금 = 10,000원+(같은 눈)×1,000원
3. 같은 눈 2개가 나오면 상금 = 1,000원+(같은 눈)×100원
    3-1. num1==num2인 경우 
    3-2. num2==num3인 경우
    3-3. num1==num3인 경우
4. 모두 다른 눈이 나오면 상금 = (그 중 가장 큰 눈)×100원
*/
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 1. 3개의 눈 입력
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        
        int result; // 상금
        
        // 2. 같은 눈 3개가 나오면 상금 = 10,000원+(같은 눈)×1,000원
        if((num1 == num2) && (num1 == num3)){
            result = 10000 + num1 * 1000;
        }
        
        // 3. 같은 눈 2개가 나오면 상금 = 1,000원+(같은 눈)×100원
        // 3-1 / 3-3의 경우
        else if(((num1 == num2) && (num1 != num3)) || ((num1 != num2) && (num1 == num3))){
            result = 1000 + num1 * 100;         
        }
        
        // 3-2. num2==num3인 경우
        else if((num1 != num2) && (num2 == num3)){
            result = 1000 + num2 * 100;
        }
        
        // 4. 모두 다른 눈이 나오면 상금 = (그 중 가장 큰 눈)×100원
        else {
            if((num1 >= num2) && (num1 >= num3)){
                result = num1 * 100;
            }else if((num2 >= num1) && (num2 >= num3)){
                result = num2 * 100;
            }else{
                result = num3 * 100;
            }
        }
        System.out.println(result);
    }
}