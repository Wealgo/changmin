import java.io.IOException;

class Main {	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		int[] input = {1,2,3,2,3};
		m.solution(input);
	}
	int[] input;
	int[] answer;
	public int[] solution(int[] prices) {
        input = prices;
        answer = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			answer[i] = go(i);
		}
        return answer;
    }
	public int go(int idx) {
		int output = 0;
		for (int i = idx+1; i < input.length; i++) {
			output++;
			if (input[idx] > input[i]) return output;
		}
		return output;
	}
}