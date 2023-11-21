/*
1. 세 점의 좌표 입력
2. 세 점의 좌표 중 특정 좌표의 x값과 y값이 각각 다른 점의 좌표의 x값과 y값에 쌍을 이루지 않은 값을 찾는다.
3. 2번을 통해 얻은 x,y값이 나머지 한 점의 좌표다.
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 1. 세 점의 좌표 입력
        int[] coordinate1 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 좌표1
        
        st = new StringTokenizer(br.readLine(), " ");
        int[] coordinate2 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 좌표2
        
        st = new StringTokenizer(br.readLine(), " ");
        int[] coordinate3 = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 좌표3
        
        int x; // x값
        int y; // y값
        
        // 2. 세 점의 좌표 중 특정 좌표의 x값과 y값이 각각 다른 점의 좌표의 x값과 y값에 쌍을 이루지 않은 값을 찾는다.
        if(coordinate1[0] == coordinate2[0]){
            x = coordinate3[0];
        }
        else if(coordinate1[0] == coordinate3[0]){
            x = coordinate2[0];
        }else{
            x = coordinate1[0];
        }
        
        if(coordinate1[1] == coordinate2[1]){
            y = coordinate3[1];
        }
        else if(coordinate1[1] == coordinate3[1]){
            y = coordinate2[1];
        }else{
            y = coordinate1[1];
        }
        
        // 3. 2번을 통해 얻은 x,y값이 나머지 한 점의 좌표다.
        System.out.println(x + " " + y);
    }
}