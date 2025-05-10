/*
1. t 입력
2. 전화번호의 수 입력
3. 전화번호 입력을 하면서 해당 전화번호에 전화를 걸 수 있는지 파악
4. 결과 출력
*/
import java.io.*;
import java.util.*;
class Node{
    HashMap<Character, Node> child;
    boolean endOfWord; // 해당 노드가 전화번호의 끝인지 파악하는 변수
    
    public Node() {
        this.child = new HashMap<>();
        this.endOfWord = false;
    }
}

// 트라이 알고리즘을 사용하기 위한 클래스
class Trie{
    Node root;
    
    public Trie(){
        this.root = new Node();
    }
    
    // 전화번호 삽입 
    public void insert(String num){
        // 시작 노드를 루트 노드로 설정(루트 노드에는 값이 없음)
        Node node = this.root;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            // 문자열의 각 단어를 가져와서 자식 노드 중에 있는지 체크
            node.child.putIfAbsent(c, new Node());// 해당 문자가 있다면 해당 value를 반환하고, 없다면 새로운 Node객체를 생성해서 넣음
            node = node.child.get(c); // 자식 노드로 이동

            if (i == num.length() - 1) {
                node.endOfWord = true;
                return;
            }

        }
    }
    
    // 전화번호 탐색
    public boolean search(String num){
        Node node = this.root;
        
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            
            // 자식 노드에 c가 있는 경우 탐색 진행
            if(node.child.containsKey(c)){
                node = node.child.get(c);
            }else{
                return false;
            }
        }
        // 현재 탐색 중인 전화번호의 일부가 하나의 번호로 존재하는 경우(일관성 유지X)
        if(node.endOfWord){
            if(node.child.isEmpty()){
                return false;
            }
        }
        // 마지막 노드까지 도달한 경우
        return true;
    }
}
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. t 입력
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++){
            // 2. 전화번호의 수 입력
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            boolean isConsistent = true; // 일관성 유지 여부
            
            // 3. 전화번호 입력을 하면서 해당 전화번호에 전화를 걸 수 있는지 파악
            List<String> numList = new ArrayList<>();
            for(int j = 0; j < n; j++){
                String num = br.readLine(); // 전화번호 입력
                trie.insert(num);
                numList.add(num);
            }
            
            for(String nl : numList){
                if(trie.search(nl)){ // search()가 true면 num의 일부가 하나의 전화번호로 존재(일관성 유지X)
                    isConsistent = false;
                    break;
                }
            }
            // 4. 결과 출력
            if(isConsistent){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}