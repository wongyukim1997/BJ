import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, l, r;
	static int[][] map, check;
	static boolean[][] visit;
	static Map<Integer, Integer> m = new HashMap<>();
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str, " ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		while(true) {
			check = new int[n][n];
			int res = 0;
			int c = 1;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(check[i][j] == 0) {
						check[i][j] = c;
						res += BFS(i, j, c);
						c++;
					}
				}
			}
			
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) System.out.print(check[i][j] + " ");
//				System.out.println();
//			}
//			System.out.println();
			
			move();
			
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) System.out.print(map[i][j] + " ");
//				System.out.println();
//			}
//			System.out.println();
			
			if(res == 0) break;
			
			m.clear();
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static int cal(int a, int b) {
		return Math.abs(a - b);
	}
	
	static void move() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(m.get(check[i][j]) != null) {
					map[i][j] = m.get(check[i][j]);
				}
			}
		}
	}
	
	static int BFS(int x, int y, int c) {
		Queue<Point> q = new LinkedList<>();

		q.add(new Point(x, y));
		
		int cnt = 0, sum = map[x][y];
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = dx[i] + temp.x;
				int ny = dy[i] + temp.y;
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && check[nx][ny] == 0) {
					int res = cal(map[temp.x][temp.y], map[nx][ny]);
					if(l <= res && res <= r) {
						cnt++;
						sum += map[nx][ny];
						check[nx][ny] = c;
						q.add(new Point(nx, ny));
					}
				}
			}
		}
		
		int pop = 0;
		
		if(cnt != 0) {
			pop = sum / (cnt+1);
			m.put(c, pop);
		}
		
		return cnt;
	}

}
