package miniProject.mine.hangman;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class HangManCLI {

	static Scanner sc = new Scanner(System.in);

	public void runHangMan() {

		
		System.out.println("Press any key to start! (진행하지 않으려면 q)");
		char pressButton =  sc.nextLine().toLowerCase().charAt(0);

		if (pressButton == 'q')
			return;
		
		do {
			System.out.println("게임을 시작합니다!! \nSTART!!!!!!");
			HangManCLI.runGame();

			System.out.print("게임을 계속 진행하겠습니까? (진행하지 않으려면 q)");
			pressButton =  sc.next().toLowerCase().charAt(0);

			if (pressButton == 'q')
				break;

		} while(true);
		
		
		System.out.println("즐거웠어요... 안녕..!");

	}

	public static void runGame() {
		String[] wordList = {"implements", "interface", "default", "extends", "synchronized", "serialized", "arrayindexoutofbounds",  
				"abstract", "continue", "package", "assert", "private", "throw", "boolean", 
				 "protected", "public", "throws", "break", "filenotfoundexception", "eofexception",
				 "double", "import", "public", "transient", "blueberry", "instanceof", "nullpointerexception",
				"return", "extends", "void", "catch", "final", "interface", "static", "finally", 
						"super","class", "float", "native", "switch", "while", "synchronized", };

		int point = (int)(Math.random()*wordList.length);

		char userInput = ' ';
		int count = 1; // 인간의 생명 횟수 

		// 제시된 정답 단어를 리스트로 넣어주기 
		char[] answerArr = wordList[point].toCharArray();
		ArrayList<Character> answerList = new ArrayList<>();

		// 사용자의 정답이 매번 갱신될때마다 기록해주기 위한 리스트 
		ArrayList<Character> userAnswer = new ArrayList<>();

		for (char c : answerArr) {
			answerList.add(c);
		}
		for (int i = 0; i < answerList.size(); i++) {
			userAnswer.add('ㅡ');
		}


		// 치트코드 (나중에 지워주기)
		//		System.out.println("이건 치트코드 ^--^ " + answerList);

		while(count < 8){
			System.out.println("------------------");
			System.out.println("인간의 생명 횟수 : " + count++);
			System.out.println("------------------");


			System.out.print("무슨 단어일까요~? : ");
			for (Character c: userAnswer) {
				System.out.print(" " + Character.toUpperCase(c) + " ");
			}
			System.out.println();


			do {
				if (userAnswer.equals(answerList)) {  // userAnswer와 answerList(사용자의 입력값들과 컴퓨터의 값이 동일한 순간)
					System.out.println("축하해요! 당신이 인간을 살렸어요!");
					return ;
				}

				System.out.print("\n맞춰보시죠! : ");
				userInput = sc.next().toLowerCase().charAt(0);

				for (int i = 0; i < answerList.size(); i++) { // 글자수만큼 'ㅡ'를 출력해주기 
					if (answerList.get(i) == userInput) {
						userAnswer.set(i, answerList.get(i));
					}
				}

				for (Character c: userAnswer) {
					System.out.print(" " + Character.toUpperCase(c) + " ");
				}
				System.out.println();

				if (!answerList.contains(userInput))
					break;
				else
					System.out.println("오 하나 맞췄군요!!");

			} while(true);

		}

		System.out.println("헉... 당신이 답을 맞추는 동안 인간이 죽어버렸어요....ㅠ0ㅠ 이 살인자!!!! ");
		System.out.println("정답은 " + answerList + "였답니다.... 살인자가 되지 않도록 분발하세요. ");

	}
}
