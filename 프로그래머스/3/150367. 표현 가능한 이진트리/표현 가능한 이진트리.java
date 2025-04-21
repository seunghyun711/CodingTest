/*
1. 주어진 십진수를 이진수로 변환
2. 1번을 통해 얻은 이진수를 가지고 포화 이진트리로 만들 수 있는지 확인. 만들 수 없다면 더미 값을 넣어 포화 이진트리가 될 수 있도록 가공
3. 2번을 통해 얻은 이진수가 포화 이진트리인지 확인하여 이에 따라 결과 리턴
*/
class Solution {
    static int result;
    static String binary;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        // 1. 주어진 십진수를 이진수로 변환
        for(int i = 0; i < numbers.length; i++){
            binary = Long.toBinaryString(numbers[i]);
            // 2. 1번을 통해 얻은 이진수를 가지고 포화 이진트리로 만들 수 있는지 확인. 만들 수 없다면 더미 값을 넣어 포화 이진트리가 될 수 있도록 가공
            int binaryLength = binary.length();
            int addZero; // 추가해야 할 더미 데이터(0) 개수;
            int n = 1;
            while(true){
                n *= 2;
                if((n - 1) >= binaryLength){ 
                    addZero = (n - 1) - binaryLength; // 추가할 더미 데이터의 개수 
                    break;
                }
            }
            for(int j = 0; j < addZero; j++){ // 더미 데이터 추가
                binary = "0" + binary;
            }
            // 3. 2번을 통해 얻은 이진수가 포화 이진트리인지 확인하여 이에 따라 결과 리턴
            result = 1;
            int start = 0;
            int end = binary.length() - 1;
            
            checkFullBt(start, end);
            answer[i] = result;
        }
        
        return answer;
        
    }
    
    // 포화 이진트리인지 검증하는 메서드
    static void checkFullBt(int start, int end){
        
        if(start > end){
            return;
        }
        
        int mid = (start + end) / 2; // 최상위 루트 노드의 인덱스
        char root = binary.charAt(mid);
        
        // 리프 노드인 경우 종료
        if(start == end){
            return;
        }
        
        // 왼쪽과 오른쪽 서브트리 먼저 검사
        checkFullBt(start, mid - 1);
        checkFullBt(mid + 1, end);
        
        // 루트 노드의 값이 0인데 자식 노드의 값이 1인 경우는 포화 이진트리가 아님
        if(root == '0'){
            for(int i = start; i <= end; i++){
                if(i == mid){
                    continue;
                }
                if(binary.charAt(i) == '1'){
                    result = 0;
                    return;
                }
            }
        }
        
        
    }
}