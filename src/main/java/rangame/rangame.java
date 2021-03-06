package rangame;

import java.util.Scanner;
import java.util.Random;

public class rangame {
	public static boolean isNumeric(String s) {
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");
	}

	public static void main(String[] args) {
		int userPick, upUserPick = 0, downUserPick = 99, number, i = 1;
		String text;
		String message;
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		number = random.nextInt(100);

		while (true) {
			System.out.println("수를 결정하였습니다. 맞추어보세요 (나가기는 q)");
			while (true) {
				System.out.println(upUserPick + " ~ " + downUserPick);
				System.out.print(i + " >> ");

				message = scanner.next();
				if (isNumeric(message)) {
					userPick = Integer.parseInt(message);
					if (userPick < number) {
						System.out.println(userPick + "보다 큽니다.");
						upUserPick = userPick;
						userPick = 0;
					} else if (number < userPick) {
						System.out.println(userPick + "보다 작습니다.");
						downUserPick = userPick;
						userPick = 0;
					}
					if (userPick == number) {
						System.out.println("성공하셨습니다!");
						break;
					}
					i++;
				} else {
					if (message.equals("q")) {
						break;
					} else if (message.equals("help")) {
						System.out.println("숫자를 맞추세요");
					} else {
						System.out.println("Command not found");
					}
				}
			}
			System.out.print("다시하시겠습니까?(y/n) ");
			text = scanner.next();
			if (text.equals("n") || text.equals("N") || text.equals("no") || text.equals("No") || text.equals("NO")) {
				break;
			} else if (text.equals("y") || text.equals("Y") || text.equals("yes")) {
				System.out.print("\n");
				number = random.nextInt(100);
				upUserPick = 0;
				downUserPick = 99;
				i = 1;
			} else {
				System.out.println("type yes or no");
			}
		}
		scanner.close();
	}
}
