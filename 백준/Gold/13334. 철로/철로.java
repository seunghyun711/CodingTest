/*
1. n 입력
2. 정수 쌍 입력
3. 철로를 놓을 수 있는 시작점(입력받은 정수 쌍 중 가장 작은 값)에서부터 철로에 포함되는 사람의 수 계산
4. 결과 출력
*/
import java.util.*;
import java.io.*;
public class Main{
    static class People implements Comparable<People>{
        int s;
        int e;
        
        public People(int s, int e){
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(People p){
            // 도착점 기준 오름차순, 도착점이 같다면 시작점 기준으로 오름차순
            if(this.e == p.e){
                return this.s - p.s;
            }
            return this.e - p.e;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = 0;
        
        // 1. n 입력
        int n = Integer.parseInt(br.readLine());
        
        List<People> list = new ArrayList<>(); // People 객체를 담을 리스트
        
        // 2. 정수 쌍 입력
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            
            if(h <= o){ // 출발지점과 도착지점이 항상 순서로 들어오는 것은 아니기 떄문에 대소관계 비교 후 객체 생성
                list.add(new People(h, o));
            }else {
                list.add(new People(o ,h));
            }
        }
        Collections.sort(list); // list 정렬
        
        int length = Integer.parseInt(br.readLine()); // 철로의 길이
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 3. 철로를 놓을 수 있는 시작점(입력받은 정수 쌍 중 가장 작은 값)에서부터 철로에 포함되는 사람의 수 계산
        for(People p : list){
            if(p.e - p.s > length){ // 현재 탐색 중인 객체의 거리가 철로길이보다 긴 경우 넘어감
                continue;
            }
            pq.offer(p.s); // 철로의 시작점을 pq에 저장
            // pq.size()는 철로의 범위 내에 있는 사람들의 수
            
            while(!pq.isEmpty()){
                if(p.e - pq.peek() <= length){
                    break;
                }
                pq.poll(); // 현재 도착점을 기준으로 철로의 범위에 포함되지 않는 사람은 제거
            }
            result = Math.max(result, pq.size());
        }
        System.out.println(result);
    }
}