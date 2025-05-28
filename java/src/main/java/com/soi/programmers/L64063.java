package com.soi.programmers;

import java.util.HashMap;
import java.util.Map;

public class L64063 {
    Map<Long, Long> occupied =  new HashMap<>();
    public long[] solution(long k, long[] roomArr) {
        long[] answer = new long[roomArr.length];
        // 요청 방 & 실제 들어간 방
        occupied =  new HashMap<>();
        for (int i = 0 ; i < roomArr.length; i++) {
            answer[i] = getNo(roomArr[i]);
        }
        return answer;
    }
    long getNo(long roomNo){
        if (!occupied.containsKey(roomNo)) {
            occupied.put(roomNo, roomNo);
            return roomNo;
        }
        return getNo(occupied.get(roomNo) + 1);
    }
}
