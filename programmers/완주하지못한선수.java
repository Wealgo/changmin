import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) {
		Solution s = new Solution();
		String[] p = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] c = {"josipa", "filipa", "marina", "nikola"};
		
		System.out.println(s.solution(p, c));
	}
	public String solution(String[] participant, String[] completion) {
        List<String> p = Arrays.asList(participant);
        List<String> c = Arrays.asList(completion);
        Collections.sort(p);
        Collections.sort(c);
        for (int i = 0; i < c.size(); i++) {
			if (p.get(i).equals(c.get(i))) continue;
			return p.get(i);
		}
        return p.get(p.size()-1);
    }
}