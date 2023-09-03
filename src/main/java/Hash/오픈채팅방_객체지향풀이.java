package Hash;

import java.util.*;

public class 오픈채팅방_객체지향풀이 {

    private static final String ENTER_FORMAT = "%s님이 들어왔습니다.";
    private static final String LEAVE_FORMAT = "%s님이 나갔습니다.";

    public static class UserInfo {
        public String nickName;

        public UserInfo(String nickName) {
            this.nickName = nickName;
        }
    }

    public static String[] solution(String[] records) {
        Map<String, UserInfo> userMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String command = split[0];
            String userId = split[1];
            String nickName;

            switch (command) {
                case "Enter":
                    nickName = split[2];
                    userMap.put(userId, new UserInfo(nickName));
                    result.add(userId + " " + command);
                    break;
                case "Leave":
                    result.add(userId + " " + command);
                    break;
                case "Change":
                    nickName = split[2];
                    userMap.get(userId).nickName = nickName;
                    break;
            }
        }

        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            String[] cmd = result.get(i).split(" ");
            String userId = cmd[0];
            String command = cmd[1];
            String nickName = userMap.get(userId).nickName;

            answer[i] = String.format(command.equals("Enter") ? ENTER_FORMAT : LEAVE_FORMAT, nickName);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        System.out.println(Arrays.toString(solution(record)));
    }
}
