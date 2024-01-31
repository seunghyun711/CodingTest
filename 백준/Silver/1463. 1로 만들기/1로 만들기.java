/*
1. N 입력
2. N + 1 크기의 배열 선언(N번 인덱스는 N의 최소 계산 횟수가 저장됨)
3. N이 나눠지는 조건에 따라 계산하여 최소 횟수를 배열에 저장
    3-1. N이 2와 3의 최소공배수(6)인 경우
    3-2. N이 3의 배수인 경우
    3-3. N이 2의 배수인 경우 
    3-4. N이 2와 3으로 나누어 떨어지지 않는 경우
*/
import java.io.*;
public class Main{
    /*
    재귀문을 수행할 때 기본형 int를 쓰면 전체 배열 내 요소가 0으로 초기화되는데,
    arr[0],arr[1]일 때도 0이기 때문에 재귀문 수행 시 오류 발생 가능
    따라서 래퍼클래스인 Integer로 배열을 선언해서 배열 내 요소를 null로 초기화하여
    arr[0], arr[1]과 구분한다.
    */
    static Integer[] arr; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. N + 1 크기의 배열 선언(N번 인덱스는 N의 최소 계산 횟수가 저장됨)
        arr = new Integer[N+1];
        arr[0] = arr[1] = 0; // N이 0,1인 경우 계산 횟수는 0
        
        System.out.println(recur(N));
    }
    // 3. N이 나눠지는 조건에 따라 계산하여 최소 횟수를 배열에 저장
    static int recur(int N){
        if(arr[N] == null){
            // 3-1. N이 2와 3의 최소공배수(6)인 경우
            if(N % 6 == 0){
                // N-1을 한 경우와 N/3, N/2를 한 경우에서 최소값을 구함
                arr[N] = Math.min(recur(N-1), Math.min(recur(N/3), recur(N/2))) + 1;
            }
            // 3-2. N이 3의 배수인 경우
            else if(N % 3 == 0){
                // N-1을 한 경우와, N/3을 한 경우에서 최소값을 구함
                arr[N] = Math.min(recur(N/3), recur(N-1)) + 1;
            }
            // 3-3. N이 2의 배수인 경우 
            else if(N % 2 == 0){
                // N-1을 한 경우와 N/2를 한 경우에서 최소값을 구함
                arr[N] = Math.min(recur(N/2), recur(N-1)) + 1;
            }
            // 3-4. N이 2와 3으로 나누어 떨어지지 않는 경우
            else{
                arr[N] = recur(N-1) + 1;
            }
        }
        return arr[N];
    }
}