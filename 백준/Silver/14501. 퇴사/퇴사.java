/*
1. N 입력
2. 상담 소요 기간, 상담 금액 입력
3. 최대 상담 금액 계산
4. 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        int[] term = new int[N]; // 상담 소요 기간
        int[] pay = new int[N]; // 상담 금액
        int[] totalPay = new int[N + 1]; // 총 상담 금액. 금액 계산 시 현재 탐색 위치의 이전 인덱스에 계산된 금액이 들어가기 때문에 N+1 크기의 배열을 선언.
        
        // 2. 상담 소요 기간, 상담 금액 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            term[i] = Integer.parseInt(st.nextToken()); // 상담 소요 기간 입력
            pay[i] = Integer.parseInt(st.nextToken()); // 상담 금액
        }
        
        // 3. 최대 상담 금액 계산
        // dp를 이용해 가장 마지막 인덱스부터 탐색하여 최대 상담 금액을 계산한다.
        int i = N - 1;
        while (i >= 0) {
            if (term[i] + i <= N) { // 상담 소요 기간 + 날짜(term[i] + i)가 상담 가능 날짜의 범위를 넘지 않은 경우
                totalPay[i] = Math.max(totalPay[i + 1], totalPay[term[i] + i] + pay[i]);
            }else{ // 상담 소요 기간 + 날짜(term[i] + i)가 상담 가능 날짜의 범위를 넘어선 경우
                totalPay[i] = totalPay[i + 1];
            }
            i--;
        }
    
        // 4. 출력
        System.out.println(totalPay[0]);
    }
}