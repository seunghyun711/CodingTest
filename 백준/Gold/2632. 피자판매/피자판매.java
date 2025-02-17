/*
1. 구매하고자 하는 피자의 크기 입력
2. A, B의 피자 조각 개수 입력
3. 각 피자의 조각 개수 입력
4. A피자만을 이용한 경우의 수와 B피자만을 이용한 경우의 수 계산
5. A,B 피자 모두 사용한 경우의 수 계산
6. 4번과 5번의 결과를 바탕으로 최종 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int[] countA;
    static int[] countB;
    static int size;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; 
        
        // 1. 구매하고자 하는 피자의 크기 입력
        size = Integer.parseInt(br.readLine());
        
        // 2. A, B의 피자 조각 개수 입력
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // A 피자
        int n = Integer.parseInt(st.nextToken()); // B 피자
        
        // 3. 각 피자의 조각 개수 입력
        int[] A = new int[m * 2 + 1]; // 피자는 원형이므로 배열의 처음과 끝이 이어질 수 있게 각 조각의 크기를 두 번씩 저장한다.
        int[] B = new int[n * 2 + 1];
        
        for(int i = 1; i <= m; i++){
            A[i] = Integer.parseInt(br.readLine());
            A[i + m] = A[i];
        }
        
        for(int i = 1; i <= n; i++){
            B[i] = Integer.parseInt(br.readLine());
            B[i + n] = B[i];
        }
        
        // 4. A피자만을 이용한 경우의 수와 B피자만을 이용한 경우의 수 계산
        int[] sumA = new int[m * 2 + 1]; // A의 누적합 배열
        sumA[1] = A[1];
        for(int i = 2; i <= m * 2; i++){
            sumA[i] = sumA[i - 1] + A[i];
        }
        
        int[] sumB = new int[n * 2 + 1]; // B의 누적합 배열
        sumB[1] = B[1];
        for(int i = 2; i <= n * 2; i++){
            sumB[i] = sumB[i - 1] + B[i];
        }
        
        // 4. A피자만을 이용한 경우의 수와 B피자만을 이용한 경우의 수 계산
        int result = 0;
        countA = new int[size + 1];
        findCount(countA, sumA, m);
        result += countA[size];
        
        countB = new int[size + 1];
        findCount(countB, sumB, n);
        result += countB[size];
        
        // 5. A,B 피자 모두 사용한 경우의 수 계산
        for(int i = 1; i < size; i++){
            int a = i;
            int b = size - i;
            result += countA[a] * countB[b];
        }
        
        // 6. 4번과 5번의 결과를 바탕으로 최종 결과 출력
        System.out.println(result);
    }
    
    static void findCount(int[] count, int[] sum, int jogack){
        for(int i = 1; i < jogack; i++){ // 선택할 피자 조각의 개수
            for(int j = 1; j <= jogack; j++){ // 몇번째 조각부터?
                int num = sum[j + i - 1] - sum[j - 1];
                if(num > size){ // 목표 크기보다 큰 경우 넘어감
                    continue;
                }
                count[num]++;
            }
        }
        if(sum[jogack] <= size){
            count[sum[jogack]]++;
        }
    }
}