/*
1. 학생 수 N, 친구관계 수 M, 가지고 있는 돈 k 입력
2. 친구비 입력
3. 친구 관계 입력 및 친구 관계 게산
4. 3번 결과를 통해 얻은 부모 노드를 탐색하여 친구비 계산
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int totalCost = 0; // 친구비
        
        // 1. 학생 수 N, 친구관계 수 M, 가지고 있는 돈 k 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] parent = makeSet(N + 1); // 각 친구(노드)의 부모 노드를 담는 배열 초기화
        
        // 2. 친구비 입력
        int[] cost = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. 친구 관계 입력 및 친구 관계 게산
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            union(parent, v, w);
        }
        
        // 4. 3번 결과를 통해 얻은 부모 노드를 탐색하여 친구비 계산
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= N; i++){ // '친구 번호 - 친구비' 형태로 저장
            int node = find(parent, i);
            if(map.containsKey(node)){ // map에 node에 대한 정보가 이미 있는 경우 최소 비용인 것을 map에 저장
                int minCost = Math.min(map.get(node), cost[i]);
                map.put(node, minCost);
            }else{ // map에 노드에 대한 정보가 없는 경우 해당 노드에 대한 cost를 map에 추가
                map.put(node, cost[node]);
            }
        }
        
        // 친구비 계산
        for(int i = 1; i <= N; i++){
            if(map.get(i) != null){
                totalCost += map.get(i);
            }
        }
        
        // 총 친구비가 예산을 벗어나지 않으면 계산한 친구비를 출력 아니면 "Oh no"입력
        if(k >= totalCost){
            System.out.println(totalCost);
        }else{
            System.out.println("Oh no");
        }
        
    }
    
    // 각 노드의 부모노드를 초기화하는 메서드
    static int[] makeSet(int size){
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        return arr;
    }
    
    // 부모 노드를 찾는 메서드
    static int find(int[] parent, int x){
        // 찾는 대상과 인덱스 번호가 같다면 해당 인덱스가 해당 집합의 부모
        if(parent[x] == x){
            return x;
        }else{ // 그렇지 않은 경우 재귀적으로 최종 부모 노드까지 탐색
            return parent[x] = find(parent, parent[x]);
        }
    }
    
    // 두 개의 노드를 하나의 집합으로 만드는 메서드(부모 노드 최신화)
    static void union(int[] parent, int a, int b){
        a = find(parent, a);
        b = find(parent, b);
        
        if(a > b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }
}