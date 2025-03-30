/*
1. 수열의 크기 및 수열 입력
2. 최소 세그먼트 트리 초기화
3. 쿼리의 개수 및 쿼리 입력
4. 쿼리에 따른 범위 내 최솟값 / 수열 요소 업데이트 
5. 2번 쿼리(범위 내 최솟값)에 대한 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N;
    static int M;
    static int[] num;
    static int[] tree;
    static int min;
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        // 1. 수열의 크기 및 수열 입력
        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        st = new StringTokenizer(br.readLine()); // 수열 입력
        for(int i = 1; i <= N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        // 2. 최소 세그먼트 트리 초기화
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int size = (int) Math.pow(2, h + 1);
        tree = new int[size];
        
        // 최소 세그먼트 트리 생성
        minInit(tree, 1, N, 1);
        
        // 3. 쿼리의 개수 및 쿼리 입력
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            
            min = minValue;
            
            // 4. 쿼리에 따른 범위 내 최솟값 / 수열 요소 업데이트 
            if(q == 1){ // q == 1이면 배열의 요소 업데이트
                update(1, N, 1, left, right);
            }else{ // q == 2이면 배열의 특정 범위 내의 최솟값 계산
                findMin(tree, 1, N, 1, left, right);
                sb.append(min).append("\n"); // 최솟값 저장
            }
        }
        
        // 5. 2번 쿼리(범위 내 최솟값)에 대한 결과 출력
        System.out.println(sb);
    }
    
    // 최소 세그먼트 트리를 생성하는 메서드
    static int minInit(int[] tree, int start, int end, int node){
        if(start == end){
            return tree[node] = num[start];
        }else{
            return tree[node] = 
                Math.min(minInit(tree, start, (start + end) / 2, node * 2),
                         minInit(tree, (start + end) / 2 + 1, end, node * 2 + 1));
        }
    }
    
    // 배열 내 요소를 변경하는 메서드
    static void update(int start, int end, int node, int index, int val){
        if(index < start || index > end){
            return;
        }
        if(start == end){
            num[index] = val;
            tree[node] = val;
            return;
        }
        update(start, (start + end) / 2, node * 2, index, val);
        update((start + end) / 2 + 1, end, node * 2 + 1, index, val);
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }
    
    // 구간 최솟값을 구하는 메서드
    static void findMin(int[] tree, int start, int end, int node, int left, int right){
        if(left > end || right < start){ // 찾고자 하는 구간이 트리의 범위에 벗어나는 경우
            return;
        }
        
        if(left <= start && right >= end){
            min = Math.min(min, tree[node]);
            return;
        }
        
        findMin(tree, start, (start + end) / 2, node * 2, left, right);
        findMin(tree, (start + end) / 2 + 1, end, node * 2 + 1, left, right);
    }
}