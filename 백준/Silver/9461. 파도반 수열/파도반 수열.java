/*
1. 테스트 케이스의 개수(T)입력
2. 테스트 케이스 개수 만큼 테스트 케이스를 입력하여 각 테스트 케이스의 P(N)을 구한다.
3. 결과 출력
*/
import java.io.*;
public class Main{
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 1. 테스트 케이스의 개수(T)입력
        int T = Integer.parseInt(br.readLine());
        
        // 2. 테스트 케이스 개수 만큼 테스트 케이스를 입력하여 각 테스트 케이스의 P(N)을 구한다.
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            long result = findPn(N); // N번째 삼각형의 한 변의 길이
            sb.append(result).append("\n");
        }
        
        // 3. 결과 출력
        System.out.print(sb);
        
    }
    
    // N번째 삼각형의 한 변의 길이를 구하는 메서드
    static long findPn(int N){
        dp = new long[N];

        if (N >= 3) { // N이 3 이상인 경우
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;

            // i번째 삼각형의 한 변의 길이 = dp[i-3] + [i-2]임을 이용한다.
            for(int i = 3; i < N; i++){
                dp[i] = dp[i - 3] + dp[i - 2];
            }
        }else { // N이 2 이하인 경우 1 리턴
            return 1;
        }

        return dp[N-1]; // N번째 삼각형의 한 변의 길이(0번째 인덱스 부터 시작하므로 -1을 한다.);

    }
}