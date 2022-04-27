package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L92334_2 {//runtimeerror

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(solution(new String[] { "muzi", "frodo", "apeach", "neo" }, new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi" }, 2)));
	}

	static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		int[] reportCount = new int[report.length];
		HashMap<String, Group> map = new HashMap<>();
		for (int i = 0; i < id_list.length; i++) {
			Group g = new Group(id_list[i], i);
			map.put(id_list[i],  g);
		}
		List<String> reportList = Stream.of(report).distinct().collect(Collectors.toList());
		for (int i = 0; i < reportList.size(); i++) {
			String reporter = reportList.get(i).split(" ")[0];
			String reported = reportList.get(i).split(" ")[1];
			Group g = map.get(reporter);
			g.addMemeber(reported);
			reportCount[map.get(reported).index]++;
		}
		ArrayList<String> finalReport = new ArrayList<String>();
		for (int i = 0; i < reportCount.length; i++) {
			if (reportCount[i] >= k)
				finalReport.add(id_list[i]);
		}
		for (Map.Entry<String, Group> e : map.entrySet()) {
			for (String bum : finalReport) {
				if (e.getValue().reported.contains(bum)) {
					answer[e.getValue().index]++;
				}
			}
		}

		return answer;
	}

	static class Group {
		String name;
		int index;
		Set<String> reported;

		Group(String name, int index) {
			this.name = name;
			this.index = index;
			reported = new HashSet<String>();
		}

		void addMemeber(String mem) {
			reported.add(mem);
		}
	}
}
