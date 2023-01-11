
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Pnt{
		int x, y, cnt;
		public Pnt(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int n, m, min = Integer.MAX_VALUE, max = 0;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		visit = new boolean[n][n][2501];
		
		for(int i = 0; i < n; i++) {
			str = bf.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
				if(map[i][j] == 0) max++;
			}
		}
		
		BFS();
		System.out.println(min);
	}
	
	static void BFS() {
		Queue<Pnt> q = new LinkedList<>();
		
		q.add(new Pnt(0, 0, 0));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pnt temp = q.poll();
			
			if(temp.x == n-1 && temp.y == n-1) {
				min = Math.min(min, temp.cnt);
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = dx[i] + temp.x;
				int ny = dy[i] + temp.y;
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
//					System.out.println(temp.cnt+1);
					if(map[nx][ny] == 1 && !visit[nx][ny][temp.cnt]) {
						visit[nx][ny][temp.cnt] = true;
						q.add(new Pnt(nx, ny, temp.cnt));
					}
					else if(map[nx][ny] == 0 && !visit[nx][ny][temp.cnt+1] && !visit[nx][ny][temp.cnt] && temp.cnt+1 <= max) {
						visit[nx][ny][temp.cnt+1] = true;
						q.add(new Pnt(nx, ny, temp.cnt+1));
					}
				}
			}
		}
	}

}
