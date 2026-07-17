package com.soi.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class POG_42893 {
    public int solution(String word, String[] pages) {
        HashMap<String, Page> pageHashMap = new HashMap<>();
        for (int p = 0; p < pages.length; p++) {
            Page page = new Page(p, pages[p]);
            page.calculateWordAppearance(word);
            page.updateSoloLinkScore();
            page.calculateMatchScore();
            pageHashMap.put(page.link, page);
        }

        for (Page page : pageHashMap.values()) {
            for (String link : page.externalLinks) {
                if (pageHashMap.containsKey(link)) {
                    Page linkedPage = pageHashMap.get(link);
                    linkedPage.addLinkScore(page.soloLinkStore);
                }
            }
        }
        for (Page page : pageHashMap.values()) {
            page.calculateMatchScore();
        }
        Page page = pageHashMap.values().stream().sorted().findFirst().orElseThrow(IllegalStateException::new);
        return page.idx;
    }


    private static class Page implements Comparable<Page> {
        String html;
        String link;
        String body;
        String head;

        int idx;
        int baseScore;
        double soloLinkStore;
        double linkScore;
        double matchScore;
        Set<String> externalLinks;

        @Override
        public String toString() {
            return "Page{" +
                    ", link='" + link + '\'' +
                    ", body='" + body + '\'' +
                    ", baseScore=" + baseScore +
                    ", soloLinkStore=" + soloLinkStore +
                    ", linkScore=" + linkScore +
                    ", matchScore=" + matchScore +
                    ", externalLinks=" + externalLinks +
                    '}';
        }

        public Page(int idx, String html) {
            this.idx = idx;
            this.html = html;

            this.baseScore = 0;
            this.externalLinks = new HashSet<>();

            this.head = parseHead();
            this.link = parseLink();
            this.body = parseBody();
        }

        private String parseLink() {
            Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(head);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        }

        private String parseBody() {
            String body = html.substring(html.indexOf("<body>") + 6, html.indexOf("</body>"));
            Pattern pattern = Pattern.compile("<a href=\"([^\"]+)\">.*?</a>");
            Matcher matcher = pattern.matcher(body); // 패턴 매칭 수행
            while (matcher.find()) {
                externalLinks.add(matcher.group(1));
                body = body.replace(matcher.group(0), "");
            }
            return body;
        }

        private String parseHead() {
            return html.substring(html.indexOf("<head>") + 6, html.indexOf("</head>"));
        }

        public void calculateWordAppearance(String word) {
            int count = 0;
            word = word.toUpperCase();
            for (String w : html.replace("\t", " ").replace("\n", " ").toUpperCase().split("[^A-Z]+")) {
                if (w.equals(word)) count++;
            }
            this.baseScore = count;
        }

        private void calculateMatchScore() {
            this.matchScore = this.baseScore + this.linkScore;
        }

        public void addLinkScore(double linkScore) {
            this.linkScore += linkScore;
        }

        public void addLink(String link) {
            this.externalLinks.add(link);
        }

        @Override
        public int compareTo(Page page) {
            int cmp = Double.compare(page.matchScore, this.matchScore); // 내림차순
            return cmp == 0 ? this.idx - page.idx : cmp;
        }

        public void updateSoloLinkScore() {
            if (externalLinks.isEmpty()) {
                return;
            }
            this.soloLinkStore = (double) baseScore / externalLinks.size();
        }
    }
}
