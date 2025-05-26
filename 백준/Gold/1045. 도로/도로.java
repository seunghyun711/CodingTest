/*
1. N, M 입력
2. 행렬입력
3. M개의 도로 연결
4. 도로의 개수 계산
5. 도시가 모두 연결되었는지 파악
6. 결과 출력
*/
import java.io.*;
import java.util.*;

class Road{
    int i; 
    int j;
    
    public Road(int i, int j){
        this.i = i;
        this.j = j;
    }
}

public class Main{
    static int[] parent;
    static Queue<Road> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 1. N, M 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 2. 행렬입력
        boolean[][] visited = new boolean[N][N];
        parent = new int[N];
        char[][] isRoad = new char[N][N];
        for(int i = 0; i < N; i++){
            isRoad[i] = br.readLine().toCharArray();
        }
        for(int i = 0; i < N; i++){        
            for(int j = 0; j < N; j++){
                //  i와 j를 연결하는 도로가 있는 경우에만 해당 도로 객체를 큐에 삽입(중복 제거(1,2)와 (2,1)은 같은 의미이므로 둘 중 하나만 큐에 삽입)
                if(isRoad[i][j] == 'Y' && !visited[i][j] && !visited[j][i]){ 
                    visited[i][j] = true;
                    visited[j][i] = true;
                    q.add(new Road(i, j));
                }
            }
        }
        // 3. M개의 도로 연결
        if(q.size() < M){ // 도로의 개수가 M보다 적은 경우 -1 출력 후 종료
            System.out.println(-1);
            return;
        } 
        
        int[] roads = new int[N]; // 각 도시와 연결된 도로의 수
        
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }
        
        Queue<Road> tmpRoad = new LinkedList<>(); 
        int count = 0;
        Road r;
        // 4. 도로의 개수 계산
        while(!q.isEmpty()){
            if(count == M){
                break;
            }
            r = q.poll();
            if(union(r.i, r.j)){ // 각 도시가 아직 연결되지 않은 상태인 경우 연결
                count++; // 전체 도로의 수 증가
                roads[r.i]++; // i번 도시에 연결된 도로의 수
                roads[r.j]++; // j번 도시에 연결된 도로의 수
            }else{
                tmpRoad.add(r); // union으로 인해 같은 부모를 가지지만 실질적으로는 연결되지 않은 도로
            }
        }
        
        // 5. 도시가 모두 연결되었는지 파악
        if(count < N - 1){
            System.out.println(-1);
            return;
        }
        // 연결된 도로의 수가 부족한 경우 추가
        while(count < M){
            r = tmpRoad.poll();
            roads[r.i]++;
            roads[r.j]++;
            
            count++;
        }
        
        // 6. 결과 출력
        for(int i = 0; i < N; i++){
            sb.append(roads[i]).append(" ");
        }
        System.out.println(sb);
        
    }
    
    static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    
    static boolean union(int i, int j){
        i = find(i);
        j = find(j);
        
        if(i == j){
            return false;
        }
        
        if(i < j){
            parent[j] = i;
        }else{
            parent[i] = j;
        }
        return true;
    }
}