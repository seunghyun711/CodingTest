/*
1. 주어진 성냥개비를 활용해 만들 수 있는 최솟값을 담은 dp 테이블 초기화
2. 테스트 케이스 개수 입력
3. 테스트 케이스 입력
4. 테스트 케이스 별 만들 수 있는 최댓값과 최솟값 계산
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static long[] minDp;
    static String[] sortedByAsc;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 필요한 성냥이 적은 숫자부터 오름차순 정렬한 배열(각 요소는 성냥으로 나타낼 숫자)
        sortedByAsc = new String[]{"1", "7", "4", "2", "0", "8"};

        // 1. 주어진 성냥개비를 활용해 만들 수 있는 최솟값을 담은 dp 테이블 초기화(2~7)
        minDp = new long[101];
        Arrays.fill(minDp, Long.MAX_VALUE);
        minDp[2] = 1;
        minDp[3] = 7;
        minDp[4] = 4;
        minDp[5] = 2;
        minDp[6] = 6;
        minDp[7] = 8;
        
        initDp();

        // 2. 테스트 케이스 개수 입력
        int tc = Integer.parseInt(br.readLine());

        // 3. 테스트 케이스 입력
        for(int i = 0; i < tc; i++){
            int n = Integer.parseInt(br.readLine());
            // 4. 테스트 케이스 별 만들 수 있는 최댓값과 최솟값 계산
            long min = minDp[n]; // 최솟값
            String max = calcMax(n); // 최댓값

            // 5. 결과 출력
            System.out.println(min + " " + max);
        }
    }
    
    // dp 테이블을 초기화하는 메서드
    static void initDp(){
        for(int i = 8; i <= 100; i++){
            for(int j = 2; j <= 7; j++){
                if(minDp[i-j] != Long.MAX_VALUE){
                    String tmp = "" + minDp[i - j] + sortedByAsc[j - 2];
                    minDp[i] = Math.min(Long.parseLong(tmp), minDp[i]);
                }
            }
        }
    }

    // 최댓값을 구하는 메서드
    static String calcMax(int n){
        StringBuilder sb = new StringBuilder();
        // 최댓값은 n이 짝수인 경우 n / 2를 하여 해당 몫의 자리수만큼 1을 채워넣는다.(2로 숫자를 만들때 가장 적게 드는 성냥의 개수가 2)
        if(n % 2 == 0){
            int div = n / 2;
            for(int i = 0; i < div; i++){
                sb.append("1");
            }
            return sb.toString();
        }else{
            int div = n / 2;
            sb.append("7");
            for(int i = 0; i < div - 1; i++){
                sb.append("1");
            }
            return sb.toString();
        }
    }
}