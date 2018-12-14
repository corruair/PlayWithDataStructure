package unionFind;

/**
 * 并查集 路径压缩(使用递归在find过程中将树的深度缩小为2)
 */
public class UnionFind6 implements UF {
    private int[] parent;
    private int[] rank;

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

    }

    private int find(int index) {
        if (index < 0 || index >= parent.length) {
            throw new IllegalArgumentException("index error");
        }
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(q) == find(p);
    }

    @Override
    public void unionElements(int p, int q) {
        int findP = find(p);
        int findQ = find(q);
        if (findP == findQ) {
            return;
        }
        if (rank[findP] < rank[findQ]) {
            parent[findP] = findQ;
        } else if (rank[findQ] < rank[findP]) {
            parent[findQ] = findP;
        } else {
            parent[findP] = findQ;
            rank[findQ] += 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
