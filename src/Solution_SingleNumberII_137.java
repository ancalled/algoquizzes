
public class Solution_SingleNumberII_137 {

    public int singleNumber(int[] nums) {
        int maxNum = nums[nums.length - 1];
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        for (int i = 1; i <= maxNum; i++) {
            result ^= i;
        }
        return result;

    }

    public static void main(String[] args) {
        String input = "[2,2,3,2]";
        int[] intAr = ArgsParserUtil.convertArgs(input);

//        int a = 2;
//        int b = 3;
//        System.out.println(a ^ b);
//        System.out.println(2 ^ 2  ^ 2);

        int res = new Solution_SingleNumberII_137().singleNumber(intAr);
        System.out.println(res);
    }
}
