package com.soi.baekjoon

import java.util.Scanner

class N2292 {

}

private fun getAnswer(userInteger:Long) :Long {
    var lastNumber = 1L;
    var timeCal = 0L;
    while (true) {
        if (lastNumber <= userInteger && userInteger <= lastNumber + timeCal * 6) {
            break
        }
        lastNumber += timeCal * 6
        timeCal++
    }
    return timeCal + 1;
}

fun main() {
    val scan = Scanner(System.`in`)
    println(getAnswer(scan.nextLong()))
}