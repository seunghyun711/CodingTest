/*
1. N 입력
2. 마을 별 인구수 입력
3. 인접 마을 입력
4. dfs를 이용해 우수 마을 총 합의 최댓값을 구한다.
    - 우수 마을은 서로 인접 불가
    - 우수 마을이 아닌 마을은 적어도 하나의 우수 마을과 인접
* 우수 마을 및 일반 마을 선정 경우의 수
- 현재 탐색 노드가 우수 마을인 경우 해당 노드의 자식 노드는 우수 마을이 아님
- 현재 탐색 노드가 우수 마을인 경우 해당 노드의 자식 노드는 우수 마을이거나 아님
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static ArrayList<ArrayList<Integer>> town; // 마을 
    static int[] pop; // 각 마을의 인구수를 담을 배열
    static int[][] dp;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N 입력
        N = Integer.parseInt(br.readLine());
        
        pop = new int[N + 1];
        dp = new int[N + 1][2]; // dp[1][1] : 1번 마을이 우수 마을, dp[1][0] : 1번 마을이 일반 마을
        
        town = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            town.add(new ArrayList<Integer>());
        }
        
        // 2. 마을 별 인구수 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            pop[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. 인접 마을 입력
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            town.get(a).add(b);
            town.get(b).add(a);
        }
        
        // 4. dfs를 이용해 우수 마을 총 합의 최댓값을 구한다.
        dfs(1, 0);
        
        // 5. 결과 출력
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    
    static void dfs(int node, int parentNode){
        for(Integer n : town.get(node)){
            if(n != parentNode){
                dfs(n, node); // 하위 노드 dfs 탐색
                dp[node][0] += Math.max(dp[n][0], dp[n][1]); // 현재 노드가 우수 마을이 아닌 경우 자식 노드는 우수 마을이거나 일반 마을 
                dp[node][1] += dp[n][0]; // 현재 노드가 우수 마을인 경우 자식 노드는 일반 마을
            }
        }
        dp[node][1] += pop[node]; // 우수 마을 인구수 저장
    }
}