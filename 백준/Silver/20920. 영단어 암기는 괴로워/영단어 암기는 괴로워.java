/*
1. N, M 입력
2. 단어 입력
3. 우선순위에 따라 입력받은 단어 정렬
4. 결과 출력
*/
import java.io.*;
import java.util.*;

class Words implements Comparable<Words> {
    String word;
    int count; 
    
    public Words(String word){
        this.word = word;
        count = 1;
    }
    
    public void addCount(){ // 단어 빈도수
        this.count++;
    }
    
    @Override
    public int compareTo(Words w){
        if(this.count != w.count){ // 자주 나오는 단어일수록 앞에 배치한다.
            return w.count - this.count;
        }
        if(this.word.length() != w.word.length()){ // 해당 단어의 길이가 길수록 앞에 배치한다.
            return w.word.length() - this.word.length();
        }
        return this.word.compareTo(w.word); // 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 1. N, M 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. 단어 입력
        Map<String, Words> wm = new HashMap<>();
        List<Words> wl = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String word = br.readLine();
            // 3. 우선순위에 따라 입력받은 단어 정렬
            if(word.length() < M){ // 입력받은 단어의 길이가 M보다 짧은 경우 넘어감
                continue;
            }
            if(!wm.containsKey(word)){ // 처음 입력받은 단어의 경우 Words객체를 생성
                Words w = new Words(word);
                wm.put(word, w);
                wl.add(w);
            }else{ // 기존에 입력받았던 단어를 다시 입력받은 경우 해당 단어의 count 증가
                wm.get(word).addCount();
            }
        }
        Collections.sort(wl);
        
        // 4. 결과 출력
        for (Words w : wl) {
            sb.append(w.word).append("\n");
        }
        System.out.println(sb);
    }
}