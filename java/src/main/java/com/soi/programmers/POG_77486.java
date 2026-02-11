package com.soi.programmers;

import java.util.HashMap;

public class POG_77486 {
    public static void main(String[] args) {
        new POG_77486().solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}
        );
    }


    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        HashMap<String, Seller> sellerMap = new HashMap<>();
        for (String e : enroll) {
            sellerMap.put(e, new Seller(e));
        }
        for (int i = 0; i < referral.length; i++) {
            if (referral[i].equals("-")) {
                continue;
            }
            sellerMap.get(enroll[i]).addReferral(sellerMap.get(referral[i]));
        }
        for (int i = 0; i < seller.length; i++) {
            sellerMap.get(seller[i]).addMoney(amount[i] * 100);
        }
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sellerMap.get(enroll[i]).totalMoney;
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private static class Seller {
        String name;
        Seller referral;
        int totalMoney;

        public Seller(String name) {
            this.name = name;
        }

        void addReferral(Seller referral) {
            this.referral = referral;
        }

        void addMoney(int sellMoney) {
            int referralMoney = sellMoney / 10;
            this.totalMoney += (sellMoney - referralMoney);
            if (referral != null) {
                referral.addMoney(referralMoney);
            }
        }
    }
}
