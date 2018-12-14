package unionFind;

/**
 * 并查集 基于size的优化
 */
public class UnionFind3 implements UF {
    private int[] parent;
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }

    }

    private int find(int index) {
        if (index < 0 || index >= parent.length) {
            throw new IllegalArgumentException("index error");
        }
        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
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
        if (sz[findP] < sz[findQ]) {
            parent[findP] = findQ;
            sz[findQ] = sz[findQ] + sz[findP];
        } else {
            parent[findQ] = findP;
            sz[findP] += sz[findQ];
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
