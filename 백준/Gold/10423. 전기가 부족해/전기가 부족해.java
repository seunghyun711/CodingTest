/*
1. 도시의 개수(N), 설치 가능한 케이블의 수(M), 발전소의 개수(K)입력
2. 발전소가 설치된 도시의 개수 입력
3. 두 도시를 연결하는 케이블의 정보 입력
4. Kruskal 알고리즘을 통해 최소 비용 계산
    - 모든 노드의 부모 노드가 발전소 노드인 경우 모든 노드가 연결된 상태
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static class Node implements Comparable<Node>{
        int start; // 시작점
        int dest; // 도착점
        int cost; // 케이블 연결 비용
        
        public Node(int start, int dest, int cost){
            this.start = start;
            this.dest = dest;
            this.cost = cost;
        }
        
        // 케이블 연결 비용을 오름차순으로 정렬하기 위한 메서드 오버라이딩
        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }
    
    static int[] parent; // 부모 노드를 나타내는 배열
    static int N; // 도시의 개수
    static int M; // 설치 가능한 케이블의 수
    static int K; // 발전소의 개수
    static List<Node> list; // 도시와 발전소 리스트
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. 도시의 개수(N), 설치 가능한 케이블의 수(M), 발전소의 개수(K)입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 부모 노드 초기화
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
        
        // 2. 발전소가 설치된 도시의 개수 입력
        st = new StringTokenizer(br.readLine());
        // 발전소가 있는 노드는 -1로 설정
        for(int i = 0; i < K; i++){
            int balgeonso = Integer.parseInt(st.nextToken());
            parent[balgeonso] = -1;
        }
        
        // 3. 두 도시를 연결하는 케이블의 정보 입력
        Queue<Node> pq = new PriorityQueue<>();
        list = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken()); // 도시1
            int v = Integer.parseInt(st.nextToken()); // 도시2
            int w = Integer.parseInt(st.nextToken()); // 두 도시 간 케이블 설치 비용
            
            pq.add(new Node(u, v, w));
        }
        
        // 4. Kruskal 알고리즘을 통해 최소 비용 계산
        int totalCost = 0; // 최종 연결 비용
        while(!pq.isEmpty()){
            Node node = pq.poll();
            
            int s = find(node.start); // 시작점
            int d = find(node.dest); // 도착점
            
            if(s != d){
                totalCost += node.cost;
                union(node.start, node.dest);
                
                // 모든 노드의 부모 노드가 발전소 노드인 경우 모든 노드가 연결된 상태
                if(isConnected()){
                    break;
                }
            }
        }
        
        // 5. 결과 출력
        System.out.println(totalCost);
    }
    
    // 부모 노드를 찾는 메서드
    static int find(int x){
        if(parent[x] == -1){ // 해당 노드가 발전소에 연결된 경우 해당 부모 노드를 -1로 설정
            return -1;
        }
        
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    // 부모 노드 최신화 메서드
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x < y){
            parent[y] = x;
        }else {
            parent[x] = y;
        }
    }
    
    // 모든 도시가 발전소와 연결되었는지 파악하는 메서드
    static boolean isConnected(){
        for(int i = 1; i < parent.length; i++){
            if(parent[i] != -1){
                return false;
            }
        }
        
        return true;
    }
  
}