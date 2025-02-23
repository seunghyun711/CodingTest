/*
1. N 입력
2. 주가 입력
3. LIS 알고리즘을 이용해 주가의 가장 긴 오름세의 길이 계산
4. 결과 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String input = "";
        
        // 프로그램 종료 조건
        while((input = br.readLine()) != null){
            // 1. N 입력
            int N = Integer.parseInt(input.trim()); // 공백 제거
            
            int[] jooga = new int[N];
            // 2. 주가 입력
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                jooga[i] = Integer.parseInt(st.nextToken());
            }
            
            // 3. LIS 알고리즘을 이용해 주가의 가장 긴 오름세의 길이 계산
            List<Integer> lis = new ArrayList<>();
            
            for(int j : jooga){
                int index = bs(lis, j); // // 이진탐색을 통해 구한 다음 주가 정보가 들어갈 위치
                if(index == lis.size()){
                    lis.add(j);
                }else{
                    lis.set(index, j);
                }
            }
            sb.append(lis.size()).append("\n");
        }
        
        // 4. 결과 출력
        System.out.println(sb);
    }
    
    static int bs(List<Integer> lis, int key){
        int left = 0;
        int right = lis.size();
        
        while(left < right){
            int mid = (left + right) / 2;
            if(lis.get(mid) >= key){ // 탐색하는 값이 lis배열 중앙에 위치한 값보다 작은 경우 끝값을 mid로 설정하여 구간을 좁힌다.
                right = mid;
            }else{ // 탐색하는 값이 lis 배열 중앙에 위치한 값보다 큰 경우 left를 mid + 1로 증가시켜 탐색 범위를 좁힌다.
                left = mid + 1;
            }
        }
        
        return left;
    }
}