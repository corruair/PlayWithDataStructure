package unionFind;

public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
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
        parent[findP] = parent[findQ];
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
