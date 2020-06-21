package com.geekcap.vmturbo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloWorldServlet extends HttpServlet {

	static int evenPerfectSquareNumbers = 0;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.println("Hello, World!");

		int i = 100;
		System.out.println("Total Perfect Squares: " + calculateCount(i));
		System.out.println("Even Perfect Squares : " + evenPerfectSquareNumbers);
		out.close();
	}

	public static int calculateCount(int i) {
		int perfectSquaresCount = 0;
		for (int number = 1; number <= i; number++) {
			if (isPerfectSquare(number)) {
				perfectSquaresCount++;
				if (number % 2 == 0) {
					evenPerfectSquareNumbers++;
				}
			}
		}
		return perfectSquaresCount;
	}

	private static boolean isPerfectSquare(int number) {
		double sqrt = Math.sqrt(number);
		return sqrt - Math.floor(sqrt) == 0;
	}
}
