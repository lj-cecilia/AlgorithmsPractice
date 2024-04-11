//time O(n)
//space O(1)
class Solution {
    public int numberStudentsCantEatLunch(int[] students, int[] sandwiches) {
        int squareStudent = 0, circularStudent = 0;
        for (int student : students) {
            if (student == 0) circularStudent++;
            else squareStudent++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0 && circularStudent <= 0) {
                return squareStudent;
            }
            if (sandwich == 1 && squareStudent <= 0) {
                return circularStudent;
            }
            if (sandwich == 0) circularStudent--;
            if (sandwich == 1) squareStudent--;
        }
        return Math.max(squareStudent, circularStudent);
    }
}