/*
1. 기준 개수를 저장
2. 피스의 개수 입력
3. 각 피스의 개수 차이 계산하여 출력
* 인덱스 0부터 킹, 퀸, 룩, 비숍, 나이트, 폰 순서
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 기준 개수를 저장
        int[] standard = {1,1,2,2,2,8}; // 기준 피스 개수
        
        // 2. 피스의 개수 입력
        int[] result = new int[6]; // 결과를 담을 배열
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 3. 각 피스의 개수 차이 계산하여 출력
        result[0] = standard[0] - Integer.parseInt(st.nextToken());
        result[1] = standard[1] - Integer.parseInt(st.nextToken());
        result[2] = standard[2] - Integer.parseInt(st.nextToken());
        result[3] = standard[3] - Integer.parseInt(st.nextToken());
        result[4] = standard[4] - Integer.parseInt(st.nextToken());
        result[5] = standard[5] - Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < 6; i++){
            System.out.print(result[i] + " ");
        }
    }
}