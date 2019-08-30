import java.util.Scanner;

public class Main{
	public static int n;
	public static int output = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		int[] visited = new int [n+1];
		for (int i = 1; i <= n; i++) {
			int[] col = new int [n+1];
			col[1] = i;
			nq(col, 1);
		}
		System.out.println(output);
	}
	public static void nq(int[] col, int row) {
        if(row == n) {
            output++;
            return;
        }
        for(int i = 1; i <= n; i++) {
            col[row+1] = i;
            if(isPossible(col, row+1)) {
                nq(col, row+1);
            }
        }
        
    }

	//여기에 둘 수 있어? 물어보는거
	public static boolean isPossible(int[] col, int row) {
        for(int i=1; i < row; i++) {
            if(col[i] == col[row]) return false;
            if(Math.abs(i - row) == Math.abs(col[i] - col[row])) return false;
        }
        return true;
    }

}

