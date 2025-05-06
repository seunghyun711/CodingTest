/*
1. N 입력
2. 스테이크의 두께 입력
3. 유클리드 호제법을 이용해 최대공약수를 구하고 그 최대공약수를 가지고 최소 공배수를 구함
4. 3번을 통해 얻은 최소 공배수는 스테이크 한 면을 굽는데 걸리는 시간이므로 최소 공배수 * 2를 하여 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. N 입력
        int N = Integer.parseInt(br.readLine());

        // 2. 스테이크의 두께 입력
        st = new StringTokenizer(br.readLine());
        int[] thick = new int[N];
        for(int i = 0; i < N; i++){
            thick[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. 유클리드 호제법을 이용해 최대공약수를 구하고 그 최대공약수를 가지고 최소 공배수를 구함
        long result = getResult(thick);
        
        // 4. 3번을 통해 얻은 최소 공배수는 스테이크 한 면을 굽는데 걸리는 시간이므로 최소 공배수 * 2를 하여 출력
        System.out.println(result * 2);
        
    }
    
    // 결과를 계산하는 메서드
    static long getResult(int[] thick){
        long r = thick[0];
        for(int i = 1; i < thick.length; i++){
            r = getLCM(thick[i], r); // 최소 공배수  
        }
        return r;
    }
    
    // 최소 공배수를 구하는 메서드
    static long getLCM(long a, long b){
        return (a * b) / getGCD(a, b);
    }
    
    // 최대 공약수를 구하는 메서드
    static long getGCD(long a, long b){
        if(a % b == 0){
            return b;
        }
        return getGCD(b, a % b);
    }
}