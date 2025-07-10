import java.util.HashMap;

public class MajorityElement {

    public static void printMajorityElements(int nums[])
    {
        HashMap<Integer, Integer> map = new HashMap<>();    
        int n = nums.length;

        for(int i = 0; i < n; i++)
        {
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1); // increasing the frequnecy if element already present
            else
                map.put(nums[i], 1); // added the element if not persent already
        }

        for(int key : map.keySet())
        {
            if(map.get(key) > n/3)
                System.out.println(key);
        }
    }
    
    public static void main(String[] args) {
        int nums[] = {1,2};
        printMajorityElements(nums);
    }
}
