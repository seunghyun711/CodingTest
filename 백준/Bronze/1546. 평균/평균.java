import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int max = -1;
        double sum = 0;
        for(int i = 0; i<n; i++){
            int v = Integer.parseInt(st.nextToken());
            if(v>max){
                max = v;
            }
            sum+=v;
        }
        System.out.println((sum/max) * 100 /n);
    }
}