import java.util.Arrays;

public class successFullPairs {

    static int[] successfulPairs(int[] spells, int[] potions, long success) {
        // fisrt sort the potions array to apply binary search
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int noOfPairs = pairs(spells[i], potions, 0, success);
            ans[i] = noOfPairs;
        }
        return ans;
    }

    static int pairs(int spellElement, int[] potions, int count, long success) {
        int s = 0;
        int e = potions.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (((long) spellElement * potions[mid]) >= success) {
                count += e - (mid - 1);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] spells = { 5, 1, 3 };
        int[] potions = { 1, 2, 3, 4, 5 };
        int[] ans = successfulPairs(spells, potions, 7);
        System.out.println(Arrays.toString(ans));
    }
}