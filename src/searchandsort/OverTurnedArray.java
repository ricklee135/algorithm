package searchandsort;

public class OverTurnedArray {
    public static void main(String[] args) throws Exception {
        int[] array = {19,14,13,12,1,3,5,6,9};
        System.out.println(findMinNumber(array));
    }

    private static int findMinNumber(int[] array) throws Exception {
        int start = 0;
        int end = array.length - 1;
        //在旋转数组中有一个特例：如果把前面的0个元素，搬到最后面，即排序数组本身，
        //这仍然是一个数组的旋转。这既是把mid初始化为start的原因，
        int mid = start;
        if(end < 0){
            throw new Exception("invalid input");
        }
        while (array[start] >= array[end]){
            if(end - start == 1){
                mid = end;
                break;
            }
            mid = (end + start) / 2;
            //对于特殊数组{0， 1， 1， 1， 1}其有两个旋转，分别为：{11101}{10111}
            //这中情况下，start，end mid对应的元素都为1，无法判断中间的数字属于前面的
            //数组还是后面的数组。此时，只能采用顺序查找的方法。
            if(array[start] >= array[mid]){
                start = mid;
            }else if(array[mid] <= array[end]){
                end = mid;
            }
        }
        return array[mid];
    }
}
