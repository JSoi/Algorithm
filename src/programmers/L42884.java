package programmers;

import java.util.*;

public class L42884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_42884 sol = new Solution_42884();
		System.out.println(sol.solution(4, new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 2, 3, 1 } }));
	}

}

class Solution_42884 {
	int answer;
	int Node;
	int E;
	Queue<Graph42884> q;
	int[] parent;
	boolean[] visit;

	public int find(int a) {
		if (a == parent[a])
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}

	public void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) {
			parent[aRoot] = b;
		} else {
			return;
		}
	}

	public int solution(int n, int[][] costs) {
		Node = n;
		E = costs.length;
		q = new PriorityQueue<Graph42884>((Graph42884 p1, Graph42884 p2) -> p1.cost - p2.cost);
		for (int[] r : costs) {
			q.add(new Graph42884(r[0], r[1], r[2]));
		}
		parent = new int[Node];
		visit = new boolean[Node];
		for (int i = 0; i < Node; i++) {
			parent[i] = i;
		}
		for (int k = 0; k < E; k++) {
			Graph42884 g = q.poll();
			int start = g.start;
			int end = g.end;
			int sParent = find(start);
			int eParent = find(end);
			if (sParent == eParent)
				continue;
			union(start, end);
			answer += g.cost;
		}
		return answer;
	}
}

class Graph42884 {
	int start;
	int end;
	int cost;

	Graph42884(int a, int b, int c) {
		this.start = a;
		this.end = b;
		this.cost = c;
	}
}