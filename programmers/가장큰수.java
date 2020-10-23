
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * EZ
 * @author quadcore
 */
class Main {
	public static void main(String[] args) {
		Main m = new Main();
		int[] array = {3, 30, 31, 32, 33, 34, 35};
		System.out.println(m.solution(array));
	}
	public String solution(int[] numbers) {
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) list.add(Integer.toString(numbers[i]));
        Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}
		});
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) sb.append(list.get(i));
        if (sb.toString().charAt(0) == '0') return "0";
        return sb.toString();
    }
}