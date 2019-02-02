package top_interview;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }

        int gasTotal = 0;
        int costTotal = 0;
        for (int i = 0; i < gas.length; i++) {
            gasTotal += gas[i];
            costTotal += cost[i];
        }

        if (costTotal > gasTotal) {
            return -1;
        }

        boolean hold = false;
        int start = -1;
        int index = 0;
        int end = -1;
        while (true) {
            start = nextPositive(gas, cost, index);
            if (start == -1) {
                return -1;
            }

            hold = true;
            end = getFailPos(gas, cost, start);
            if (end == -1) {
                return start;
            } else {
                index = end;
            }
        }
    }

    private int getFailPos(int[] gas, int[] cost, int index) {
        int gasNum = 0;
        while (index < gas.length) {
            gasNum += gas[index] - cost[index];
            if (gasNum < 0) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private int nextPositive(int[] gas, int[] cost, int start) {
        while (start < gas.length) {
            if (gas[start] >= cost[start]) {
                return start;
            }
            start++;
        }
        return -1;
    }
}
