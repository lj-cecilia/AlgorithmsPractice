import java.util.ArrayList;
import java.util.List;

class DiagonalTraversal2 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> lists = new ArrayList<>(); //store diagonally
        int count = 0; //total number of elements in result array

        //iterate input matrix
        for (int i = 0; i < nums.size(); i++) {

            //get current row
            List<Integer> row = nums.get(i);

            //for each element in this row
            for (int j = 0; j < row.size(); j++) {
                int index = i + j;
                if (lists.size() < index + 1) {
                    lists.add(new ArrayList<>());
                }
                lists.get(index).add(row.get(j));
                count++;
            }
        }

        int[] res = new int[count];
        int index = 0;
        for (List<Integer> list : lists) {
            for (int i = list.size() - 1; i >= 0; i--) {
                res[index++] = list.get(i);
            }
        }

        return res;
    }
}