/*
1. 두 수 입력
2. 두 수의 관계 파악
    2-1. '첫 번째 수 % 두 번째 수'가 0이면 multiple
    2-2. '두 번쨰 수 % 첫 번째 수'가 0이면 factor
    2-3. 두 수를 나눈 나머지가 0이 아니면 neither
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 2. 두 수의 관계 파악
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            
            int first = Integer.parseInt(st.nextToken()); // 첫 번째 수
            int second = Integer.parseInt(st.nextToken()); // 두 번째 수
            
            if(first == 0 && second == 0){ // 두 수가 0이면 프로그램 종료
                break;
            }
            
            // 2-1. '첫 번째 수 % 두 번째 수'가 0이면 multiple
            if(first % second == 0){
                System.out.println("multiple");
            } 
            // 2-2. '두 번쨰 수 % 첫 번째 수'가 0이면 factor
            else if(second % first == 0){
                System.out.println("factor");
            }
            // 2-3. 두 수를 나눈 나머지가 0이 아니면 neither
            else{
                System.out.println("neither");
            }
        }
        
    }
}