package com.bayviewglen.unitTwo;

public class Marker {

	public static void main(String[] args) {
		
		char[][] answers = {"ABACCDEEAD".toCharArray(), "DBABCAEEAD".toCharArray(), "EDDACBEEAD".toCharArray(), "CBAEDCEEAD".toCharArray(),
							"ABDCCDEEAD".toCharArray(), "BBECCDEEAD".toCharArray(), "BBACCDEEAD".toCharArray(), "EBECCDEEAD".toCharArray()}; 
		char[] rightAnswers = "DBDCCDAEAD".toCharArray();
		
		computeScore(answers, rightAnswers);
		
	}

	private static void computeScore(char[][] answers, char[] rightAnswers) {
		int count = 10;
		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < answers[i].length; j++) {
				if (answers[i][j] != rightAnswers[j])
					count--;
			}
			System.out.println("Student " + i + "'s correct count is " + count);
			count = 10;
		}
		
	}

}
