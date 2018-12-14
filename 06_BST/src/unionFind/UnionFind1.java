package unionFind;

public class UnionFind1 implements UF {
    private int[] ids;

    public UnionFind1(int size) {
        ids = new int[size];

        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }

    }

    private int find(int index) {
        if (index < 0 || index >= ids.length) {
            throw new IllegalArgumentException("index error");
        }
        return ids[index];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int findP = find(p);
        int findQ = find(q);
        if (findP == findQ) {
            return;
        }
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == findP) {
                ids[i] = findQ;
            }
        }
    }

    @Override
    public int getSize() {
        return ids.length;
    }
}
