/*
1. N, K 입력
2. 중량 증가량 입력
3. 2에서 입력받은 값을 바탕으로 중량이 500 이상이 되는 경우의 수 계산하여 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int[] weightList; // 중량 증가량을 담는 배열
    static boolean[] visited; // 방문 여부 파악하는 배열
    static int result; // 중량이 500 이상이 되는 경우의 수
    static int N; // 운동 키트 개수
    static int K; // 중량 감소량
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        result = 0;

        // 1. N, K 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        // 2. 중량 증가량 입력
        st = new StringTokenizer(br.readLine());
        weightList = new int[N];
        for(int i = 0; i < N; i++){
            weightList[i] = Integer.parseInt(st.nextToken());
        }


        // 3. 2에서 입력받은 값을 바탕으로 중량이 500 이상이 되는 경우의 수 계산하여 출력
        System.out.println(calc(500, 0));
    }

    // 중량이 500 이상이 되는 경우의 수를 구하는 메서드
    static int calc(int totalWeight, int count){
        // weightList의 값들의 모든 조합을 탐색하여 중량이 500 이상이 경우의 수를 찾아낸다.

        if(count == N){ // 모든 조건을 만족하여 하나의 운동 순서 조합이 하나의 경우의 수로 인정된 경우
            result++; // 경우의 수 +1
            return result;
        }

        for(int i = 0; i < N; i++){
            // 총 중량이 500 이상이고, 아직 탐색하지 않은 조합인 경우
            if ((totalWeight + weightList[i] - K) >= 500 && !visited[i]) {
                visited[i] = true; // 현재 인덱스 탐색          
                calc((totalWeight + weightList[i] - K), count + 1);
                visited[i] = false; // 현재 인덱스 탐색 초기화
            }
        }
        return result;
    }
}