/*
1. N 입력
2. 컴퓨터 입력
3. Kruskal 알고리즘을 이용해 기부할 수 있는 랜선의 길이 계산
*/
import java.io.*;
import java.util.*;
public class Main{
    static class Node implements Comparable<Node>{ // 간선으로 연결된 정점과 그 가중치(랜선의 길이)가 있는 객체
        int start; // 출발 정점
        int dest; // 목적지 정점
        int length; // 랜선의 길이
        
        public Node(int start, int dest, int length){
            this.start = start;
            this.dest = dest;
            this.length = length;
        }
        
        // 랜선의 길이를 짧은 순으로 정렬하기 위해 오버라이딩한 메서드
        @Override
        public int compareTo(Node node) {
            return this.length - node.length;
        }
    }
    static int N; // 컴퓨터의 개수
    static int[] parent; // 부모 노드를 나타내는 배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. N 입력
        N = Integer.parseInt(br.readLine());
        
        char[][] comMap = new char[N][N]; // 컴퓨터 배치를 나타내는 배열
        // 2. 컴퓨터 입력
        for(int i = 0; i < N; i++){
            comMap[i] = br.readLine().toCharArray();
        }
        
        // 부모 노드 초기화
        parent = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
        
        // 3. Kruskal 알고리즘을 이용해 기부할 수 있는 랜선의 길이 계산
        int total = 0; // 랜선의 총 길이
        Queue<Node> pq = new PriorityQueue<>(); // 우선순위 큐 선언
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // 입력받은 컴퓨터의 문자가 대문자인 경우
                if('A' <= comMap[i][j] && 'Z' >= comMap[i][j]){
                    total += (comMap[i][j] - 38);
                    pq.add(new Node(i + 1, j + 1, comMap[i][j] - 38));
                }
                // 입력받은 컴퓨터의 문자가 소문자인 경우
                else if('a' <= comMap[i][j] && 'z' >= comMap[i][j]){
                    total += (comMap[i][j] - 96);
                    pq.add(new Node(i + 1, j + 1, comMap[i][j] - 96));
                }
            }
        }
        int edge = 0; // 간선의 개수
        int usedLAN = 0; // 컴퓨터 연결에 사용된 랜선의 길이
        while(!pq.isEmpty()){
            Node node = pq.poll();
            
            int s = find(node.start);
            int d = find(node.dest);
            
            if(s != d){
                edge++;
                usedLAN += node.length;
                union(node.start, node.dest);
            }
        }
        // 간선의 개수가 N-1개가 아닌 경우 모든 컴퓨터를 연결하지 못한 것이기 때문에 -1을 출력
        if(edge != (N - 1)){
            System.out.println(-1);
        }else{
            // 정상 출력
            System.out.println(total - usedLAN);
        }
    }
    
    // 부모 노드를 찾는 메서드
    static int find(int x){
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
        }else{
            parent[x] = y;
        }
    }
}