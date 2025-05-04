/*
1. N, M, X 입력
2. 각 노드 간의 이동거리 입력
3. 2번 입력을 바탕으로 2차원 리스트와 2번 입력의 반대방향의 리스트 2개를 생성
4. 3번을 통해 생성한 두 개의 리스트를 각각 X를 출발지로 하여 각 노드에 도달하는 최단거리를 하여 각각 배열에 저장
5. 두 개의 배열의 요소를 인덱스에 맞추어 더하고 그 중 가장 큰 값을 찾아 출력
*/
import java.io.*;
import java.util.*;
class Node implements Comparable<Node>{
    int index;
    int dist;
    
    Node(int index, int dist){
        this.index = index;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Node n){
        return dist - n.dist;
    }
}
public class Main{
    static ArrayList<ArrayList<Node>> list, reverseList;
    static int N;
    static int M;
    static int X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. N, M, X 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        reverseList = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        // 2. 각 노드 간의 이동거리 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            // 3. 2번 입력을 바탕으로 2차원 리스트와 2번 입력의 반대방향의 리스트 2개를 생성
            list.get(start).add(new Node(end, dist));
            reverseList.get(end).add(new Node(start, dist));
        }

        // 4. 3번을 통해 생성한 두 개의 리스트를 각각 X를 출발지로 하여 각 노드에 도달하는 최단거리를 하여 각각 배열에 저장
        int[] minDist1 = calcDist(list);
        int[] minDist2 = calcDist(reverseList);

        // 5. 두 개의 배열의 요소를 인덱스에 맞추어 더하고 그 중 가장 큰 값을 찾아 출력
        int result = 0;
        for(int i = 1; i <= N; i++){
            result = Math.max(result, minDist1[i] + minDist2[i]);
        }
        System.out.println(result);
    }

    // 다익스트라 알고리즘을 통해 최단거리를 구하는 메서드
    static int[] calcDist(ArrayList<ArrayList<Node>> list){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0)); // 시작점

        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1]; // 출발지부터 인덱스 노드까지 거리를 담는 배열

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[X] = 0; // 시작점 ~ 시작점은 0이므로 0으로 초기화

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int curNode = node.index;

            if(!visited[curNode]){
                visited[curNode] = true; // 방문 처리

                for(Node n : list.get(curNode)){
                    if(!visited[n.index] && (distance[n.index] > distance[curNode] + n.dist)){
                        distance[n.index] = distance[curNode] + n.dist;
                        pq.add(new Node(n.index, distance[n.index]));
                    }
                }
            }
        }
        return distance;
    }
}