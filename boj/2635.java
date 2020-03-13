import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 come back
**/
public class Main {
	public static int input;
	public static ArrayList<Integer> realList;
	public static int output = 0;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = Integer.parseInt(br.readLine());

		for (int i = input; i > 0; i--) {
			ArrayList<Integer> twoList = makeList(i);
			makeoutput(twoList);
		}
		System.out.println(realList.size());
		for (int i = 0; i < realList.size(); i++) {
			bw.write(realList.get(i) + " ");
		}
		bw.flush();
	}
	public static ArrayList<Integer> makeList(int a) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(input);
		list.add(a);
		return list;
	}
	public static void makeoutput(ArrayList<Integer> list) {
		boolean ist = true;
		int t = 0;
		while (ist) {
			int size = list.size();
			int a = list.get(size-2) - list.get(size-1);
			if (a >= 0) {
				list.add(a);
			} else {
				ist = false;
			}
			t = t + 1;
		}
		if (t > output) {
			output = t;
			realList = list;
		}
	}
}
