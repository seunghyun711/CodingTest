/*
1. N, M 입력
2. N*M 크기의 2차원 배열 생성
3. 배열 입력
4. 8*8 크기로 자르기 때문에 입력받은 배열에서 8*8 크기로 자를 수 있는 경우의 수 만큼 다시 칠해야 하는 정사각형으의 개수를 구함
*/
import java.io.*;
import java.util.*;
public class Main{
    public static boolean[][] arr; // N*M크기의 배열을 담을 2차원 배열
    public static int min = 64; // 최소 변경 수
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1. N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 2. N*M 크기의 2차원 배열 생성
        arr = new boolean[N][M];
        
        // 3. 배열 입력
        for(int i = 0; i < N; i++){
            String color = br.readLine();
            for(int j = 0; j < M; j++){
                if(color.charAt(j) == 'W'){// W인 경우 true
                    arr[i][j] = true;
                }else{
                    arr[i][j] = false; // B인 경우 false
                }
            }
        }
        // 4. 8*8 크기로 자르기 때문에 입력받은 배열에서 8*8 크기로 자를 수 있는 경우의 수 만큼 다시 칠해야 하는 정사각형으의 개수를 구함
        /*
        N,M이 각각 10,10 인 경우 8*8을 자르게 되었을 때 가능한 시작 좌표는
        (0,0), (0,1), (0,2), (1,0), (1,1), (1,2), (2,0), (2,1), (2,2)이다.
        따라서 경우의 수는 (N-7) * (M-7)이라 할 수 있다.
        */
        int caseN = N - 7;
        int caseM = M - 7;
        
        for(int i = 0; i < caseN; i++){
            for(int j = 0; j < caseM; j++){
                calculation(i, j); // 새로 칠해야 하는 정사각형의 최소 개수 계산
            }
        }
        System.out.println(min);
    }
    
    public static void calculation(int x, int y){
        int endX = x + 8; // 마지막 x좌표
        int endY = y + 8; // 마지막 y좌표
        int count = 0; // 칠해야 하는 정사각형의 개수
        
        boolean firstColor = arr[x][y]; // 첫 번째 정사각형의 색깔
        
        for(int i = x; i < endX; i++){
            for(int j = y; j < endY; j++){
                // 첫 번째 정사각형의 색깔과 현재 위치의 정사각형의 색깔이 다른 경우 count + 1
                if(arr[i][j] != firstColor){
                    count++;
                }
                // 다음 정사각형의 색이 바뀌므로 firstColor의 색을 변경한다.
                firstColor = !firstColor;
            }
            firstColor = !firstColor;
        }
        /*
        첫 번째 칸의 색을 기준으로 색이 변경되는 수와 첫 번째 칸의 색의 반대 색을 기준으로 색이 변경되는 수를
        비교하여 최소값을 count에 저장
        */
        count = Math.min(count, 64-count);
        
        // 최소값 갱신
        min = Math.min(min, count);
    }
}