class Solution {
public:
    int maximumSafenessFactor(vector<vector<int>>& grid) {
        int dx[4] = {0,0,-1,1};
        int dy[4] = {1,-1,0,0};
        int n = grid.size();
        queue<tuple<int,int,int,int>> q;
        vector<vector<int>> dist(n,vector<int>(n,1e9));
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<n;j++) {
                if (grid[i][j] == 0) continue;
                q.push({i,j,i,j});
                dist[i][j] = 0;
            }
        }
        while (q.size() != 0) {
            auto [x,y,i,j] = q.front(); q.pop();
            for (int k = 0;k<4;k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx == n || ny < 0 || ny == n) continue;
                int newC = abs(nx-i) + abs(ny-j);
                if (newC < dist[nx][ny]) {
                    dist[nx][ny] = newC;
                    q.push({nx,ny,i,j});
                }
            }
        }
        for (int i = 0;i<n;i++) {
            fill(grid[i].begin(),grid[i].end(),-1);
        }
        priority_queue<tuple<int,int,int>> pq;
        grid[0][0] = dist[0][0];
        pq.push({dist[0][0],0,0});
        while (pq.size() != 0) {
            auto [cost,x,y] = pq.top(); pq.pop();
            if (x == n - 1 && y == n - 1) return cost;
            if (cost < grid[x][y]) continue;
            for (int k = 0;k<4;k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx <0 || nx == n || ny <0 || ny == n) continue;
                int newC = min(dist[nx][ny],cost);
                if (newC > grid[nx][ny]) {
                    grid[nx][ny] =  newC;
                    pq.push({newC,nx,ny});
                } 
            }
        }
       return 0;
    }
};