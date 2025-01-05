/*
1. 트리의 정점 개수(N) 입력
2. 친구 관계 입력
3. dfs를 통해 아이디어를 전파하는데 필요한 얼리 아답터의 최소 수 계산
    - 부모 노드가 얼리어답터가 아닌 경우 모든 자식 노드가 얼리어답터
    - 부모 노드가 얼리어답터인 경우 자식 노드는 얼리어답터거나 아님
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static ArrayList<ArrayList<Integer>> friends; // 친구관계를 나타낼 리스트
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. 트리의 정점 개수(N) 입력
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][2]; // dp[1][1] -> 1 == 얼리어답터, dp[1][0] -> 1번 != 얼리어답터  
        
        friends = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            friends.add(new ArrayList<Integer>());
        }
        
        // 2. 친구 관계 입력
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            friends.get(a).add(b);
            friends.get(b).add(a);
        }
        
        // 3. dfs를 통해 아이디어를 전파하는데 필요한 얼리 아답터의 최소 수 계산
        dfs(1, 0);
        
        // 4. 결과 출력
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    
    static void dfs(int node, int parentNode){
        dp[node][0] = 0; // 현재 노드가 얼리어답터가 아닌 경우
        dp[node][1] = 1; // 현재 노드가 얼리어답터인 경우
        
        for(Integer n : friends.get(node)){
            if(n != parentNode){
                dfs(n, node);
                dp[node][0] += dp[n][1]; // 현재 노드가 얼리어답터가 아닌 경우 자식 노드는 반드시 얼리어답터
                dp[node][1] += Math.min(dp[n][0], dp[n][1]); // 현재 노드가 얼리어답터인 경우 자식 노드는 얼리어답터 or 아님
            }
        }
    }
}