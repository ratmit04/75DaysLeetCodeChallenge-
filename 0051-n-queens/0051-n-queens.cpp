class Solution {
    vector<vector<string>> answer;
    vector<bool> diag1;
    vector<bool> diag2;
    vector<bool> cols;
    int n;
public:
    vector<vector<string>> solveNQueens(int n) {
        this->n = n;
        diag1.resize(2*n-1,false);
        diag2.resize(2*n-1,false);
        cols.resize(n,false);
        vector<vector<int>> ans(n,vector<int>(n,-1));
        generate(0,vector<string>(n,string(n,'.')));
        return answer;
    }
    void generate(int row,vector<string> board) {
        if (row == n) {
            answer.push_back(board);
            return;
        }
        for (int col = 0;col<n;col++) {
            int d1 = row + col;
            int d2 = row - col + n -1;
            if (cols[col] || diag1[d1] || diag2[d2]) continue;
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            generate(row+1,board);
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
};