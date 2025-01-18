/*
1. N, M 입력
2. 문제 번호 순서쌍 입력
3. 위상 정렬을 통해 먼저 풀 문제 순서로 정렬(우선순위 큐 이용)
4. 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 1. N, M 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] degree = new int[N + 1]; // 위상 정렬에 사용될 진입 차수 배열
        // 위상정렬에 사용할 그래프를 2차원 리스트로 구현
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        // 2. 문제 번호 순서쌍 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken()); // 앞번호
            int rear = Integer.parseInt(st.nextToken()); // 뒷번호
            
            graph.get(front).add(rear);
            degree[rear]++;
        }
        
        // 3. 위상 정렬을 통해 먼저 풀 문제 순서로 정렬(우선순위 큐 이용)
        Queue<Integer> pq = new PriorityQueue<>();
        
        // 진입차수가 0인 경우 큐에 해당 번호의 순서쌍을 큐에 삽입
        for(int i = 1; i < degree.length; i++){
            if(degree[i] == 0){
                pq.add(i);
            }
        }
        
        while(!pq.isEmpty()){
            // 큐에서 문제 번호 추출
            int num = pq.poll();
            
            // 큐에서 추출한 번호 쌍 출력
            sb.append(num).append(" ");
            
            // 꺼낸 순서쌍의 두 번째 문제(우선순위가 낮은 문저)의 번호를 선행 조건으로 가진 번호 리스트 기반으로 탐색
            List<Integer> list = graph.get(num);
            
            // 꺼낸 문제 번호를 선행 조건으로 가진 문제 번호의 진입차수 최신화
            for(int i = 0; i < list.size(); i++){
                degree[list.get(i)]--; // 선행 문제가 사라졌으므로 현재 진입차수를 차감한다.
                
                // 진입차수 최신화 후 진입차수가 0인 순서쌍을 큐에 삽입
                if(degree[list.get(i)] == 0){
                    pq.add(list.get(i));
                }
            }
        }
        
        // 4. 출력
        System.out.println(sb);
    }
}