package com.soi.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/**
 * @see <a href= "https://www.acmicpc.net/problem/1260">DFS와 BFS</a>
 */
private val br = BufferedReader(InputStreamReader(System.`in`))
fun main() {
    val (n, m, v) = br.readLine().split(' ').map { it.toInt() }
    val conn = ArrayList<HashSet<Int>>()
    repeat(n + 1) {
        conn.add(HashSet())
    }
    (1..m).forEach { _ ->
        val (a, b) = br.readLine().split(' ').map { it.toInt() }
        conn[a].add(b)
        conn[b].add(a)
    }
    val traverse = Traverse(conn, v)
    println(traverse.dfs())
    println(traverse.bfs())
}

private class Traverse {
    val conn: ArrayList<HashSet<Int>>
    val start: Int
    val n: Int

    constructor(conn: ArrayList<HashSet<Int>>, start: Int) {
        this.conn = conn
        this.start = start
        this.n = conn.size
    }

    fun dfs(): String {
        val br = StringBuilder()
        val stack = Stack<Int>()
        val visit = BooleanArray(conn.size)

        stack.push(start)
        while (stack.isNotEmpty()) {
            val curr = stack.pop()
            if (visit[curr]) continue
            visit[curr] = true
            br.append(curr).append(" ")
            for (next in n - 1 downTo 1) {
                if (!conn[curr].contains(next) || visit[next]) {
                    continue
                }
                stack.push(next)
            }
        }
        return br.toString()
    }

    fun bfs(): String {
        val br = StringBuilder()
        val queue = ArrayDeque<Int>()
        val visit = BooleanArray(conn.size)
        queue.offer(start)
        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            if (visit[curr]) continue
            visit[curr] = true
            br.append(curr).append(" ")
            for (next in 1 until n) {
                if (!conn[curr].contains(next) || visit[next]) {
                    continue
                }
                queue.offer(next)
            }
        }
        return br.toString()
    }
}