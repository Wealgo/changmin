import java.io.IOException;

class Main {	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		int[][] input = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		System.out.println(m.solution(input));
	}
	int[][] baseball;
	boolean[] candidate = new boolean[988];
	int answer;
	public int solution(int[][] baseball) {
        this.baseball = baseball;
        before();
        for (int i = 0; i < baseball.length; i++) {
			go(baseball[i]);
		}
        for (int i = 123; i < 988; i++) {
			if (candidate[i]) answer++;
		}
        return answer;
    }
	public void before() {
		for (int i = 123; i < 988; i++) {
			String str = Integer.toString(i);
			if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') continue;
			if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2)) continue;
			candidate[i] = true;
		}
	}
	public void go(int[] input) {
		for (int i = 123; i < 988; i++) {
			if (!candidate[i]) continue;
			String str = Integer.toString(i);
			String inp = Integer.toString(input[0]);
			int ball = 0;
			int strike = 0;
			for (int j = 0; j < 3; j++) {
				if(str.charAt(j) == inp.charAt(j)) {
					strike++;
					continue;
				}
				for (int k = 0; k < 3; k++) {
					if (j == k) continue;
					if (str.charAt(j) == inp.charAt(k)) {
						ball++;
					}
				}
			}
			if (input[1] == strike && input[2] == ball) {
				candidate[i] = true;
			} else {
				candidate[i] = false;
			}
		}
	}
}