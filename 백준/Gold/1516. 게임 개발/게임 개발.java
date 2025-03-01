/*
1. N 입력
2. 각 건물을 짓기 위한 시간과 먼저 지어야 하는 건물의 번호 입력
3. 위상정렬을 이용해 각 건물이 완성되기까지의 최소 시간 계산
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        int[] degree = new int[N + 1]; // 위상정렬에 사용하기 위한 진입차수
        int[] time = new int[N + 1]; // 건물을 짓는데 걸리는 시간(순수 소요 시간)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프
        
        // 위상정렬에 사용할 그래프를 2차원 리스트로 구현
        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        // 2. 각 건물을 짓기 위한 시간과 먼저 지어야 하는 건물의 번호 입력
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            
            time[i] = Integer.parseInt(st.nextToken());
            while(true){ // -1을 입력받을 때 까지 먼저 지어야 하는 건물의 번호 입력
                int num = Integer.parseInt(st.nextToken());
                if(num == -1){
                    break;
                }
                graph.get(num).add(i);
                degree[i]++; // 진입차수 설정
            }
        }
        
        // 3. 위상정렬을 이용해 각 건물이 완성되기까지의 최소 시간 계산
        int[] result = new int[N + 1]; // 각 건물이 지어지는데 걸리는 시간(최종 시간)
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i <= N; i++){
            // 진입차수가 0이면 해당 건물 번호를 큐에 삽입
            if(degree[i] == 0){ 
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int curNum = q.poll();
            
            for(int nextNum : graph.get(curNum)){
                degree[nextNum]--;
                
                // 다음에 지을 건물의 건설 시간 계산(선행 건물이 여러 개인 경우 그 중 가장 긴 시간까지 다 지나야 다음 건물을 지을 수 있음)
                result[nextNum] = Math.max(result[nextNum], result[curNum] + time[curNum]);
                
                if(degree[nextNum] == 0){
                    q.offer(nextNum);
                }
            }
        }
        for(int i = 1; i <= N; i++){
            sb.append(result[i] + time[i]).append("\n");
        }
        
        // 4. 결과 출력
        System.out.println(sb);
    }
}