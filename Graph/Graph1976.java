public class Main {

    static int parent[];
    static int rank[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.valueOf(br.readLine());
        int n = Integer.valueOf(br.readLine());
        parent = new int [city+1];
        rank = new int[city+1];

        for(int i=1; i<=city; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
      
        String line[];
        for(int i=1; i<=city; i++) {
            line = br.readLine().split(" ");
            for (int k=1; k<=city; k++) {
                if(Integer.valueOf(line[k-1]) == 1) {
                    union(i,k);
                }
            }
        }

        line = br.readLine().split(" ");
        boolean check = false;
        int checking = find(Integer.valueOf(line[0]));
        for(int i=1; i<line.length; i++) {
            if(checking != find(Integer.valueOf(line[i]))) {
                check = true; 
                break;
            }
        }

        if(check)
            System.out.println("NO");
        else
            System.out.println("YES");
    }

    public static int find(int x) {
        if(x == parent[x])
            return x;
        else return parent[x] = find(parent[x]);
    }

    public static void union(int p, int q) {
        p = find(p);
        q = find(q);

        if(p == q)
            return;

        if(rank[p] < rank[q])
            parent[p] = q;
        else {
            parent[q] = p;
        }

        if(rank[p] == rank[q])
            rank[p]++;
    }
}
