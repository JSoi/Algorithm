package com.soi.leetcode;

public class LC_simplify_path {
    public static void main(String[] args) {
        LC_simplify_path lc = new LC_simplify_path();
        String path = "/a/./b/../../c/";
        String result = lc.simplifyPath(path);
        System.out.println(result);
    }

    public String simplifyPath(String path) {
        // "//" -> "/"
        path = path.replaceAll("/+", "/");
        String[] paths = path.split("/");
        StringBuilder answer = new StringBuilder();
        for (String p : paths) {
            if (p.equals(".") || p.isEmpty()) {
                continue;
            }
            if (p.equals("..")) {
                if (!answer.isEmpty()) {
                    answer.delete(answer.lastIndexOf("/"), answer.length());
                }
            } else {
                answer.append("/").append(p);
            }
        }
        return answer.isEmpty() ? "/" : answer.toString();
    }
}
