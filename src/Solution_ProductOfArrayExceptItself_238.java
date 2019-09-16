import java.util.Arrays;
import java.util.stream.Collectors;

//Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
//        Memory Usage: 40.9 MB, less than 100.00% of Java online submissions for Product of Array Except Self.
public class Solution_ProductOfArrayExceptItself_238 {

    public int[] productExceptSelf(int[] nums) {

        int p = 1;
        int[] productsBellow = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            productsBellow[i] = p;
            p *= nums[i];
        }

        p = 1;
        int[] productsAbove = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            productsAbove[i] = p;
            p *= nums[i];
        }

        int[] products = new int[nums.length];
        for (int i = 0; i < products.length; i++) {
            products[i] = productsBellow[i] * productsAbove[i];
        }

        return products;
    }


    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4};
        int[] res = new Solution_ProductOfArrayExceptItself_238().productExceptSelf(ar);

        String resStr = Arrays.stream(res)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
        System.out.println("resStr = " + resStr);
        
    }

}
