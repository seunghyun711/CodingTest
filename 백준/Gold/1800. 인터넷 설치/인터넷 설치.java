/*
1. N, P, K 입력
2. 연결정보, 가격 입력
3. 각각의 번호까지 인터넷을 연결할 때 각 번호별 무료 회선 개수 및 결제해야 할 최소 비용 계산
4. 결과 출력
*/
import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
    int dest; // 도착할 번호 
    int value; // 시작 번호에서 도착 번호(dest)까지 연결하는 비용
    
    public Node(int dest, int value){
        this.dest = dest;
        this.value = value;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
public class Main{
    static int N, P, K;
    static ArrayList<ArrayList<Node>> line = new ArrayList<>();
    static int[] dist; // 각 번호 별 사용되는 공짜 회선의 개수
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
         //1. N, P, K 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 2. 연결정보, 가격 입력
        for(int i = 0; i <= N; i++){
            line.add(new ArrayList<>());
        }
        
        dist = new int[N + 1];
        int minValue = 0; // 최소비용
        int maxValue = Integer.MIN_VALUE; // 최대 비용
        
        for(int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, value);
            
            // 양방향 연결 
            line.get(start).add(new Node(end, value));
            line.get(end).add(new Node(start, value));
        }
        
        int result = -1;
        
        // 3. 각각의 번호까지 인터넷을 연결할 때 각 번호별 무료 회선 개수 및 결제해야 할 최소 비용 계산
        while(minValue <= maxValue){
            int mid = (minValue + maxValue) / 2; // 기준 비용(구하고자하는 최소 비용)
            if(calcValue(mid)){
                result = mid;
                maxValue = mid - 1;
            }else {
                minValue = mid + 1;
            }
        }
        
        // 4. 결과 출력
        System.out.println(result);
    }
    
    static boolean calcValue(int mid){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0)); // 시작점을 큐에 삽입
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(dist[cur.dest] < cur.value){
                continue;
            }
            
            for(Node next : line.get(cur.dest)){
                int freeLine = cur.value; // 공짜 인터넷 선의 개수
                
                // 기준 비용을 기준으로 다음 탐색 노드의 비용이 더 큰 경우 공짜 인터넷 선의 수 증가
                if(mid < next.value){
                    freeLine++;
                }
                
                if(dist[next.dest] > freeLine){
                    dist[next.dest] = freeLine;
                    pq.add(new Node(next.dest, freeLine));
                }
            }
        }
        return dist[N] <= K;
    }
    
}