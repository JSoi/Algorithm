package programmers;
import java.util.*;
public class L42576 {
	public static void main(String args[]) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		System.out.println(solution(participant, completion));
	}
	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> completionMap = new HashMap<String, Integer>();
        for(int c = 0; c < completion.length; c++) {      
            if(completionMap.containsKey(completion[c])){
                completionMap.put(completion[c], completionMap.get(completion[c]) + 1);
            }
            else{
                completionMap.put(completion[c], 1);
            }
        }
        for(int p = 0; p < participant.length; p++) {
            if(!completionMap.containsKey(participant[p])){
                return participant[p];
            }
            else{
                completionMap.put(participant[p], completionMap.get(participant[p]) - 1);
            }
        }
        for (String ans : completionMap.keySet()) {
            if (completionMap.get(ans)!=0) return ans;
        }
        return "";
     }
}
//
