/*
1. n, 다리길이(W), 최대하중(L) 입력
2. 트럭의 무게를 queue에 저장
3. 현재 다리에 올라간 트럭의 무게를 queue에 저장
4. 다리에 올라간 트럭들을 탐색하면서 트럭이 모두 다리를 건너는데 걸리는 시간 계산
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0; // 트럭이 다리를 건너는데 걸리는 시간
        int currentTotalWeight = 0; // 현재 다리에 올라간 트럭의 무게 
        
        // 1. n, 다리길이(W), 최대하중(L) 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n
        int W = Integer.parseInt(st.nextToken()); // W
        int L = Integer.parseInt(st.nextToken()); // L
        
        Queue<Integer> trucks = new LinkedList<>(); // 트럭의 무게를 담을 queue
        Queue<Integer> currentBridge = new LinkedList<>(); // 현재 다리에 올라간 트럭의 무게를 담을 queue
         
        // 2. 트럭의 무게를 queue에 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            trucks.add(Integer.parseInt(st.nextToken()));
        }
        
        // 3. 현재 다리에 올라간 트럭의 무게를 queue에 저장
        for(int i = 0; i < W; i++){
            currentBridge.add(0); // 최초 상태는 트럭이 올라가지 않은 상태이므로 0을 저장
        }
        
        // 4. 다리에 올라간 트럭들을 탐색하면서 트럭이 모두 다리를 건너는데 걸리는 시간 계산
        while(!currentBridge.isEmpty()){
            result++;
            currentTotalWeight -= currentBridge.poll(); // 다리 위에 있던 트럭이 다리를 건넘
            
            if(!trucks.isEmpty()){
                // 현재 트럭의 무게 + 현재 다리 위에 올라가 트럭의 무게가 최대 무게 이하인 경우
                if(currentTotalWeight + trucks.peek() <= L){
                    currentTotalWeight += trucks.peek(); // 다리 위에 있는 트럭의 무게 추가
                    currentBridge.add(trucks.poll()); // 현재 트럭을 다리 위에 올림
                }else{ // 더 이상 다리 위에 트럭이 올라가지 못하는 경우
                    currentBridge.add(0);
                   
                }
            }
        }
        
        System.out.println(result);
    }
}