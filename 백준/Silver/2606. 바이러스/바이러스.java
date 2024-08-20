/*
DFS 이용
1. 컴퓨터의 수(N) 입력
2. 직접 연결된 컴퓨터 쌍의 수 입력
3. 2번 개수만큼 컴퓨터 번호의 쌍 입력
4. 방문여부를 파악하는 boolean 타입의 배열을 이용하여 3번에서 입력한 값을 바탕으로 컴퓨터의 감염여부 파악 및 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int count; // 감염된 컴퓨터의 수
    static int N; // 컴퓨터의 수
    static int couple; // 직접 연결된 컴퓨터의 수
    static int[][] couplingStatus; // 컴퓨터 쌍의 현황을 파악하는 배열
    static boolean[] visited; // 방문 여부를 파악하는 배열
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. 컴퓨터의 수(N) 입력
        N = Integer.parseInt(br.readLine());
        // 2. 직접 연결된 컴퓨터 쌍의 수 입력
        couple = Integer.parseInt(br.readLine());
        
        count = 0; // 감염된 컴퓨터의 수
        
        couplingStatus = new int[N][N]; // 컴퓨터 쌍의 현황을 파악하는 배열
        
        visited = new boolean[N]; // 방문 여부를 파악하는 배열
        
        // 3. 2번 개수만큼 컴퓨터 번호의 쌍 입력
        for(int i = 0; i < couple; i++){
            st = new StringTokenizer(br.readLine());
            // 인덱스는 0번부터 시작하므로 입력받은 컴퓨터 번호에 -1을 한다.
            int comA = Integer.parseInt(st.nextToken()) - 1;
            int comB = Integer.parseInt(st.nextToken()) - 1;
            
            /*
            1번 컴퓨터와 2번 컴퓨터가 연결된 것과 2번 컴퓨터와 1번 컴퓨터가 연결된 것은 같은 상황이기 때문에
            중복으로 카운팅 하지 않도록 couplingStatus[comA][comB]와 couplingStatus[comB][comA]에 모두
            1저장
            */
            couplingStatus[comA][comB] = couplingStatus[comB][comA] = 1;
        }
        
        // 4. 방문여부를 파악하는 boolean 타입의 배열을 이용하여 3번에서 입력한 값을 바탕으로 컴퓨터의 감염여부 파악 및 출력
        System.out.println(dfs(0) - 1); // 1번 컴퓨터를 제외하고 계산해야 하기 떄문에 -1을 한다.
        
    }
    
    // 감염된 컴퓨터를 탐색하는 메서드
    static int dfs(int comNum){
        visited[comNum] = true;
        count++;
        
        for(int i = 0; i < N; i++){
            // 컴퓨터 간 연결되었으면서 감염되었다고 카운팅을 하지 않은 경우 해당 번호로 dfs 메서드 실행
            if(couplingStatus[comNum][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
        return count;
    }
}
