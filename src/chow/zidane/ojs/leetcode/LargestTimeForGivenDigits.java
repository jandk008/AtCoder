package chow.zidane.ojs.leetcode;

class LargestTimeForGivenDigits {

    static String convert(final int[] nums) {
        String[] max = {""};
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : nums) {
            stringBuilder.append(i);
        }
        validate(stringBuilder.toString(), "", max);
        return max[0].equals("") ? max[0] : max[0].substring(0, 2) + ":" + max[0].substring(2);
    }

    private static void validate(String nums, String prefix, String[] max) {
        if (nums.length() == 0 && isValid(prefix) && prefix.compareTo(max[0]) > 0) {
            max[0] = prefix;
        } else {
            for (int i = 0; i < nums.length(); i++) {
                validate(nums.substring(0, i) + nums.substring(i + 1), prefix + nums.charAt(i), max);
            }
        }
    }

    private static boolean isValid(final String time) {
        return time.substring(0, 2).compareTo("24") < 0 && time.substring(2).compareTo("60") < 0;
    }
}
