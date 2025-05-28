package com.soi.programmers;

public class L62048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(8, 12));
	}

	public static long solution(long w, long h) {
		long gcdval = (w + h - (w >= h ? GCD(w, h) : GCD(h, w)));
		//System.out.println(gcdval);
		return w * h - gcdval;
	}

	public static long GCD(long w, long h) {
		if (h == 0)
			return w;
		else {
			return GCD(h, w % h);
		}
	}
}
