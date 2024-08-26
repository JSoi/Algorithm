package programmers;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class L72412 {
    public void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        System.out.println(Arrays.toString(new L72412().solution(info, query)));
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Person[] ppl = new Person[info.length];
        HashMap<String, Person> map = new HashMap<>();
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
        int index = 0;
        for (String string : query) {
            String[] condition = string.replace(" and ", " ").split(" ");
            answer[index++] = (int) Arrays.stream(ppl).filter(p -> p.meet(condition[0], condition[1], condition[2], condition[3], condition[4])).count();
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

    public boolean meet(String target, Predicate<Person> predicate) {
        return predicate.test(this);
    }

    private String target(String target) {
        return switch (target) {
            case "lang" -> this.lang;
            case "bf" -> this.bf;
            case "cp" -> this.cp;
            case "js" -> this.js;
            case "score" -> String.valueOf(this.score); // Convert score to String
            default -> throw new IllegalStateException("Unexpected value: " + target);
        };
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
