import java.util.Scanner;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int brown = 24;
		int yellow = 24;
		int[] output = m.solution(brown, yellow);
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
	public int[] answer = new int[2];
	public int[] solution(int brown, int yellow) {
        for (int ySero = 1; ySero <= yellow; ySero++) {
			if (yellow % ySero != 0) continue;
			int yGaro = yellow / ySero;
			if (((yGaro+2) * 2) + ((ySero+2)*2) - 4 == brown)  {
				answer[0] = yGaro+2;
				answer[1] = ySero+2;
				return answer;
			}
		}
        return answer;
    }
}