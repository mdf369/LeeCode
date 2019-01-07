import java.util.*;

public class Main {
    static int countNum;
    static Map<Integer, Set<Integer>> integerSetMap;

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String oneLine = scanner.nextLine();
        String[] words = oneLine.split(" ");
        int numberOfPoints = Integer.parseInt(words[0]);
        int numberOfEdges = Integer.parseInt(words[1]);

        countNum = 0;
        int[][] matrix = new int[numberOfPoints][numberOfPoints];
        int[][] matrix_T = new int[numberOfPoints][numberOfPoints];

        int[] status = new int[numberOfPoints];
        Node[] nodes = new Node[numberOfPoints];
        for(int i = 0; i < numberOfPoints; i++){
            status[i] = 0;
            nodes[i] = new Node();
        }
        for(int i = 0; i < numberOfEdges; i++){
            oneLine = scanner.nextLine();
            words = oneLine.split(" ");
            int formerIndex = Integer.parseInt(words[0]);
            int laterIndex = Integer.parseInt(words[1]);
            matrix[formerIndex][laterIndex] = 1;
            matrix_T[laterIndex][formerIndex] = 1;
        }
        Set<Integer> numOdRequest = new TreeSet<>();
        oneLine = scanner.nextLine();
        oneLine = scanner.nextLine();
        words = oneLine.split(" ");
        for(int i = 0; i < words.length;i++ ){
            numOdRequest.add(Integer.parseInt(words[i]));
        }

        for(int i = 0; i < numberOfPoints; i++){
            if(status[i] != 0){
                continue;
            }
            goToNextNode(numberOfPoints, i, matrix, nodes, status, false, -1);
        }

        integerSetMap = new HashMap<>();
        Arrays.sort(nodes);
        for(int i = 0; i < numberOfPoints; i++){
            status[i] = 0;
        }
        for(int i = 0; i < numberOfPoints; i++){
            int id = nodes[i].id;
            if(status[id] != 0){
                continue;
            }
            integerSetMap.put(id, new TreeSet<>());
            goToNextNode(numberOfPoints, id, matrix_T, nodes, status, true, id);
        }

        int idMax = -1, numMax = -1;
        for(Integer idx : integerSetMap.keySet()){
            int size = integerSetMap.get(idx).size();
            if(size > numMax){
                numMax = size;
                idMax = idx;
            }
        }

        double[][] trueSCC = new double[numMax][numMax];
        int[] idOfAllElement = new int[numberOfPoints];
        int indexCounter = 0;
        for(int i = 0; i < numberOfPoints;i++){
            idOfAllElement[i] = -1;
        }
        for(int elm : integerSetMap.get(idMax)){
            idOfAllElement[elm] = indexCounter;
            indexCounter++;
        }
        for(int i = 0; i < numberOfPoints; i++){
            int elementID = idOfAllElement[i];
            if(elementID == -1){
                continue;
            }
            int counterOfValid = 0;
            for(int j = 0; j < numberOfPoints; j++){
                if(idOfAllElement[j] == -1){
                    continue;
                }
                int anotherId = idOfAllElement[j];
                trueSCC[elementID][anotherId] = matrix[i][j];
                if(trueSCC[elementID][anotherId] == 1){
                    counterOfValid++;
                }
            }
            for(int j = 0; j < numMax; j++){
                trueSCC[elementID][j] /= counterOfValid;
            }
        }

        double initValueOfWeb = 1.0/numMax;
        double[][] webOfV = new double[2][numMax];
        for(int i = 0; i < numMax; i++ ){
            webOfV[0][i] = initValueOfWeb;
            webOfV[1][i] = 0;
        }

        int valueOfNext = 1, valueOfFormer = 0;
        while (!ifComplete(webOfV, numMax, 1e-9)){
            for(int i = 0; i < numMax; i++){
                double counter = 0;
                for(int j = 0; j < numMax; j++){
                    counter += webOfV[valueOfFormer][j] * trueSCC[j][i];
                }
                webOfV[valueOfNext][i] = counter;
            }
            valueOfNext = 1 - valueOfNext;
            valueOfFormer = 1 - valueOfFormer;
        }

        for(int request : numOdRequest){
            int requestID = idOfAllElement[request];
            if(requestID == -1){
                System.out.println("None");
            }
            else {
                System.out.println(String.format("%.05f", webOfV[valueOfFormer][requestID]));
            }
        }

    }

    public static void goToNextNode(int n, int i, int[][] graph, Node[] nodes, int[] status, boolean isReverse, int idOfSet){
        countNum++;
        status[i] = 1;
        for(int j = 0; j < n; j++){
            if(graph[i][j] == 1 && status[j] == 0){
                goToNextNode(n, j, graph, nodes, status, isReverse, idOfSet);
            }
        }
        countNum++;
        status[i] = 2;
        nodes[i].f = countNum;
        nodes[i].id = i;
        if(isReverse){
            integerSetMap.get(idOfSet).add(i);
        }
    }

    public static boolean ifComplete(double[][] wholeWeb, int num, double threshold){
        for(int i = 0; i < num; i++){
            if(Math.abs(wholeWeb[0][i] - wholeWeb[1][i]) > threshold){
                return false;
            }
        }
        return true;
    }

    static class Node implements Comparable<Node>{
        public int id;
        public int f;
        public Node(){}
        public Node(int id, int f){
            this.id = id;
            this.f = f;
        }

        @Override
        public int compareTo(Node o) {
            return o.f-f;
        }
    }
}