import java.util.*;

class Solution {
    public static void main(String[] args) {
		Solution s = new Solution();
		String[] p = {"123", "456", "789"};
		System.out.println(s.solution(p));
	}
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        String num = phone_book[0];
        for (int i = 1; i < phone_book.length; i++) {
			if (phone_book[i].contains(num)) {
				answer = false;
			}
		}
        return answer;
    }
}