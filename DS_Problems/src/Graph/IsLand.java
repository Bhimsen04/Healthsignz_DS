package Graph;

public class IsLand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j, grid.length, grid[i].length);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int i, int j, int m, int n) {
		if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] == '0' || grid[i][j] == 'a')
			return;
		grid[i][j] = 'a';
		dfs(grid, i + 1, j, m, n);
		dfs(grid, i - 1, j, m, n);
		dfs(grid, i, j + 1, m, n);
		dfs(grid, i, j - 1, m, n);
	}
}
