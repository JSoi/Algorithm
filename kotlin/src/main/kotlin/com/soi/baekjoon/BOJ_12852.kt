package com.soi.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[1] = 0

    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1
        if (i % 2 == 0) dp[i] = minOf(dp[i], dp[i / 2] + 1)
        if (i % 3 == 0) dp[i] = minOf(dp[i], dp[i / 3] + 1)
    }

    println(dp[n])

    var idx = n
    var count = dp[n]
    val sb = StringBuilder()
    sb.append(idx).append(" ")

    while (idx > 1) {
        if (idx % 3 == 0 && dp[idx / 3] == count - 1) idx /= 3
        else if (idx % 2 == 0 && dp[idx / 2] == count - 1) idx /= 2
        else idx--
        count--
        sb.append(idx).append(" ")
    }

    println(sb)
}