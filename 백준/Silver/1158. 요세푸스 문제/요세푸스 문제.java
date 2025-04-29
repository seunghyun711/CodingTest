/*
1. N, K 입력
2. 큐에 1~N 까지의 수를 저장
3. K번째 요소가 나올 때까지 큐의 요소를 뒤로 보냄
4. K번째 요소가 큐의 가장 앞에 나오면 해당 요소 큐에서 삭제
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 1. N, K 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 2. 큐에 1~N 까지의 수를 저장
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            q.add(i);
        }
               
        sb.append("<");
        while(q.size() > 1) { // 마지막 요소 출력일 때를 구분
            // 3. K번째 요소가 나올 때까지 큐의 요소를 뒤로 보냄
            for(int i = 0; i < K - 1; i++){
                q.add(q.poll());
            }
            // 4. K번째 요소가 큐의 가장 앞에 나오면 해당 요소 큐에서 삭제
            sb.append(q.poll()).append(", ");
        } 
        
        // 마지막 요소 출력
        sb.append(q.poll()).append(">");
        
        // 5. 결과 출력
        System.out.println(sb);
    }
}