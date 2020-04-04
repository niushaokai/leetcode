package leetcode;

/**
 * 并查集路径压缩
 *
 * @author niushaokai
 * @date 2020/2/28
 */
public class QuickUnionUF {
    private int[] roots;

    public QuickUnionUF(int N) {
        roots = new int[N];
        for (int i = 0; i < N; i++) {
            roots[i] = i;
        }
    }

    private int findRoot(int i) {
        int root = i;
        while (root != roots[root]) {
            root = roots[root];
        }

        //path compression
        while (i != roots[i]) {
            int tmp = roots[i];
            roots[i] = root;
            i = tmp;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int qroot = findRoot(q);
        int proot = findRoot(p);
        roots[proot] = qroot;
    }
}