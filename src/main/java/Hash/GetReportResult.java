package Hash;

import java.util.*;
import java.util.stream.Collectors;

public class GetReportResult {

    /*

    (문제) 신고 결과 받기
    신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.

    각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
    신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
    한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
    k번 이상 신고된 유저는 게시판 이용이 정지되며,
    해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
    유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.

    (예시)
    id_list : ["muzi", "frodo", "apeach", "neo"]
    report : ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
    k : 2
    result : [2, 1, 1, 0]

     */

    public static void main(String[] args) {
        GetReportResult getReportResult = new GetReportResult();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] result = getReportResult.solve_with_hash(id_list, report, k);
        for (int i : result) {
            System.out.println(i + " ");
        }
    }

    public int[] solve_with_hash(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 1. 중복제거 - report 배열의 정보를 hashSet으로 옮겨서 중복을 제거
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));


        // 2. 신고자 목록 관리 - hash로 각 사용자를 신고한 사람들의 목록을 관리한다.
        // (ex) key (신고 당한사람)  | value (신고 결과를 받는 사람 = 신고한 사람)
        //      frodo             | <muzi, apeach>
        //      neo               | <frodo, muzi>
        //      muzi              | <apeach>
        HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();

        for (String rep : reportSet) {
            int blankIndex = rep.indexOf(" ");
            String reporter = rep.substring(0, blankIndex);
            String reportee = rep.substring(blankIndex + 1);

            ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
            if (reporterList == null) {
                reporterList = new ArrayList<>();
            }

            reporterList.add(reporter);
            notifyListHash.put(reportee, reporterList);
        }

        // 3. 신고한 사용자 - 신고한 사용자에게 정지된 사용자를 알려주고, 이 정보를 hash로 관리
        // (ex) key    | value
        //      muzi   | 2
        //      apeach | 1
        //      frodo  | 1
        HashMap<String, Integer> reporterHash = new HashMap<>();
        for (ArrayList<String> notifyList : notifyListHash.values()) {
            if (notifyList.size() >= k) {
                for (String reporter : notifyList) {
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = reporterHash.getOrDefault(id_list[i], 0);
        }

        return answer;
    }


    public int[] solve_with_streamAPI(String[] id_list, String[] report, int k) {

        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for(String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reporterList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reporterList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();

    }
}
