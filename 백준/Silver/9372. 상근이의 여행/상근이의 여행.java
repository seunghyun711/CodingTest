/*
1. 테스트 케이스 개수 입력
2. 국가의 수와 비행기 종류의 수 입력
3. 비행 경로 입력
4. 모든 국가가 연결된 최소의 간선 개수를 계산
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 1. 테스트 케이스 개수 입력
        int t = Integer.parseInt(br.readLine());
        
        // 2. 국가의 수와 비행기 종류의 수 입력
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            // 3. 비행 경로 입력
            for(int j = 0; j < M; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
            }
            // 4. 모든 국가가 연결된 최소의 간선 개수를 계산
            sb.append(N - 1).append("\n");
        }

        // 5. 결과 출력
        System.out.println(sb);
    }
}