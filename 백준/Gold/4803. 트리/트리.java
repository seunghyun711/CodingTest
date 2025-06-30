/*
1. n, m 입력
2. 간선을 나타내는 두 정수 입력
3. 트리 여부 탐색
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int tc = 1; // 테스트 케이스 번호
        while(true){
            // 1. n, m 입력
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 정점의 개수
            int m = Integer.parseInt(st.nextToken()); // 간선의 개수
            
            if (n == 0 && m == 0) { // 정점 및 간선의 개수가 0인 경우 종료
                break;
            }
            
            graph = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
            }
            // 2. 간선을 나타내는 두 정수 입력
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }
            visited = new boolean[n + 1];
            
            // 3. 트리 여부 탐색
            int trees = 0; // 트리의 수
            for(int i = 1; i <= n; i++){
                if(!visited[i]){ // 아직 방문하지 않은 노드인 경우 bfs를 통해 트리 여부 파악
                    if(bfs(i)){
                        trees++;
                    }
                }
            }
            // 트리 개수에 따른 결과 
            if(trees == 0){
                sb.append("Case ").append(tc++).append(": No trees.");
            } else if (trees == 1) {
                sb.append("Case ").append(tc++).append(": There is one tree.");
            } else {
                sb.append("Case ").append(tc++).append(": A forest of ").append(trees).append(" trees.");
            }
            sb.append("\n");
        }
        
        // 4. 결과 출력
        System.out.println(sb);
    }
    
    // 트리 여부 탐색 bfs
    static boolean bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        int vertex = 0; // 정점의 개수
        int lines = 0; // 간선의 개수
        
        while(!q.isEmpty()){
            int cur = q.poll();
            if(visited[cur]){ // 이미 방문한 노드는 넘어감
                continue;
            }
            visited[cur] = true;
            vertex++;
            
            for(int next : graph.get(cur)){
                lines++;
                if(!visited[next]){
                    q.add(next);
                }
            }
        }
        // 트리여부 파악
        if(2 * (vertex - 1) == lines){ // 노드 간 간선을 구성할 때 양방향으로 구성했기 떄문에 현재 간선의 수가 기존 트리의 간선의 수*2이므로 이를 적용하여 계산한다.   
            return true;
        }else{
            return false;
        }
    }
}