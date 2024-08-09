/*
1. 공부 기록 개수(N) 입력
2. 공부 기록을 일반 학습 기록과 백준 문제 링크 번호를 각각 다른 List에 저장
3. 백준 문제 링크인 경우 문제 번호를 추출하여 저장
4. 일반 학습 기록은 studyMemo에 저장
5. 백준 문제 번호를 오름차순으로 정렬
6. 일반 학습 기록 정렬
7. 일반 학습 기록과 백준 문제 링크 출력
*/
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 2. 공부 기록을 일반 학습 기록과 백준 문제 링크 번호를 각각 다른 List에 저장
        ArrayList<String> studyMemo = new ArrayList<>(); // 일반 학습 기록
        ArrayList<Integer> boj = new ArrayList<>(); // 백준 문제 링크 번호를 담을 배열

        for (int i = 0; i < N; i++) {
            String memo = br.readLine();
            // 3. 백준 문제 링크인 경우 문제 번호를 추출하여 저장
            if (memo.contains("boj.kr/")) {
                int num = Integer.parseInt(memo.substring(7));
                boj.add(num);
            } else { // 4. 일반 학습 기록은 studyMemo에 저장
                studyMemo.add(memo);
            }
        }
        
        // 5. 백준 문제 번호를 오름차순으로 정렬
        Collections.sort(boj);

        // 6. 일반 학습 기록 정렬
        Collections.sort(studyMemo, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() == b.length()) { // 비교 중인 문자열의 길이가 같은 경우
                    return a.compareTo(b); // 사전 순 정렬 
                }else{ 
                    return a.length() - b.length(); // 길이 순 정렬
                }
            }
        });

        // 7. 일반 학습 기록과 백준 문제 링크 출력
        for (int i = 0; i < studyMemo.size(); i++) {
            sb.append(studyMemo.get(i)).append("\n");
        }

        for (int i = 0; i < boj.size(); i++) {
            sb.append("boj.kr/").append(boj.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}