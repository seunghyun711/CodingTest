/*
1. N 입력
2. 아이템 구입 선행 순서 입력
3. 위상 정렬을 통해 아이템 구입 순서 정렬
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 위상정렬에 사용할 map
        Map<String, ArrayList<String>> map = new HashMap<>();
        Map<String, Integer> itemAndDegree = new HashMap<>(); // 아이템 - 차수가 담긴 map
            
        // 2. 아이템 구입 선행 순서 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String front = st.nextToken();
            String rear = st.nextToken();
            
            // front가 처음 입력받은 경우
            if(map.get(front) == null){
                map.put(front, new ArrayList<String>());
                itemAndDegree.put(front, 0); 
            }
            
            // rear가 처음 입력받은 경우
            if(map.get(rear) == null){
                map.put(rear, new ArrayList<String>());
                itemAndDegree.put(rear, 0);
            }
            
            map.get(front).add(rear);
            itemAndDegree.put(rear, itemAndDegree.get(rear) + 1); // 나중에 사야 할 아이템의 진입차수 증가
        }
        
        // 3. 위상 정렬을 통해 아이템 구입 순서 정렬
        Queue<String> q = new LinkedList<>();
        List<String> currentItemList = new ArrayList<>(); // 진입차수가 0인 아이템 구매가 선행 조건인 아이템들의 리스트
        
        // 진입차수가 0인 아이템을 사전순으로 정렬
        for(String item : itemAndDegree.keySet()){
            if(itemAndDegree.get(item) == 0){
                currentItemList.add(item);
            }
        }
        Collections.sort(currentItemList);
        
        // 사전순으로 정렬된 단어 큐에 삽입
        for(String item : currentItemList){
            q.add(item);
        }
        
        while(!q.isEmpty()){
            List<String> sortedList = new ArrayList<>();
            
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                String now = q.poll();
                sb.append(now).append("\n");
                
                for(String next : map.get(now)){
                    itemAndDegree.put(next, itemAndDegree.get(next) - 1); // 진입차수 최신화
                    if(itemAndDegree.get(next) == 0){ // 진입차수가 0인 경우 리스트에 저장(해당 리스트는 아직 정렬이 되지 않은 리스트)
                        sortedList.add(next);
                    }
                }
            }
            Collections.sort(sortedList); // 사전순으로 정렬
            for(String item : sortedList){
                q.add(item);
            }
        }
        
        // 위상정렬이 모두 끝난 후 진입차수가 0이 아닌 경우가 있는지 파악(아이템 구매 가능 여부 파악 목적)
        boolean isPossible = true;
        for(String item : itemAndDegree.keySet()){
            if(itemAndDegree.get(item) != 0){
                isPossible = false;
                break;
            }
        }
        
        // 4. 결과 출력
        if(isPossible){ // 아이템 구매가 가능한 경우 아이템 목록 출략
            System.out.println(sb);
        }else{ // 아이템 구매가 불가능한 경우 -1 출력
            System.out.println(-1);
        }
    }
}