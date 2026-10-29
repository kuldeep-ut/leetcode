import java.util.*;

class Solution {
    private int[] bit;
    private int size;

    private void upd(int i, int val) {
        for (i++; i <= size; i += i & -i) bit[i] ^= val;
    }

    private int qry(int i) {
        int r = 0;
        for (i++; i > 0; i -= i & -i) r ^= bit[i];
        return r;
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        // adjacency via arrays
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] nxt = new int[2 * Math.max(0, n - 1)];
        int[] to = new int[nxt.length];
        int ec = 0;
        for (int[] e : edges) {
            to[ec] = e[1]; nxt[ec] = head[e[0]]; head[e[0]] = ec++;
            to[ec] = e[0]; nxt[ec] = head[e[1]]; head[e[1]] = ec++;
        }

        int LOG = Math.max(1, 32 - Integer.numberOfLeadingZeros(n));
        int[][] up = new int[LOG][n];
        int[] depth = new int[n], tin = new int[n], tout = new int[n];
        int[] cur = new int[n], base = new int[n];
        for (int i = 0; i < n; i++) cur[i] = 1 << (s.charAt(i) - 'a');

        // iterative DFS from root 0
        int[] it = head.clone();
        int[] stack = new int[n];
        int sp = 0, timer = 0;
        stack[sp++] = 0;
        tin[0] = timer++;
        base[0] = cur[0];
        while (sp > 0) {
            int u = stack[sp - 1];
            int e = it[u];
            if (e == -1) {
                tout[u] = timer - 1;
                sp--;
            } else {
                it[u] = nxt[e];
                int v = to[e];
                if (u != 0 && v == up[0][u]) continue;
                up[0][v] = u;
                depth[v] = depth[u] + 1;
                base[v] = base[u] ^ cur[v];
                tin[v] = timer++;
                stack[sp++] = v;
            }
        }

        for (int k = 1; k < LOG; k++)
            for (int v = 0; v < n; v++)
                up[k][v] = up[k - 1][up[k - 1][v]];

        size = n + 1;
        bit = new int[size + 1];

        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                int c = 1 << (p[2].charAt(0) - 'a');
                int delta = cur[u] ^ c;
                if (delta != 0) {
                    cur[u] = c;
                    upd(tin[u], delta);
                    upd(tout[u] + 1, delta);
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                // LCA
                int a = u, b = v;
                if (depth[a] < depth[b]) { int t = a; a = b; b = t; }
                int diff = depth[a] - depth[b];
                for (int k = 0; k < LOG; k++)
                    if ((diff >> k & 1) != 0) a = up[k][a];
                int l;
                if (a == b) {
                    l = a;
                } else {
                    for (int k = LOG - 1; k >= 0; k--) {
                        if (up[k][a] != up[k][b]) {
                            a = up[k][a];
                            b = up[k][b];
                        }
                    }
                    l = up[0][a];
                }

                int mask = (base[u] ^ qry(tin[u]))
                         ^ (base[v] ^ qry(tin[v]))
                         ^ cur[l];
                res.add((mask & (mask - 1)) == 0);
            }
        }
        return res;
    }
}