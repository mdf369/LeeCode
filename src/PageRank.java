import java.util.*;

public class PageRank {

    private class Node{
        private int index;
        private Set<Node> children;
        private int st;
        private int ft;
        private int mIndex;
        private boolean inTree;

        public Node(int index) {
            this.index = index;
            children = new HashSet<>();
            st = -1;
            ft = -1;
            mIndex = -1;
            inTree = false;
        }

        public void addChild(Node node){
            children.add(node);
        }

        @Override
        public String toString(){
            return "[" + index + ", " + st + ", " + ft + "]";
        }
    }

    private int n;
    private int m;
    private List<Node> g;
    private List<Node> allNodes;
    private float[][] M;
    private float[] V;

    public PageRank(Scanner scanner){
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        n = Integer.parseInt(words[0]);
        m = Integer.parseInt(words[1]);

        g = new ArrayList<>();
        for(int i = 0;i < n;i++){
            g.add(new Node(i));
        }

        for(int i = 0;i < m;i++){
            int s, e;
            line = scanner.nextLine();
            words = line.split(" ");
            s = Integer.parseInt(words[0]);
            e = Integer.parseInt(words[1]);
            g.get(s).addChild(g.get(e));
        }

        allNodes = new ArrayList<>();
        allNodes.addAll(g);
    }

    public void dfs(List<Node> graph){
        int time = 1;
        while (true){
            int urIndex = getUnreached(graph);
            if(urIndex == -1) {
                break;
            }
            time = dfs(graph.get(urIndex), time);
        }
    }

    public List<Node> simpleDFS(List<Node> graph){
        Node root = null;
        for (Node node : graph) {
            if (node.children.size() == 0){
                node.inTree = true;
                continue;
            }
            root = node;
            break;
        }

        List<Node> tree = new ArrayList<>();
        getDFSTree(tree, root);
        return tree;
    }

    private void sortNodeListByFTOfGDesc(List<Node> nodeList){
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                Node node1 = g.get(o1.index);
                Node node2 = g.get(o2.index);
                return Integer.compare(node2.ft, node1.ft);
            }
        });
    }

    private void sortNodeListByST(List<Node> nodeList){
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.st, o2.st);
            }
        });
    }

    private void sortNodeListByIndex(List<Node> nodeList){
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.index, o2.index);
            }
        });
    }

    private int getUnreached(List<Node> graph){
        int index = 0;
        for(Node node : graph){
            if (node.st == -1 || node.ft == -1) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private int dfs(Node node, int time){
        node.st = time;
        time++;
        for(Node child : node.children){
            if (child.st != -1) {
                continue;
            }
            time = dfs(child, time);
        }
        node.ft = time;
        return time + 1;
    }

    public List<Node> getGT(List<Node> graph){
        List<Node> gt = new ArrayList<>();
        for(int i = 0;i < graph.size();i++){
            gt.add(new Node(i));
        }

        for (Node node : graph){
            for(Node child : node.children){
                gt.get(child.index).addChild(gt.get(node.index));
            }
        }
        return gt;
    }

    private void getDFSTree(List<Node> tree, Node root){
        Node node = g.get(root.index);
        root.inTree = true;
        tree.add(node);
        for (Node child : root.children){
//            if (!child.inTree && child.st > root.st && child.ft < root.ft) getDFSTree(tree, child);
            if (!child.inTree) {
                getDFSTree(tree, child);
            }
        }
    }

//    public List<Set<Node>> getAllSCC(){
//        dfs(g);
//        List<Node> gt = getGT(g);
//        sortNodeListByFTOfGDesc(gt);
//        dfs(gt);
//
//        List<Set<Node>> sccList = new ArrayList<>();
//        sortNodeListByST(gt);
//        int ft = -1;
//        for (Node node : gt){
//            if (node.st <= ft) continue;
//            ft = node.ft;
//            Set<Node> scc = new HashSet<>();
//            getDFSTree(scc, node);
//            sccList.add(scc);
//        }
//        return sccList;
//    }

    public List<Node> getOneSCC(){
        dfs(g);
        List<Node> gt = getGT(g);
        sortNodeListByFTOfGDesc(gt);
        List<Node> scc = simpleDFS(gt);
//        dfs(gt);
//
//        List<Node> scc = new ArrayList<>();
//        sortNodeListByST(gt);
//        for (Node node : gt){
//            if (node.ft - node.st == 1)continue;
//            getDFSTree(scc, node);
//            break;
//        }
        return scc;
    }

    public void clearOutsider(List<Node> graph, List<Node> nodeSet){
        graph.clear();
        graph.addAll(nodeSet);

        for (Node node : graph){
            node.children.retainAll(nodeSet);
        }
    }

    private float[][] createM(List<Node> graph){
        int size = graph.size();
        float[][] M = new float[size][size];
        for (int j = 0;j < size;j++){
            Node node = graph.get(j);
            float value = 1 / (float)node.children.size();
            for(Node child : node.children){
                M[child.mIndex][j] = value;
            }
        }
        return M;
    }

    private float[] mult(float[][] M, float[] V){
        float[] res = new float[V.length];
        for(int i = 0;i < V.length;i++){
            float sum = 0;
            for (int j = 0; j < V.length; j++) {
                sum += M[i][j] * V[j];
            }
            res[i] = sum;
        }
        return res;
    }

    private boolean equals(float[] V1, float[] V2){
        if (V1.length != V2.length) {
            return false;
        }
        for (int i = 0; i < V1.length; i++) {
            if (Math.abs(V1[i] - V2[i]) > 0.000005) {
                return false;
            }
        }
        return true;
    }

    private float[] getV(float[][] M){
        V = new float[g.size()];
        float value = (float) (1.0 / g.size());
        for (int i = 0; i < V.length; i++) {
            V[i] = value;
        }

        float[] newV;
        int counter = 0;
        while (true){
            newV = mult(M, V);
            if (equals(newV, V)) {
                break;
            }
            V = newV;
//            System.out.println(counter++);
//            String line = "";
//            for (float v : V) {
//                line += v + ", ";
//            }
//            System.out.println(line);
        }
        return V;
    }

    private float[] getV2(float[][] M){
        int l = M.length;
        for (int i = 0; i < M.length; i++) {
            M[i][i] -= 1;
        }
        for (int i = 0; i < M[0].length; i++) {
            M[0][i] = 1;
        }
//        float[] s = new float[]{1, 0, 0};
        float[] s = new float[l];
        s[0] = 1;
        preEli(M, s, l);
        return getRes(M, s, l);
    }

    private void wrap(float[][] M, float[] s, int l, int index) {
        float max = Math.abs(M[index][index]);
        int symbol = index;
        for (int i = index + 1; i < l; i++)
        {
            if (Math.abs(M[i][index]) > max) {
                max = Math.abs(M[i][index]);
                symbol = i;
            }
        }
        if (symbol != index) {
            for (int j = index; j < l; j++)
            {
                float x;
                x = M[index][j];
                M[index][j] = M[symbol][j];
                M[symbol][j] = x;
            }
            float b1;   //交换b的行
            b1 = s[index];
            s[index] = s[symbol];
            s[symbol] = b1;
        }
    }

    private void preEli(float[][] M, float[] s, int l) {
        for (int k = 0; k < l; k++) {
            wrap(M, s, l, k);
            for (int i = k + 1; i < l; i++) {
                float y = M[i][k] / M[k][k];
                M[i][k] = 0.0f;
                for (int j = k + 1; j < l; j++)
                    M[i][j] = M[i][j] - y * M[k][j];
                s[i] = s[i] - y * s[k];
            }
        }
    }

    public float compute(float[][] M, float[] s, float[] x, int index) {
        float sum = 0.0f;
        for (int i = index; i < x.length; i++) {
            sum += x[i] * M[index][i];
        }
        return sum;
    }

    private float[] getRes(float[][] M, float[] s, int l) {
        float[] res = new float[l];
        res[l - 1] = s[l - 1] / M[l - 1][l - 1];
        for (int i = l - 2; i >= 0; i--) {
            res[i] = (s[i] - compute(M, s, res, i)) / M[i][i];
        }
        return res;
    }

    public void  pageRank(){
        List<Node> scc = getOneSCC();
        clearOutsider(g, scc);
        sortNodeListByIndex(g);
        for(int i = 0;i < g.size();i++){
            g.get(i).mIndex = i;
        }

        M = createM(g);
        V = getV2(M);
    }

    public void displayV(int[] indexes){
        for (int index : indexes) {
            int mIndex = allNodes.get(index).mIndex;
            if (mIndex == -1) {
                System.out.println("None");
            } else {
                System.out.println(String.format("%.05f", V[mIndex]));
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        PageRank pageRank = new PageRank(scanner);
//
        int num = Integer.parseInt(scanner.nextLine());
        int[] indexes = new int[num];
        String[] sIndexes = scanner.nextLine().split(" ");
        for (int i = 0; i < sIndexes.length;i++){
            indexes[i] = Integer.parseInt(sIndexes[i]);
        }
        scanner.close();

        pageRank.pageRank();
        pageRank.displayV(indexes);
    }
}
