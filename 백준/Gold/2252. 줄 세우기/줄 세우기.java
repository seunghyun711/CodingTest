/*
1. N, M 입력
2. 학생의 번호를 리스트에 저장
3. 학생의 번호 정렬 -> 위상정렬 사용
4. 결과 출력
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
        
        int[] degree = new int[N + 1]; // 위상정렬에 사용하기 위한 진입차수
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프
        
        // 위상정렬에 사용할 그래프를 2차원 리스트로 구현
        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        // 2. 학생의 번호를 리스트에 저장
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken()); // 앞번호
            int rear = Integer.parseInt(st.nextToken()); // 뒷번호
            
            graph.get(front).add(rear);
            degree[rear]++; // 진입차수 설정
        }
        
        Queue<Integer> q = new LinkedList<>(); // 위상정렬에 사용할 큐
        
        // 진입차수가 0이면 해당 학생 번호(노드)를 큐에 삽입
        for(int i = 1; i < degree.length; i++){
            if(degree[i] == 0){
                q.offer(i);
            }
        }
        
        // 3. 학생의 번호 정렬 -> 위상정렬 사용
        while(!q.isEmpty()){
            // 큐에서 학생 번호 추출
            int studentNum = q.poll();
            
            // 큐에서 추출한 학생 번호를 정렬 결과값에 저장
            sb.append(studentNum + " ");
            
            // 꺼낸 학생 번호의 인접 학생 번호 탐색
            List<Integer> list = graph.get(studentNum); // 꺼낸 학생 번호를 선행 조건으로 가진 학생 번호들의 리스트
            
            // 큐에서 꺼낸 학생 번호를 선행 조건으로 가진 학생 번호의 진입차수를 갱신
            for(int i = 0; i < list.size(); i++){
                degree[list.get(i)]--; // 선행 노드가 사라졌으니까 기존 진입차수에 -1을 한다.
                
                // 갱신된 진입차수가 0인 학생 번호를 큐에 추가
                if(degree[list.get(i)] == 0){
                    q.offer(list.get(i));
                }
            }
        }
        // 4. 결과 출력
        System.out.println(sb);
    }
}