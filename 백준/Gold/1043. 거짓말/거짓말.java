/*
1. 사람의 수(N)와 파티의 수(M) 입력
2. 진실을 아는 사람의 수와 그 사람의 번호 입력
3. 파티에 오는 사람의 수와 그 사람의 번호 입력
4. 진실을 아는 사람과 연관되지 않은 사람들로 구성된 파티의 수를 계산
*/
import java.io.*;
import java.util.*;
public class Main{
    static int N; // 사람의 수
    static int M; // 파티의 수
    static ArrayList<Integer>[] parties, participants; // 파티와 참여자를 나타내는 리스트
    static boolean[] truth; // 거짓말을 할 수 있는지 판단하는 배열
    static int[] known; // 거짓말임을 알고 있는 사람의 번호를 담을 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0; // 거짓말을 할 수 있는 파티의 개수
        
        // 1. 사람의 수(N)와 파티의 수(M) 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        truth = new boolean[M];
        
        // parties 리스트 초기화
        parties = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            parties[i] = new ArrayList<>();
        }
        
        // participants 리스트 초기화
        participants = new ArrayList[M];
        for(int i = 0; i < M; i++){
            participants[i] = new ArrayList<>();
        }
        
        // 2. 진실을 아는 사람의 수와 그 사람의 번호 입력
        st = new StringTokenizer(br.readLine());
        int knowTruth = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
        known = new int[knowTruth];
        
        // 진실을 아는 사람의 번호 입력
        for(int i = 0; i < knowTruth; i++){
            known[i] = Integer.parseInt(st.nextToken());
        }
        
        // 3. 파티에 오는 사람의 수와 그 사람의 번호 입력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 파티에 참여하는 사람의 수
            for(int j = 0; j < num; j++){
                int person = Integer.parseInt(st.nextToken());
                parties[person].add(i); // person이 참여한 파티
                participants[i].add(person); // i번째 파티에 참여한 person
            }
        }
        
        // 4. 진실을 아는 사람과 연관되지 않은 사람들로 구성된 파티의 수를 계산
        for(int i = 0; i < known.length; i++){
            dfs(known[i]);
        }
        
        // 거짓말을 할 수 있는 파티의 수 계산
        for(int i = 0; i < truth.length; i++){
            if(!truth[i]){
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    // dfs
    static void dfs(int knownPerson){
        // 진실을 알고 있는 사람의 번호를 받아 해당 번호가 속한 파티부터 dfs 진행
        for(int i = 0; i < parties[knownPerson].size(); i++){
            int party = parties[knownPerson].get(i); // 진실을 알고 있는 사람이 속한 파티
            
            if(!truth[party]){
                truth[party] = true; // 해당 파티에서는 거짓말을 알 수 없다.
                
                for(int j = 0; j < participants[party].size(); j++){
                    int next = participants[party].get(j); // 다음 탐색 대상
                    dfs(next); 
                }
            }
        }
    }
}