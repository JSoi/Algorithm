package programmers;

import java.util.*;

public class L72412 {
	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		System.out.println(Arrays.toString(solution1(info, query)));
	}


	public static int[] solution1(String[] info, String[] query) {
		int[] answer = new int[query.length];
		Person[] ppl = new Person[info.length];
		for (int i = 0; i < info.length; i++) {
			String onePerson = info[i];
			// String lang, String bf, String js, String cp, int score;
			String lang = onePerson.split(" ")[0];
			String bf = onePerson.split(" ")[1];
			String js = onePerson.split(" ")[2];
			String cp = onePerson.split(" ")[3];
			String score = onePerson.split(" ")[4];
			ppl[i] = new Person(lang, bf, js, cp, score);
		}
		for (int j = 0; j < query.length; j++) {
			String score = query[j].substring(query[j].lastIndexOf(" ") + 1);
			String[] condition = query[j].substring(0, query[j].lastIndexOf(" ")).split(" and ");
			for (int k = 0; k < ppl.length; k++) {
				if (ppl[k].meet(condition[0], condition[1], condition[2], condition[3], score)) {
					answer[j]++;
				}
			}
		}
		return answer;
	}
}

class Person {
	String lang, bf, js, cp, score;

	public Person(String lang, String bf, String js, String cp, String score) {
		this.lang = lang;
		this.bf = bf;
		this.js = js;
		this.cp = cp;
		this.score = score;
	}

	public boolean meet(String lang, String bf, String js, String cp, String score) {
		if (!this.lang.equals(lang) && !lang.equals("-"))
			return false;
		if (!this.bf.equals(bf) && !bf.equals("-"))
			return false;
		if (!this.js.equals(js) && !js.equals("-"))
			return false;
		if (!this.cp.equals(cp) && !cp.equals("-"))
			return false;
		if (Integer.parseInt(this.score) < Integer.parseInt(score) && !score.equals("-"))
			return false;
		return true;
	}
}
