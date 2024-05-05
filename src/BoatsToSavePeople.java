import java.util.Arrays;

//time O(nlogn)
//space O(1)
class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int smallIndex = 0;
        int largeIndex = people.length - 1;
        int boats = 0;

        while (smallIndex <= largeIndex) {
            if (people[smallIndex] + people[largeIndex] <= limit) {
                smallIndex++;
            }
            boats++;
            largeIndex--;
        }
        return boats;
    }
}