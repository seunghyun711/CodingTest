/*
1. M 입력
2. 피보나치 수열 실행, 출력
*/
import java.io.*;
public class Main{
    static int[] fiboLength; // 각 문자열의 길이를 담을 배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. M 입력
        int M = Integer.parseInt(br.readLine());

        fiboLength = new int[50]; // M의 최댓값인 1073741823는 피보나치 수열에서 40번째임 따라서 해당 값까지 충분히 담을 수 있도록 선언
        fiboLength[1] = 5;
        fiboLength[2] = 13;
        
        // 피보나치 수열에 따라 각 문자열의 길이 저장
        int index = 2;
        while(fiboLength[index] < M){
            index++;
            fiboLength[index] = fiboLength[index - 1] + fiboLength[index - 2] + 1; // 1은 공백
        }
        
        // 2. 피보나치 수열 실행, 출력
        char result = fibo(M, index);
        if(result == ' '){ // 추출한 문자가 공백인 경우
            System.out.println("Messi Messi Gimossi");
        }else{
            System.out.println(result);
        }
    }
    
    // 피보나치 메서드
    static char fibo(int M, int index){
        if(index == 1){
            return "Messi".charAt(M - 1);
        }else if(index == 2){
            return "Messi Gimossi".charAt(M - 1);
        }
        
        if(M <= fiboLength[index - 1]){ // M이 이전 피보나치 문자열(messi(N-1))에 속하는 경우
            return fibo(M, index - 1);
        }else if(M == fiboLength[index - 1] + 1){ // M 번째 문자가 공백인 경우 
            return ' ';
        }else{ // M 번째 문자가 전전 문자열에 속하는 경우(messi(N-2))
            return fibo(M - fiboLength[index - 1] - 1, index - 2);
        }
    }
}