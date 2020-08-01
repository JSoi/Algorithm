package programmers;

public class L17683 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out
				.println(solution("ABCDEFG", new String[] { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" }));
	}

	static String solution(String m, String[] musicinfos) {
		String answer = "";
		int playTime = 0;
		String[] change = { "C#", "D#", "F#", "G#", "A#" };
		String[] replace = { "V", "W", "X", "Y", "Z" };
		for (int a = 0; a < change.length; a++) {
			m = m.replace(change[a], replace[a]);
		}
		for (int i = 0; i < musicinfos.length; i++) {
			String[] split = musicinfos[i].split(",");
			int f = Integer.parseInt(split[1].split(":")[0]) * 60 + Integer.parseInt(split[1].split(":")[1]);
			int n = Integer.parseInt(split[0].split(":")[0]) * 60 + Integer.parseInt(split[0].split(":")[1]);
			int time = Math.abs(f - n);
			String title = split[2];
			String info = split[3];
			for (int a = 0; a < change.length; a++) {
				info = info.replace(change[a], replace[a]);
			}
			int albumTime = info.length();
			String music = "";
			for (int k = 0; k < time; k++) {
				music += info.charAt(k % albumTime);
			}
			System.out.println(music);
			if (music.contains(m) && playTime < time) {
				answer = title;
				playTime = time;
			}
		}
		if (answer.equals(""))
			return "(None)";
		else
			return answer;
	}
}
