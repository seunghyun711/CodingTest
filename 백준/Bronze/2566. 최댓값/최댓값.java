/*
1. 9*9 크기의 2차원 배열 생성
2. 2차원 배열에 숫자 입력
3. 2차원 배열을 순회하면서 배열 내 요소 크기 비교
4. 가장 큰 값과 그 값이 있는 위치 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int max = 0; // 최댓값
        int row = 0; // 행
        int col = 0; // 열
        
        // 1. 9*9 크기의 2차원 배열 생성
        int[][] arr = new int[9][9];
        
        // 2. 2차원 배열에 숫자 입력
        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 3. 2차원 배열을 순회하면서 배열 내 요소 크기 비교
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(max <= arr[i][j]){
                    max = arr[i][j];
                    // 배열의 인덱스는 0부터 시작이므로 행과 열에 +1을 한다.
                    row = i+1; 
                    col = j+1;
                }
            }
        }
        
        // 4. 가장 큰 값과 그 값이 있는 위치 출력
        System.out.println(max);
        System.out.println(row + " " + col);
 
    }
}