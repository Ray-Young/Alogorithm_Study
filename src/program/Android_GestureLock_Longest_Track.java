package program;


public class Android_GestureLock_Longest_Track {

	private static int map[][] = new int[3][3];
	// 深度优先遍历
	public static float dfs(int x, int y, int d) {
		float Dis = 0;
		float tmp = 0;
		float max = 0;

		if (d == 9) {
			return 0;
		}
		map[x][y] = 1;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				if (map[i][j] == 1)
					continue;
				Dis = Math.abs(x - i) * Math.abs(x - i) + Math.abs(y - j)
						* Math.abs(y - j);
				if (Dis == 4 || Dis == 8)
					continue;
				tmp = (float) (Math.sqrt(Dis) + dfs(i, j, d + 1));
				if (tmp > max) {
					max = tmp;
				}
			}
		map[x][y] = 0;
		return max;
	}


	public static void main(String[] args) {
		System.out.println("第四题");
		float max = 0, tmp = 0;

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				map[i][j] = 0;
			}
		// 因为九宫格是对称的，只要探测三个点作为出发位置就可以了
		int start_point[][] = { { 0, 0 }, { 0, 1 }, { 1, 1 } };
		for (int i = 0; i < 3; i++) {
			tmp = dfs(start_point[i][0], start_point[i][1], 0);
			if (tmp > max)
				max = tmp;
		}
		System.out.println("最长路径的长度为"+max);
	}

}
