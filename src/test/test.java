package test;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.Test;
import org.junit.rules.Timeout;

import junit.framework.TestCase;
import programmers.*;

public class test extends TestCase {
	@Test
	public static void test43238() {
		L43238 sol = new L43238();
		long result = sol.solution(6, new int[] { 7, 10 });
		assertEquals(28, result);
	}

}
