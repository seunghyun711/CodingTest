/*
1. 학생 수(N), 두 학생의 키를 비교한 횟수(M) 입력
2. 비교 할 두 학생의 번호 입력
3. 기준 노드 보다 키가 작은 노드들을 dfs를 통해 탐색한 노드의 수와 기준 노드 보다 키가 크 노드들을 dfs를 통해 탐색한 노드의 수를 계산
4. 4번에서 구한 2개의 dfs의 값을 더한 후 - 1(기준 노드 중복 제거)
5. 4번의 결과 == 노드의 수인 경우 해당 노드는 자신의 키가 몇 번째 노드인지 알 수 있는 노드가 된다.
6. 5번을 통해 자신의 키가 몇 번째 노드인지 알 수 있는 노드의 수를 계산하여 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N; // 학생 수
    static int M; // 두 학생의 키를 비교한 횟수
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tallList; // 기준 노드보다 키가 큰 노드를 담을 리스트
    static ArrayList<ArrayList<Integer>> shortList; // 기준 노드보다 키가 작은 노드를 담을 리스트
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int result = 0; // 결과
        
        // 1. 학생 수(N), 두 학생의 키를 비교한 횟수(M) 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        tallList = new ArrayList<>();
        shortList = new ArrayList<>();
        // 리스트 초기화
        for(int i = 0; i <= N; i++){
            tallList.add(new ArrayList<>());
            shortList.add(new ArrayList<>());
        }
        
        // 2. 비교 할 두 학생의 번호 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int shortNum = Integer.parseInt(st.nextToken());
            int tallNum = Integer.parseInt(st.nextToken());
            
            tallList.get(shortNum).add(tallNum); // shortNum(기준 노드)보다 큰 노드(tallNum)
            shortList.get(tallNum).add(shortNum); // tallNum(기준 노드)보다 작은 노드(shortNum)
        }
        
        // 3. 기준 노드 보다 키가 작은 노드들을 dfs를 통해 탐색한 노드의 수와 기준 노드 보다 키가 크 노드들을 dfs를 통해 탐색한 노드의 수를 계산
        for(int i = 1; i <= N; i++){
            visited = new boolean[N + 1];
            int tallNodes = dfs(i, tallList, visited); 
            int shortNodes = dfs(i , shortList, visited);
            
            // 4. 4번에서 구한 2개의 dfs의 값을 더한 후 - 1(기준 노드 중복 제거)
            int count = tallNodes + shortNodes - 1;
            
            // 5. 4번의 결과 == 노드의 수인 경우 해당 노드는 자신의 키가 몇 번째 노드인지 알 수 있는 노드가 된다.
            if(count == N){
                result++;
            }
        }
        
        // 6. 5번을 통해 자신의 키가 몇 번째 노드인지 알 수 있는 노드의 수를 계산하여 출력
        System.out.println(result);
    }
    
    static int dfs(int currentNode, ArrayList<ArrayList<Integer>> list, boolean[] visited){
        int nodes = 1; // 탐색 노드의 수
        visited[currentNode] = true;
        
        for(int node : list.get(currentNode)){
            if(!visited[node]){
                nodes += dfs(node, list, visited);
            }
        }
        
        return nodes;
    }
}