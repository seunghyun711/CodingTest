/*
1. N, 점수, P 입력
2. N이 0보다 큰 경우 현재 랭킹 리스트에 있는 점수 입력(LinkedList에 저장)
3. 1번에서 입력받은 점수를 리스트에 삽입
4. 리스트를 내림차순으로 정렬
5. 새로 삽입된 점수의 인덱스 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedList<Integer> list = new LinkedList<>(); // 랭킹 리스트
        
        // 1. N, 점수, P 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N
        int score = Integer.parseInt(st.nextToken()); // 점수
        int P = Integer.parseInt(st.nextToken()); // P
        
        // 2. N이 0보다 큰 경우 현재 랭킹 리스트에 있는 점수 입력(LinkedList에 저장)
        if(N > 0){ 
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
        }
        
        // 3. 1번에서 입력받은 점수를 리스트에 삽입
        list.add(score);
        
        // 4. 리스트를 내림차순으로 정렬
        Collections.sort(list); // 오름차순 정렬
        Collections.reverse(list); // 역순 정렬을 통해 내림차순으로 정렬
        
        // 5. 새로 삽입된 점수의 인덱스 출력
        // 가장 마지막 인덱스부터 탐색하여 새로운 점수가 랭킹 리스트의 범위에서 벗어나면 -1 리턴
        if(list.lastIndexOf(score) + 1 > P){ // 인덱스는 0부터 시작이므로 결과에 +1
            System.out.println(-1);
        }else{
            System.out.println(list.indexOf(score) + 1); // 인덱스는 0부터 시작이므로 결과에 +1
        }
        
    }
}