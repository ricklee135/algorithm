package DuplicatedNumbersWithoutModifyArray;

import java.util.*;
public class DuplicateNumbersWithoutModifyArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int[] nums = new int[length];
        Scanner numInput = new Scanner(System.in);
        for(int i = 0; i < length; i++){
            nums[i] = numInput.nextInt();
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int j = 0; j < length; j++){
            hashMap.put(nums[j],hashMap.getOrDefault(nums[j],0) + 1);
            //hashmap.getOrDefault(nums[j],0 + 1);
        }
       /* for(Integer v: hashMap.values()) {
            System.out.println(v);
        } */
        for(int k = 0; k < length; k++){
            if(hashMap.get(nums[k]) > 1){
                System.out.println(nums[k]);
                break;
            }
        }
    }
}
/*    public static Object getKey(Map map, Object value){
        List<Object> keyList = new ArrayList<>();
        for(Object key: map.keySet()){
            if(map.get(key).equals(value)){
                keyList.add(key);
            }
        }
        return keyList;
    }*/



