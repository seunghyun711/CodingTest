/*
1. N, C 입력
2. 박스 정보 개수 및 박스 정보 입력
3. 받는 마을을 기준으로 오름차순 정렬하여 최대 박스의 수 계산
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    static class Box implements Comparable<Box>{
        int from;
        int to;
        int count;
        
        public Box(int from, int to, int count){
            this.from = from;
            this.to = to;
            this.count = count;
        }
        
        public int compareTo(Box b){
            if(this.to == b.to){ // 두 객체의 받는 마을이 같은 경우 보내는 마을을 기준으로 오름차순 정렬
                return this.from - b.from;
            }
            return this.to - b.to;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N, C 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        // 2. 박스 정보 개수 및 박스 정보 입력
        List<Box> box = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            
            box.add(new Box(from, to, count));
        }
        
        // 3. 받는 마을을 기준으로 오름차순 정렬하여 최대 박스의 수 계산
        Collections.sort(box);
        int[] town = new int[N];
        Arrays.fill(town, C);
        
        int result = 0;
        
        for(int i = 0; i < M; i++){
            Box b = box.get(i);
            // 보내는 마을에서 받는 마을까지 배송할 수 있는 최대 박스 개수
            int min = Integer.MAX_VALUE;
            for(int j = b.from; j < b.to; j++){
                min = Math.min(min, town[j]);
            }
            // 해당 마을에서 배송할 수 있는 모든 박스를 담는 경우
            if(min >= b.count){
                for(int j = b.from; j < b.to; j++){
                    town[j] -= b.count;
                }
                result += b.count; // 누적 박스의 개수
            }else{ // 해당 마을에서 배송할 수 있는 박스 중 일부만 담는 경우
                for(int j = b.from; j < b.to; j++){
                    town[j] -= min;
                }
                result += min; // 누적 박스의 개수
            }
        }
        // 4. 결과 출력
        System.out.println(result);
    }
}