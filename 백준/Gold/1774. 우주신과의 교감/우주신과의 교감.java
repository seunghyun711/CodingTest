/*
1. 우주신들의 개수(N), 이미 연결된 신들과의 통로 개수(M) 입력
2. 황선자 및 우주신들의 좌표 입력(x, y)
3. 연결된 통로 입력
4. Kruskal 알고리즘을 사용하여 최소 통로 길이 계산
5. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static class Position {
        int num; // 통로 번호
        // 좌표
        int x;
        int y;

        public Position(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    // 우주신과 통로 연결 객체
    static class Tongro implements Comparable<Tongro> {
        int start; // 시작점
        int end; // 끝점
        double distance;

        public Tongro(int start, int end, double distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        // 각 좌표 간 통로 거리를 오름차순으로 정렬하기 위한 메서드 오버라이딩
        @Override
        public int compareTo(Tongro tongro) {
            return Double.compare(this.distance, tongro.distance);
        }
    }

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 우주신들의 개수(N), 이미 연결된 신들과의 통로 개수(M) 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. 황선자 및 우주신들의 좌표 입력(x, y)
        parent = makeSet(N);
        Position[] positionArr = new Position[N + 1]; // 각 좌표의 위치 객체를 담은 배열
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            positionArr[i] = new Position(i, x, y);
        }

        // 3. 연결된 통로 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 연결된 지점은 union 연산
            union(start, end);
        }

        // 4. Kruskal 알고리즘을 사용하여 최소 통로 길이 계산
        Queue<Tongro> pq = new PriorityQueue<>();
        // 모든 좌표 간 거리를 큐에 삽입
        for(int i = 1; i <= N; i++){
            for(int j = i + 1; j <= N; j++){
                double dist = calcDistance(positionArr[i], positionArr[j]); // 두 좌표 간 거리 계산
                pq.add(new Tongro(positionArr[i].num, positionArr[j].num, dist));
            }
        }

        // 최소 통로 길이 계산
        double result = 0;
        while(!pq.isEmpty()){
            Tongro tongro = pq.poll();

            if(find(tongro.start) != find(tongro.end)){
                result += tongro.distance;
                union(tongro.start, tongro.end);
            }
        }

        // 5. 결과 출력(소수점 둘째 자리까지 반올림)
        System.out.printf("%.2f", result);

    }

    // 부모 노드 초기화 메서드
    static int[] makeSet(int size){
        int[] arr = new int[size + 1];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        return arr;
    }

    // find 연산을 하는 메서드
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // union 연산을 하는 메서드
    static void union(int start, int end){
        start = find(start);
        end = find(end);

        if(start < end){
            parent[end] = start;
        }else{
            parent[start] = end;
        }
    }

    // 두 좌표 간 거리를 계산하는 메서드
    static double calcDistance(Position p1, Position p2){
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
    }
}

