/*
1. 크기가 5인 정수 배열 선언
2. 5개의 자연수 입력. 입력한 자연수는 1번에서 선언한 배열에 저장
3. 정수 배열 정렬(선택 정렬)
4. 정수의 평균 계산 & 출력
5. 배열의 중간값(2번 인덱스) 출력
*/
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 크기가 5인 정수 배열 선언
        int[] arr = new int[5];
        
        int sum = 0; // 배열 내 정수의 합을 담을 변수
        
        // 2. 5개의 자연수 입력. 입력한 자연수는 1번에서 선언한 배열에 저장
        for(int i = 0; i < 5; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i]; // 정수의 합 계산
        }
        
        // 3. 정수 배열 정렬
        for(int i = 0; i < arr.length-1; i++){
            int minIndex = i; // 최솟값이 있는 인덱스
            
            // 최솟값을 가진 인덱스 탐색
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            
            // 최솟값을 i번째 값과 교환
            swap(arr, minIndex, i);
        }
        // 4. 정수의 평균 계산 & 출력
        int avg = sum / 5;
        System.out.println(avg);
        
        // 5. 배열의 중간값(2번 인덱스) 출력
        System.out.println(arr[2]);
    }
    // 최솟값을 i번째 값과 교환하는 메서드
    static void swap(int[] arr, int minIndex, int i){
        int tmp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = tmp;
    }
}