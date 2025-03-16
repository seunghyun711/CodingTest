/*
1. 숫자 입력
2. bfs를 통해 입력받은 숫자가 정리될 때 까지 0의 위치를 옮기며 최소 이동횟수 계산
3. 최소 이동횟수 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String start = ""; // 입력받은 숫자를 문자열로 받는다.
        // 1. 숫자 입력
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                start += st.nextToken();
            }
        }
        // 2. bfs를 통해 입력받은 숫자가 정리될 때 까지 0의 위치를 옮기며 최소 이동횟수 계산
        int result = bfs(start);
        
        // 3. 최소 이동횟수 출력
        System.out.println(result);
    }
    
    static int bfs(String start){
        String ans = "123456780"; // 0을 움직여서 만들 최종 결과
        
        Queue<String> q = new LinkedList<>();
        // key : 숫자 조합, value : 해당 숫자조합(key)가 되기까지의 이동횟수
        HashMap<String, Integer> map = new HashMap<>(); 
        map.put(start, 0); // 최초 상태 초기화
        
        q.add(start);
        
        while(!q.isEmpty()){
            String curNum = q.poll();
            int curPosition = curNum.indexOf('0'); // 현재 0이 있는 위치
            // 현재 0의 위치를 2차원 배열로 대입했을 때의 좌표
            int r = curPosition / 3;
            int c = curPosition % 3;
            
            // 현재 상태가 목표한 결과라면 해당 상태의 이동횟수를 리턴
            if(curNum.equals(ans)){
                return map.get(curNum);
            }
            
            // 현재 위치에서 다음 위치로 탐색
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nc <0 || nr >= 3 || nc >= 3){
                    continue;
                }
                int next = nr * 3 + nc; // 탐색할 다음 위치(문자열의 인덱스)
                char tmp = curNum.charAt(next);
                
                // 0의 위치와 탐색할 다음 숫자의 위치를 바꾼다.
                String nextNum = curNum.replace(tmp, 'c');
                nextNum = nextNum.replace('0', tmp);
                nextNum = nextNum.replace('c', '0');
                
                // 변경된 문자열이 map에 없다면 큐, map에 삽입
                if(!map.containsKey(nextNum)){
                    q.add(nextNum);
                    map.put(nextNum, map.get(curNum) + 1);
                }
            }
        }
        return -1;
    }
}