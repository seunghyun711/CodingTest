/*
1. N 입력
2. 입력할 정수를 담을 N크기의 배열 생성
3. N개의 정수 입력
4. 배열 내 요소 오름차순으로 정렬(선택 정렬)
5. 정렬된 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 입력할 정수를 담을 N크기의 배열 생성
        int[] arr = new int[N];
        
        // 3. N개의 정수 입력
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        // 4. 배열 내 요소 오름차순으로 정렬(선택 정렬)
        for(int i = 0; i < N - 1; i++){
            int minIndex = i; // 최솟값 인덱스
            
            // 최솟값을 가진 인덱스 탐색
            for(int j = i+1; j < N; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            
            // 최솟값을 i번째 값과 교환
            swap(arr, minIndex, i);
        }
        
        // 5. 정렬된 결과 출력
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        
    }
    
    // 최솟값을 i번째 값과 교환하는 메서드
    static void swap(int[] arr, int minIndex, int i){
        int tmp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = tmp;
    }
}