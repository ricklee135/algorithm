package StringTraining.StringReplace;

public class ReplaceString2 {
    public static void main(String[] args) {
        String str = "wearehappy";
        int count = 0;
        for(int j = 0; j < str.length(); j++){
            if(str.charAt(j) == ' ')//注意，char类型需要''.
            count++;
        }
       // if(count == 0){
        //    System.out.println(str);
        //}
        char[] strReplaced = new char[str.length() + 3 * count];
        int indexOld = str.length() - 1;
        int indexNew = strReplaced.length - 1;
        while (indexOld >= 0 && indexNew >= indexOld){
            if(str.charAt(indexOld) == ' '){
                strReplaced[indexNew--] = '0';
                strReplaced[indexNew--] = '2';
                strReplaced[indexNew--] = '%';
            }else{
                strReplaced[indexNew--] = str.charAt(indexOld);
            }
            indexOld--;
        }
        //System.out.println(strReplaced.toString());//输出为: [C@1540e19d
        String strReplacedToString = new String(strReplaced);//通过这种方式将char[]转换为String
        System.out.println(strReplacedToString);
    }
}
