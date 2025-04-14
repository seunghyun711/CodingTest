/*
1. N 입력
2. 주유소 정보 입력
3. L, P 입력
4. 주유소에서 멈추는 횟수 계산 
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        int[] gs = new int[1000001]; // 주유소
        
        // 2. 주유소 정보 입력
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            // gs[주유소 까지의 거리] = 해당 주유소에서 채울 수 있는 연료의 양
            gs[dist] = Integer.parseInt(st.nextToken());
        }
        
        // 3. L, P 입력
        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        // 4. 주유소에서 멈추는 횟수 계산 
        int stopCount = 0; // 주유소에서 멈추는 횟수
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순
        for(int i = 1; i <= L; i++){
            if(gs[i] != 0){ // i거리에 주유소가 있는 경우 큐에 삽입
                pq.add(gs[i]);
            }
            P--;
            
            if(i == L){
                break;
            }
            
            if(P == 0){ // 연료가 부족한 경우
                if(pq.size() == 0){ // 갈 수 있는 주유소가 더이상 없는 경우 종료
                    stopCount = -1;
                    break;
                }
                stopCount++;
                P += pq.poll(); // 주유
            }
        }
        
        // 5. 결과 출력
        System.out.println(stopCount);
    }
}