package com.soi.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC_stream_of_characters {
    private static class StreamChecker {
        private static class CharTree {
            private int depth;
            private boolean hasEnd;
            private Map<Character, CharTree> children;

            public CharTree() {
                this.children = new HashMap<>();
            }

            private void addWord(String str) {
                if (this.depth + 1 > str.length()) {
                    return;
                }
                if (this.depth + 1 == str.length()) {
                    this.hasEnd = true;
                    return;
                }
                char childChar = str.charAt(this.depth + 1);
                if (children.containsKey(childChar)) {
                    children.get(childChar).addWord(str);
                } else {
                    CharTree child = new CharTree();
                    child.depth = this.depth + 1;
                    children.put(childChar, child);
                    child.addWord(str);
                }
            }

            private boolean isSuffix(String str) {
                if (hasEnd) {
                    return true;
                }
                if (str.length() <= this.depth + 1 || !children.containsKey(str.charAt(this.depth + 1))) {
                    return false;
                }
                return children.get(str.charAt(this.depth + 1)).isSuffix(str);
            }
        }

        private StringBuilder sb = new StringBuilder();
        private CharTree root;

        public StreamChecker(String[] words) {
            root = new CharTree();
            root.depth = -1;
            for (String word : words) {
                addWordToTree(word);
            }
        }

        public void addWordToTree(String word) {
            String reversed = new StringBuilder(word).reverse().toString();
            root.addWord(reversed);
        }

        public boolean query(char letter) {
            sb.append(letter);
            if (sb.length() > 200) {
                sb.deleteCharAt(0);
            }
            return root.isSuffix(sb.toString());
        }
    }
}
