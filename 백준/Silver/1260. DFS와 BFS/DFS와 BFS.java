/*
1. 정점의 개수(N), 간선의 개수(M), 탐색을 시작할 정점의 번호(V)입력
2. 간선이 연결하는 정점의 번호 입력
3. dfs를 이용해 결과 출력
4. bfs를 이용해 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static boolean[] visited; // 방문 파악하는 배열
    static int[][] list; // 정점 간의 연결 상태를 나타내는 2차원 배열
    static Queue<Integer> q; // bfs를 사용하기 위한 큐
    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int V; // 탐색을 시작할 정점의 번호
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. 정점의 개수(N), 간선의 개수(M), 탐색을 시작할 정점의 번호(V)입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
        
        visited = new boolean[N + 1];
        list = new int[N + 1][N + 1];
        
        // 2. 간선이 연결하는 정점의 번호 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            
            // 정점 연결
            list[v1][v2] = 1;
            list[v2][v1] = 1;
        }
        
        // 3. dfs를 이용해 결과 출력
        dfs(V);
        System.out.println();
        Arrays.fill(visited, false); // bfs를 하기 위해 visited배열 false로 초기화
        // 4. bfs를 이용해 결과 출력
        bfs(V);
    }
    
    // dfs
    static void dfs(int V){
        visited[V] = true;
        System.out.print(V + " ");
        
        for(int i = 1; i <= N; i++){
            if(list[V][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
    
    // bfs
    static void bfs(int V){
        q = new LinkedList<>();
        q.add(V);
        visited[V] = true;
        System.out.print(V + " ");
        
        while(!q.isEmpty()){
            int node = q.poll(); // 큐에 담긴 노드의 번호
            
            for(int i = 1; i <= N; i++){
                if(list[node][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}