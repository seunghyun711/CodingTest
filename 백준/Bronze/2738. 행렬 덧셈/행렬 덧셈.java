/*
1. 행렬의 크기 입력 (N M)
2. 행렬의 크기에 맞는 2차원 배열 2개 생성
3. 각 배열에 숫자 입력
4. 행렬의 합 계산
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1. 행렬의 크기 입력 (N M)
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 2. 행렬의 크기에 맞는 2차원 배열 2개 생성
        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];
        
        // 3. 각 배열에 숫자 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 4. 행렬의 합 계산
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(arr1[i][j] + arr2[i][j] + " ");
                
                if(j == M-1){
                    System.out.println();
                }
            }
        }
        
        
    }
}
