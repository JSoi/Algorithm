package com.soi.programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class L17676 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String input[] = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		String input2[] = { "2016-09-15 00:00:00.000 3s" };
		//System.out.println(solution2(input));
		System.out.println(solution(input));
	}

	static int solution(String[] lines) throws ParseException {

		int answer = 0;
		ArrayList<Date[]> arr = new ArrayList<Date[]>();
		Date[] endDate = new Date[lines.length];
		Date[] startDate = new Date[lines.length];
		SimpleDateFormat S = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		for (int i = 0; i < lines.length; i++) {
			endDate[i] = S.parse(lines[i].split(" ")[0] + " " + lines[i].split(" ")[1]);
			String ms = lines[i].split(" ")[2];

			String t = ms.substring(0, ms.indexOf("s"));
			long time = 0;
			if (t.contains(".")) {
				time += Long.parseLong(t.substring(0, t.indexOf("."))) * 1000;
				time += Long.parseLong(t.substring(t.indexOf(".") + 1));
			} else {
				time = Long.parseLong(t) * 1000;
			}
			startDate[i] = new Date(endDate[i].getTime() - time + 1);

			Date[] dateArr = new Date[2];
			dateArr[0] = startDate[i];
			dateArr[1] = endDate[i];
			arr.add(dateArr);
		}
		for (int i = 0; i < arr.size(); i++) {
			long starti = arr.get(i)[1].getTime();
			long endi = starti + 1000;
			int temp = 0;
			for (int j = 0; j < arr.size(); j++) {
				long startj = arr.get(j)[0].getTime();
				long endj = arr.get(j)[1].getTime();
				if ((endi - startj) <= 0) {
					continue;
				}
				if (((starti - startj) <= 0 && (endi - startj) > 0) || ((starti - endj) <= 0 && (endi - endj) > 0)
						|| ((starti - startj) > 0 && (starti - endj) <= 0)) {
					temp++;
				}

			}
			// �ִ밪 ����
			answer = Math.max(answer, temp);
		}
		return answer;
	}
}
