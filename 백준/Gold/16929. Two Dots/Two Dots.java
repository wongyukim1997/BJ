

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static char[][] map;
	static boolean check = false;
	static boolean[][] visit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			str = bf.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visit[i][j]) {
					visit[i][j] = true;
					DFS(i, j, i, j, 1);
//					System.out.println(check);
					if(check) break;
				}
			}
			if(check) break;
		}
		
		if(check) System.out.println("Yes");
		else System.out.println("No");
	}
	
	static void DFS(int startX, int startY, int x, int y, int cnt) {
		if(check) return;
		
//		System.out.println();
//		System.out.println(x + " " + y);
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j++) {
//				System.out.print(visit[i][j]);
//			}
//			System.out.println();
//		}
		
		char c = map[x][y];
		for(int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == c) {
				if(nx == startX && ny == startY && cnt > 2) {
					check = true;
					return;
				}else {
					if(!visit[nx][ny]) {
						visit[nx][ny] = true;
						DFS(startX, startY, nx, ny, cnt+1);
						visit[nx][ny] = false;
					}
				}
			}
		}
	}

}
