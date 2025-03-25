/*
1. N, M 입력
2. N개 정수 입력
3. 최소, 최대 값을 구하는 세그먼트 트리 생성
4. M개의 순서쌍 입력
5. 세그먼트 트리를 이용해 구간합 계산
6. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int[] num;
    static int[] maxTree; // 최댓값 트리
    static int[] minTree; // 최솟값 트리
    static int minInit = Integer.MAX_VALUE;
    static int maxInit = 0;
    static int min, max;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N, M 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 2. N개 정수 입력
        num = new int[N + 1];
        for(int i = 1; i <= N; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        
        minTree = new int[N * 4];
        maxTree = new int[N * 4];
        
        // 3. 최소, 최대 값을 구하는 세그먼트 트리 생성
        minInit(minTree, 1, N, 1); // 최소 세그먼트 트리 생성
        maxInit(maxTree, 1, N, 1); // 최대 세그먼트 트리 생성
        
        // 4. M개의 순서쌍 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 시작 인덱스
            int end = Integer.parseInt(st.nextToken()); // 마지막 인덱스
            
            min = minInit;
            max = maxInit;
            
            // 최소, 최대 세그먼트 트리의 구간합 계산
            query(0, minTree, 1, N, 1, start, end);
            query(1, maxTree, 1, N, 1, start, end);
            
            // 4. 각 순서쌍 별 최소, 최대 정수 도출
            sb.append(min).append(" ").append(max).append("\n");
           
        }
        
        // 5. 결과 출력
        System.out.println(sb);
    }
    
    // 최소 세그먼트 트리 생성 메서드
    static int minInit(int[] tree, int start, int end, int node){
        if(start == end){ // 리프 노드인 경우 해당 배열의 수 저장
            return tree[node] = num[start];
        }
        
        return tree[node] = 
            Math.min(minInit(tree, start, (start + end) / 2 , node * 2),
                    minInit(tree, (start + end) / 2 + 1, end, node * 2 + 1));
    }
    
    // 최대 세그먼트 트리 생성 메서드
    static int maxInit(int[] tree, int start, int end, int node){
        if(start == end){ // 리프 노드인 경우 해당 배열의 수 저장
            return tree[node] = num[start];
        }
        
        return tree[node] = 
            Math.max(maxInit(tree, start, (start + end) / 2, node * 2),
                    maxInit(tree, (start + end) / 2 + 1, end, node * 2 + 1));
    }

    // 세그먼트 트리의 구간합을 구하는 메서드
    // type : 0 -> 최소 세그먼트 트리
    // type : 1 -> 최대 세그먼트 트리
    static void query(int type, int[] tree, int start, int end, int node, int left, int right){
        if(left > end || right < start){ // [left,right]와 [start,end]가 겹치지 않는 경우
            return; 
        }
        
        if(left <= start && right >= end){ // [left,right]가 [start,end]를 완전히 포함하는 경우
            if(type == 0){
                min = Math.min(min, tree[node]);
            }else{
                max = Math.max(max, tree[node]);
            }
            return;
        }
        query(type, tree, start, (start + end) / 2, node * 2, left, right);
        query(type, tree, (start + end) / 2 + 1, end, node * 2 + 1, left, right);
    }
}