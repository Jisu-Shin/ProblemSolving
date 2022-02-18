package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ����������Ʈȣ��_22254 {
	static int[] process_time;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		String str2 = bf.readLine();
		StringTokenizer st2 = new StringTokenizer(str2);
		process_time = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			process_time[i] = Integer.parseInt(st2.nextToken());
		}
		int left = 1;
		int right = n;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (can_process(mid, x, n)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left);
	}

	public static boolean can_process(int mid, int x, int n) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < mid; i++) {
			q.offer(0);
		}
		for (int i = 1; i <= n; i++) {
			int time = q.poll();
			if (time + process_time[i] > x)
				return false;
			q.offer(time + process_time[i]);
		}
		return true;
	}
}
