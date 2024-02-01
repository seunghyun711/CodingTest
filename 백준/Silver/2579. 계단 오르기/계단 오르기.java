/*
1. 계단의 숫자를 담을 배열 선언
2. 각 계단까지의 최대값을 담을 배열 선언
3. 계단 수 입력
4. 각 계단의 숫자 입력
5. n개 계단이 있을 때 n까지 올라갈 수 있는 경우의 수를 계산
    5-1. n-3, n-1, n 으로 올라간 경우
    5-2. n-2, n으로 올라간 경우
계단의 최상단을 n이라고 가정하면 n까지 올라갈 수 있는 방법은 크게 두 가지가 있다.
1.최상단 직전이 바로 아래에 있는 계단인 경우 (n-3, n-1, n)
- 3칸이 연속해서 올라가면 안되기 때문에 n-3까지 최대 계단의 합을 구하고,
  이후부터는 연속되지 않기 때문에 n-1번 계단의 수와 n번 계단의 수를 더한다.
2. 최상단 직전이 두 칸 아래에 있는 계단인 경우(n-2, n)
- n-2칸 까지의 최대값을 구하고 이후 한 칸을 건너뛰기 때문에 n번 계단의 수를 더한다.
*/
import java.io.*;
public class Main{
    // 1. 계단의 숫자를 담을 배열 선언
    static int[] num;
    // 2. 각 계단까지의 최대값을 담을 배열 선언
    static Integer[] maxArr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 3. 계단 수 입력
        int n = Integer.parseInt(br.readLine());
        
        num = new int[n + 1];
        maxArr = new Integer[n+1];
        
        // 4. 각 계단의 숫자 입력
        for(int i = 1; i <= n; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        
        maxArr[0] = num[0] = 0;
        maxArr[1] = num[1];
        
        if(n >= 2){
            maxArr[2] = num[1] + num[2]; // 2번째 계단의 최대값은 첫 번째 계단 수 + 두 번째 계단 수
        }
        System.out.println(stair(n));
    }
    
    static int stair(int n){
        // 탐색하지 않은 위치는 null이므로 maxArr의 현재위치가 null이면 탐색
        if(maxArr[n] == null){
            // 5. n개 계단이 있을 때 n까지 올라갈 수 있는 경우의 수를 계산
            // 5-1. n-3, n-1, n 으로 올라간 경우
            // 5-2. n-2, n으로 올라간 경우
            maxArr[n] = Math.max(stair(n-2), stair(n-3) + num[n-1]) + num[n];
        }
        return maxArr[n];
    }
}