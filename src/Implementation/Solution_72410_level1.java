package Implementation;/*

아이디 정제 과정
1. 모든 대문자 -> 소문자로 변환
2. 알파벳 소문자, 숫자, -, _, .를 제외한 모든 문자를 제거
3. .가 2번이상 연속된 부분을 하나의 마침표로 치환
4. .가 처음이나 끝에 위치한다면 제거
5. 빈 문자열이라면 "a"를 대입
6. 길이가 16자 이상이라면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
    -> 제거 후 .가 끝에 위치한다면 .를 제거
7. 길이가 2자 이하라면 마지막 문자를 길이가 3이 될때까지 추가
 */


class Solution_72410_level1 {
    public String solution(String new_id) {
        String answer = "";
        String id = new_id;

        // 1단계
        id = id.toLowerCase();

        // 2단계
        String temp = "";
        for(int i=0; i<id.length(); i++) {
            char c = id.charAt(i);
            if(('a'<= c && c <= 'z') || ('0'<= c && c <= '9') || c == '-' || c== '_' || c == '.') temp += c;
        }
        id = temp;
        // 3단계
        while(id.contains(".."))
            id = id.replace("..", ".");

        // 4단계
        if(id.length()>0 && id.charAt(0) == '.') id = id.substring(1);
        if(id.length()>0 && id.charAt(id.length()-1) == '.') id = id.substring(0, id.length()-1);

        // 5단계
        if(id.length() == 0) id = "a";

        // 6단계
        if(id.length()>=16) {
            id = id.substring(0, 15);
            if(id.charAt(id.length()-1) == '.') id = id.substring(0, id.length()-1);
        }

        // 7단계
        char lastChar = id.charAt(id.length()-1);
        while(id.length() < 3) {
            id += lastChar;
        }


        return id;
    }
}