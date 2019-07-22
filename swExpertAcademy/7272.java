import java.awt.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static LinkedList<Character> list0 = new LinkedList<>();
	public static LinkedList<Character> list1 = new LinkedList<>();
	
	public static void main(String[] args) {
		chogihwa();
		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		StringTokenizer st;
		for (int i = 0; i < testcase; i++) {
			st = new StringTokenizer(sc.nextLine());
			String word1 = st.nextToken();
			String word2 = st.nextToken();
			String sibal1 = transfer(word1);
			String sibal2 = transfer(word2);
			System.out.println("#"+(i+1)+" "+nimi(sibal1, sibal2));
		}/**/
	}
	
	public static String transfer(String str) {
		String tmp = "";
		StringBuilder sb = new StringBuilder(tmp);
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < list1.size(); j++) {
				if (list1.get(j).equals(str.charAt(i))) {
					sb.append("1");
				}
			}
			for (int j = 0; j < list0.size(); j++) {
				if (list0.get(j).equals(str.charAt(i))) {
					sb.append("0");
				}
			}
			if (str.charAt(i) == 'B') {
				sb.append("2");
				
			}
		}
		return sb.toString();
	}
	public static String nimi(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return "DIFF";
		}
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return "DIFF";
			}
		}
		return "SAME";
	}
	public static void chogihwa() {
		list1.add('A');
		list1.add('D');
		list1.add('O');
		list1.add('P');
		list1.add('Q');
		list1.add('R');
		list0.add('C');
		list0.add('E');
		list0.add('F');
		list0.add('G');
		list0.add('H');
		list0.add('I');
		list0.add('J');
		list0.add('K');
		list0.add('L');
		list0.add('M');
		list0.add('N');
		list0.add('S');
		list0.add('T');
		list0.add('U');
		list0.add('V');
		list0.add('W');
		list0.add('X');
		list0.add('Y');
		list0.add('Z');
	}
}
