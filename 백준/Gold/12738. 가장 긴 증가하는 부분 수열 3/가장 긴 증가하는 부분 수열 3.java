/*
1. N 입력
2. 수열 입력
3. LIS 알고리즘을 통해 최장 증가 수열 도출
4. 3번을 통해 나온 수열의 크기 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 2. 수열 입력
        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. LIS 알고리즘을 통해 최장 증가 수열 도출
        List<Integer> lis = new ArrayList<>();
        
        for(int n : num){
            int index = bs(lis, n); // 이진탐색을 통해 lis 배열에 들어갈 수의 인덱스 계산
            if(index == lis.size()){
                lis.add(n);
            }else{
                lis.set(index, n);
            }
        }
        
        // 4. 3번을 통해 나온 수열의 크기 출력
        System.out.println(lis.size());
    }
    
    static int bs(List<Integer> lis, int key){
        int left = 0;
        int right = lis.size();
        
        while(left < right){
            int mid = (left + right) / 2;
            if(lis.get(mid) >= key){ // 탐색하는 값이 lis배열 중앙에 위치한 값보다 작은 경우 끝값을 mid로 설정하여 구간을 좁힌다.
                right = mid;
            }else{
                left = mid + 1; // 탐색하는 값이 lis 배열 중앙에 위치한 값보다 큰 경우 left를 mid + 1로 증가시켜 탐색 범위를 좁힌다.
            }
        }
        return left;
    }
}