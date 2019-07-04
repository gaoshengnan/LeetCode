package highFrequencyLeetcode.leetcode_200;

/**
 * @author Seina
 * @version 2019-07-04 15:01:15
 */
public class UF {

    public int count = 0;
    public int[] root;

    public UF(int m, int n, char[][] gird){
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (gird[i][j] == '1') count++;
            }
        }
        root = new int[m * n];//20
        for (int i = 0; i < m * n; i++) root[i] = i;
    }

    public int find(int p) {
        while (p != root[p]) {
            root[p] = root[root[p]];
            p = root[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        int pRoot= find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return false;
        else return true;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        root[pRoot] = qRoot;
        count--;
    }


}
