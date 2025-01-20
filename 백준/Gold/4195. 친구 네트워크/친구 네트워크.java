/*
1. 테스트 케이스 수 입력
2. 친구 관계 수 입력
3. 친구 관계 입력
4. union-find를 이용해 두 친구 노드가 같은 부모 노드를 가지면 친구 관계 연결
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int[] parent; // 각 노드의 부모노드 배열
    static int[] network; // 각 노드의 친구 수(네트워크)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 1. 테스트 케이스 수 입력
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < tc; i++){
            // 2. 친구 관계 수 입력
            int fs = Integer.parseInt(br.readLine()); // 친구 관계 수
            parent = makeSet(fs * 2); // 최대 친구의 수 = 친구 관계 * 2
            network = new int[fs * 2];
            Arrays.fill(network, 1); // 네트워크는 각각 1로 초기화
            
            int index = 0;
            Map<String, Integer> fmap = new HashMap<>(); // 사람이름 - 인덱스
            
            // 3. 친구 관계 입력
            for(int j = 0; j < fs; j++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                
                // 입력받은 사람의 이름이 map에 없는 경우 추가
                if(!fmap.containsKey(a)){ 
                    fmap.put(a, index++);
                }
                if(!fmap.containsKey(b)){
                    fmap.put(b, index++);
                }
                
                // 두 사람의 인덱스
                int index1 = fmap.get(a);
                int index2 = fmap.get(b);
                
                // 4. union-find를 이용해 두 친구 노드가 같은 부모 노드를 가지면 친구 관계 연결
                sb.append(union(index1, index2)).append("\n");
            }
        }
        // 5. 결과 출력
        System.out.println(sb);
    }
    
    // 부모 노드 배열 초기화
    static int[] makeSet(int size){
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        return arr;
    }
    
    // union-find
    static int find(int x){
        if(parent[x] == x){
            return x;
        }else {
            return parent[x] = find(parent[x]);
        }
    }
    
    static int union(int a, int b){
        a = find(a);
        b = find(b);
        
        // 두 사람의 연관관계를 아직 계산하지 않은 경우
        if(a != b){
            if(a > b){
                parent[a] = b;
                // 친구 네트워크 계산
                network[b] += network[a];
                return network[b];
            }else{
                parent[b] = a;
                // 친구 네트워크 계산
                network[a] += network[b];
                return network[a];
            }
        }else{ // 이미 두 사람의 연관관계를 게산한 경우 
            if(a > b){
                return network[b];
            }else{
                return network[a];
            }
        }
    }
}