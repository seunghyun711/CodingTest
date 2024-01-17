/*
1. N, M 입력
2. N개의 카드 중 3장의 카드를 선택
3. 3개의 카드의 합 == M이면 3개의 카드의 합 리턴 및 종료
4. 3개의 카드의 합이 이전에 계산한 합보다 크고, M보다 작을 경우 카드의 합 갱신
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N]; // 선택한 3개의 카드를 담을 배열

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // findSum()메서드를 통해 3개의 카드의 합 계산
        int result = findSum(arr, N, M);
        System.out.println(result);
    }

    public static int findSum(int[] arr, int N, int M){
        int result = 0;
        // 2. N개의 카드 중 3장의 카드를 선택

        // 첫 번째 카드 선택 - 이 이후에 2장을 더 뽑아야 하기 때문에 N-2까지 순회
        for(int i = 0; i < N-2; i++){
            // 첫 번째 카드가 M보다 크면 다음 카드 탐색
            if(arr[i] > M){
                continue;
            }
            // 두 번째 카드 선택 - 이 이후에 1장을 더 뽑아야 하기 떄문에 N-1까지 순회
            for(int j = i+1; j < N-1; j++){
                // 첫 번째 카드 + 두 번째 카드 > M인 경우 다음 카드 탐색
                if((arr[i] + arr[j]) > M){
                    continue;
                }
                // 세 번째 카드 선택
                for(int k = j+1; k < N; k++){
                    int tempResult = arr[i] + arr[j] + arr[k]; // 세 장의 카드의 합

                    // 3. 3개의 카드의 합 == M이면 3개의 카드의 합 리턴 및 종료
                    if(M == tempResult){
                        return tempResult;
                    }

                    // 4. 3개의 카드의 합이 이전에 계산한 합보다 크고, M보다 작을 경우 카드의 합 갱신
                    if(result < tempResult && tempResult < M){
                        result = tempResult;
                    }
                }
            }
        }
        return result;
    }
}