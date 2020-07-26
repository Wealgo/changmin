import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//입력받고
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		ArrayList<Character> arr = new ArrayList<Character>();
		
		for (char c : input.toCharArray()) {
			arr.add(c);
		}
        Collections.sort(arr);
		Collections.reverse(arr);
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i));
		}
	}
}
