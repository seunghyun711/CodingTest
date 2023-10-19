/*
1. 2차원 배열 생성 [101][101]
2. 색종이의 개수 및 색종이 위치 입력
3. 색종이가 있는 범위 만큼 2차원 배열에 표시(범위 : x,y ~ x+9, y+9)
    3-1. 색종이가 없는 인덱스는 false, 있는 인덱스는 true
4. 인덱스의 요소가 true인 개수가 색종이의 넓이
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 2차원 배열 생성 [100][100]
        boolean[][] arr = new boolean[100][100];
        
        int area = 0; // 색종이의 넓이
        
        // 2. 색종이의 개수 및 색종이 위치 입력
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x좌표
            int y = Integer.parseInt(st.nextToken()); // y좌표
            
            // 3. 색종이가 있는 범위 만큼 2차원 배열에 표시(범위 : x,y ~ x+9, y+9)
            for(int j = x; j < x+10; j++){
                for(int k = y; k < y+10; k++){
                    // 3-1. 색종이가 없는 인덱스는 false, 있는 인덱스는 true
                    if(!arr[j][k]){
                        arr[j][k] = true;
                        area++;
                    }
                }
            }
        }
        System.out.println(area);
    }
}
