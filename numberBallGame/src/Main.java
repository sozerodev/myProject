import java.util.Random;
import java.util.Scanner;

public class Main {
	/**
	 * 
	 * @author Soyoung Kim
	 * @when 2020-03-12
	 * @version 1.0
	 * 
	 */

	public static void main(String[] args) throws InterruptedException { // Tread.sleep()메소드를 쓰려고 이렇게 선언했습니다. 
		
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		
	
		System.out.print("Press any button! (종료하려면 q/Q) : ");
		char button = sc.next().charAt(0);
		
		if (button == 'q' || button == 'Q') {
			System.out.println(".");
			Thread.sleep(1000);
			System.out.println(".");
			Thread.sleep(1000);
			System.out.println(".");
			Thread.sleep(1000);
			System.out.println("게임을 종료합니다. ㅠ-ㅠ");
			return;
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.print(".\n");
			Thread.sleep(500);
		}

		System.out.print("\nLet's....");
		Thread.sleep(1500);
		System.out.print("play....");
		Thread.sleep(1000);
		System.out.print("ball game!!!!! ( ๑˃̶ ꇴ ˂̶)♪⁺");
		Thread.sleep(500);
		System.out.println("\n\n++++++++++++++++++++++++++++ START !!! ++++++++++++++++++++++++++++");
	
		// -------------------------- 게임 시작 --------------------------------------
		
		
		// 컴퓨터의 배열 숫자 세개 입력해주기 
		int comNum[] = new int[3];
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		shuffle(arr);
		int point = (int)(Math.random() * 7); // 0 ~ 6의 숫자를 뽑는다. 
		
		// suffle된 arr중에서 랜덤으로 인덱스 하나를 뽑아서 인덱스 번호 포함 뒤의 두 숫자를 가져온다. 
		for (int i = 0; i < 3; i++) {
			comNum[i] = arr[point + i];
		}
		
		
		/* ==================================================================
		 * 이코드는 제거.
		 * 컴퓨터의 세 개 배열의 요소가운데 중복되는 요소가 있을 경우 경우의 수가 증가하므로 
		 * 요소 세 개가 중복이 되지 않도록 한다. 
		 * 
		for (int i = 0; i < comNum.length; i++) {
			comNum[i] = (int)(Math.random() * 9) + 1; 
		}
		==================================================================*/
		
		System.out.println("٩( ᐛ )و 컴퓨터가 열심히 세 개의 숫자를 뽑는 중~ ŏ̥̥̥̥םŏ̥̥̥̥\n\n");
		Thread.sleep(1000);
		System.out.print("로딩중\n");
		for (int i = 0; i < 10; i++) {
			System.out.print("٩( ᐛ )و");
			Thread.sleep(300);
		}
		System.out.println();
		System.out.println("\n======================== 입력 예시 ========================\nPlayer : 3 9 2 \n=========================================================");
		System.out.println("(￣(ｴ)￣)ﾉ : 1 ~ 9 범위의 숫자를 중복되지 않게 입력해주세요! \nRound가 10번을 넘어가면 게임은 종료됩니다! ");
		System.out.println("===========================================================");
		// 라운드수 저장하기 위한 변수 선언 
		int count = 1;
		
//		이부분은 치팅키 ~~~~~~ --------------------------------------------------------
//		System.out.print("\n\n치팅키! (이건 나중에 없애줄거에요. 컴퓨터에 배정된 랜덤숫자 3개입니다) : ");
//		for (int i = 0; i < comNum.length; i++) {
//			System.out.print(comNum[i] + " ");
//		}
//		System.out.println("\n\n");
// -------------------------------------------------------------------			
	
		
		while(true) {
			if (count == 10) {
				for (int i = 0; i < 5; i++) {
					System.out.print(".\n");
					Thread.sleep(500);
				}
				System.out.println("\n\n( •᷄⌓•᷅ ) : 큰일났어요!! 이제 기회는 한번 뿐이에요!!! ");
			}
			if (count > 10) {
				System.out.println("Round 10회를 초과했습니다. \n");
				System.out.print("ᕕ( ᐛ )ᕗ : 컴퓨터의 숫자는 [ ");
				for (int i = 0; i < comNum.length; i++) {
					System.out.print(comNum[i] + " ");
				}
				System.out.println("] 이었습니다. \n다음에 또 도전해보세요 ^-^ ");
				return;
				
			}
			int ball = 0, strike = 0;
			int x = 0; // 아웃일 경우를 위한 변수 
			
			int userArr[] = new int[3];
			System.out.printf("\n--- Round %d! ༼ つ ◕_◕ ༽つ : 컴퓨터가 고른 세 개의 숫자는 뭘까요? ---\n", count);
			System.out.print("Player : ");
			
		
			
			// 사용자에게 숫자 3개 입력받기 
			for (int i = 0; i < userArr.length; i++) {
				userArr[i] = sc.nextInt();
				
				// 1 ~ 9 범위의 수가 아닌 경우 함수 종료 
				if (userArr[i] <= 0 || userArr[i] > 9 ) {
					System.out.println("(* ` m ´ *) : 1 ~ 9 범위의 수를 입력해주세요!!");
					continue;
				}
			}
			
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (userArr[i] == comNum[j]) {
						x++;
						if (i == j) {
							strike++;
						}else {
							ball++;
						}
					}
				}
			}
			
			if (strike == 3) {
				for (int i = 0; i < 5; i++) {
					System.out.print(".\n");
					Thread.sleep(500);
				}
				System.out.println("축하해요!! 숫자 세개를 다 맞췄어요!!! ❀.(*´▽`*).❀");
				return;
			}
			
			if (x == 0) {
				System.out.println("아웃입니다!! 하나도 못맞춤! ");
			}else {
				System.out.printf("\n%d Strike!!", strike);
				System.out.printf("\n %d ball!!\n\n", ball);
			}
			
			System.out.println("---------------------------------------------");
			count ++;
		}
		
	}

	public static int[] shuffle(int[] arr){ // 배열을 랜덤으로 섞기 위한 메소드 
		for(int k=0;k<arr.length;k++){
			int i = (int)(Math.random()*arr.length);
			int j = (int)(Math.random()*arr.length);

			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		return arr;
	}
}

