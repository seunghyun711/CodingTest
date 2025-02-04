/*
1. n 입력
2. 포트 연결 정보 입력
3. LIS를 이용해 최대 포트 연결 개수를 구한다.
    - 실제 LIS를 통해 정렬한 배열의 각 인덱스 값은 실제 연결되는 포트와 다를 수 있다.
    - 포트 연결을 최대로 하기 위해서는 선이 꼬이지 않도록 연결해야 하는데 이렇게 연결하려면
    1번 포트부터 연결되는 포트의 번호가 점차 커져야(그림상 오른쪽 아래로 연결)되어야 선이 꼬이지 않고
    최대로 연결을 할 수가 있다. LIS는 최대 증가 수열로 LIS를 통해 얻어진 요소의 수가 결국 최대 연결 개수가 된다.
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. n 입력
        int n = Integer.parseInt(br.readLine());
        
        // 2. 포트 연결 정보 입력
        int[] port = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            port[i] = Integer.parseInt(st.nextToken());
        }
        
        List<Integer> lis = new ArrayList<>(); // lis 결과를 담을 리스트
        
        // 3. LIS를 이용해 최대 포트 연결 개수를 구한다.
        for(int p : port){
            int index = bs(lis, p); // 이진탐색을 통해 구한 다음 포트 번호가 들어갈 위치
            if(index == lis.size()){ // lis의 맨 끝에 추가
                lis.add(p);
            }else{
                lis.set(index, p); // 위치 변경
            }
        }
        
        // 4. 결과 출력
        System.out.println(lis.size());
    }
    
    // 이진탐색 메서드
    static int bs(List<Integer> lis, int key){
        int left = 0;
        int right = lis.size();
        while(left < right){
            int mid = (left + right) / 2; // 중간 값
            if(lis.get(mid) >= key){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}