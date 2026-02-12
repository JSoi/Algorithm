package com.soi.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader


/**
 * @see <a href= "https://www.acmicpc.net/problem/11559">Puyo Puyo</a>
 */

data class Pos(val r: Int, val c: Int)

private val br = BufferedReader(InputStreamReader(System.`in`))
private val map = Array(12) { CharArray(6) }
private val visit = Array(12) { BooleanArray(6) }

private val dirs = arrayOf(
    intArrayOf(-1, 0),
    intArrayOf(1, 0),
    intArrayOf(0, -1),
    intArrayOf(0, 1)
)

fun main() {
    repeat(12) { r ->
        map[r] = br.readLine().toCharArray()
    }

    var answer = 0

    while (true) {
        val pops = findPops()
        if (pops.isEmpty()) break

        pops.forEach { (r, c) -> map[r][c] = '.' }
        gravity()
        answer++
    }

    println(answer)
}

private fun findPops(): MutableSet<Pos> {
    val pops = mutableSetOf<Pos>()

    for (r in 0 until 12)
        for (c in 0 until 6)
            visit[r][c] = false

    for (r in 0 until 12) {
        for (c in 0 until 6) {
            if (map[r][c] == '.' || visit[r][c]) continue
            bfs(r, c, pops)
        }
    }

    return pops
}

private fun bfs(sr: Int, sc: Int, pops: MutableSet<Pos>) {
    val color = map[sr][sc]
    val group = mutableListOf<Pos>()
    val q = ArrayDeque<Pos>()

    q.add(Pos(sr, sc))
    visit[sr][sc] = true
    group.add(Pos(sr, sc))

    while (q.isNotEmpty()) {
        val (r, c) = q.removeFirst()

        for (d in dirs) {
            val nr = r + d[0]
            val nc = c + d[1]

            if (!inRange(nr, nc) || visit[nr][nc] || map[nr][nc] != color) continue

            visit[nr][nc] = true
            q.add(Pos(nr, nc))
            group.add(Pos(nr, nc))
        }
    }

    if (group.size >= 4) pops.addAll(group)
}

private fun gravity() {
    for (c in 0 until 6) {
        var write = 11

        for (r in 11 downTo 0) {
            if (map[r][c] != '.') {
                map[write--][c] = map[r][c]
            }
        }

        while (write >= 0) {
            map[write--][c] = '.'
        }
    }
}

private fun inRange(r: Int, c: Int) =
    r in 0 until 12 && c in 0 until 6