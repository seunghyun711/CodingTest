/*
1. 테스트 케이스 개수 입력
2. 거스름돈 입력
3. 각 단위 별로 계산
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 테스트 케이스 개수 입력
        int t = Integer.parseInt(br.readLine());
        
        // 2. 거스름돈 입력
        for(int i = 0; i < t; i++){
            int c = Integer.parseInt(br.readLine()); // 거스름돈
            
            // 3. 각 단위 별로 계산
            int quater = c / 25; // 쿼터
            c %= 25;
            
            int dime = c / 10; // 다임
            c %= 10;
            
            int nickel = c / 5; // 니켈
            c %= 5;
            
            int penny = c; // 페니
            
            System.out.println(quater + " " + dime + " " + nickel + " " + penny);
        }
    }
}