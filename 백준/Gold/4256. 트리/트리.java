/*
1. 테스트 케이스 개수 입력
2. 노드의 개수(n) 입력
3. 노드 번호 입력(전위, 중위 순회 배열에 각각 저장)
4. 3번에서 입력받은 정보를 바탕으로 후위 순회 진행
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static StringBuilder sb = new StringBuilder();
    static int[] preOrder; // 전위 순회 정보를 담을 배열
    static int[] inOrder; // 중위 순회 정보를 담을 배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. 테스트 케이스 개수 입력
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++){
            // 2. 노드의 개수(n) 입력
            int n = Integer.parseInt(br.readLine());
            preOrder = new int[n + 1];
            inOrder = new int[n + 1];
            // 3. 노드 번호 입력(전위, 중위 순회 배열에 각각 저장)
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){ // 전위 순회 입력
                preOrder[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){ // 후위 순회 입력
                inOrder[j] = Integer.parseInt(st.nextToken());
            }
            
            // 4. 3번에서 입력받은 정보를 바탕으로 후위 순회 진행
            postOrder(0, 0, n);
            sb.append("\n");
        }
        
        // 5. 결과 출력
        System.out.println(sb);
    }
    
    // 후위 순회를 진행하는 함수
    static void postOrder(int root, int start, int end){
        int cur = preOrder[root];
        
        // inOrder의 범위 탐색
        for(int i = start; i < end; i++){
            if(cur == inOrder[i]){
                postOrder(root + 1, start, i); // 왼쪽 서브 트리 탐색
                postOrder(root + (i - start + 1), i + 1, end); // 오른쪽 서브 트리 탐색
                sb.append(cur).append(" ");
                return;
            }
        }
    }
}