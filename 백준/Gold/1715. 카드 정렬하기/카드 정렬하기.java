/*
1. N 입력
2. 숫자 카드 묶음의 개수 입력 및 해당 입력 결과를 우선순위 큐에 삽입
3. 2번에서 입력받은 카드 묶음의개수가 적은 것부터 비교횟수 계산
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> pq = new PriorityQueue<>();
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 숫자 카드 묶음의 개수 입력 및 해당 입력 결과를 우선순위 큐에 삽입
        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        
        // 3. 2번에서 입력받은 카드 묶음의개수가 적은 것부터 비교횟수 계산
        int count = 0;
       
        while (pq.size() > 1){ // 두 개 이상인 경우에만 묶음 비교 가능
            // 큐에서 두 개의 수를 꺼내서 계산
            int n1 = pq.poll();
            int n2 = pq.poll();
            
            count += n1 + n2;
            // n1 + n2를 큐에 삽입
            pq.add(n1 + n2);
        }
        
        // 4. 결과 출력
        System.out.println(count);
    }
}