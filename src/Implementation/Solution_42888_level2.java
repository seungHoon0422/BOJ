package Implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution_42888_level2 {

    private static Map<String, String> dns;
    private static List<Chat> chatRoom;
    public String[] solution(String[] records) {
        String[] answer = {};

        dns = new HashMap<>();
        chatRoom = new ArrayList<>();

        for (String record : records) {

            String[] recordSplit = record.split(" ");

            String state = recordSplit[0];
            String uid = recordSplit[1];

            if ("Enter".equals(state)) {
                String name = recordSplit[2];
                if (!dns.containsKey(uid)) {
                    dns.put(uid, name);
                } else {
                    dns.put(uid, name);
                }
                chatRoom.add(new Chat(uid, state));

            } else if ("Leave".equals(state)) {
                chatRoom.add(new Chat(uid, state));
            } else if ("Change".equals(state)) {
                String name = recordSplit[2];
                dns.put(uid, name);
            }
        }

        answer = new String[chatRoom.size()];
        int index = 0;

        for (Chat chat : chatRoom) {
            String output = dns.get(chat.uid) + "님이 ";
            if("Enter".equals(chat.state))
                output += "들어왔습니다.";
            else
                output += "나갔습니다.";
            answer[index++] = output;
        }

        return answer;
    }

    static class Chat {
        String uid;
        String state;

        public Chat(String uid, String state) {
            this.uid = uid;
            this.state = state;
        }
    }

}