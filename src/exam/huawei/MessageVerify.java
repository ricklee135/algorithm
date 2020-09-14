package exam.huawei;

import java.util.Scanner;
//5a 12 5b ba 34 5b bb 88 05 5a 75 cd bb 62 5a 34 cd 78 cc da fb 06 5a
public class MessageVerify {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String [] str = input.split("5a");
        StringBuffer sb = new StringBuffer();
        sb.append("5a");
//        for(int i = 1; i < str.length; i++){
//            System.out.println(str[i] + " ");
//        }
//        System.out.println(str.length);
        for(int i = 1; i < str.length;i++){
            if(!check(str[i])){
                continue;
            }else {
                sb.append(str[i]);
                sb.append("5a");
            }
        }
        System.out.println(sb.toString());
    }
//我们在使用java的split方法时，通常会遇到这样一个问题，想用分隔符拆分指定字符串时，发现末尾为空的字符串不会被拆分。
// https://blog.csdn.net/StemQ/article/details/52013824?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param
    private static boolean check(String s) {
        int count = 0;
        count = s.length() - s.replaceAll("5b ba ", "").length();
        count += s.length() - s.replaceAll("5b bb ", "").length();
        count = count / 6;
        String [] str = s.split(" ");
        int length = Integer.parseInt(str[str.length - 1]);
        if(s.length() / 3 - count - 1  ==  length)
            return true;
        return false;
    }
}
//5a 12 5b ba 34 5b bb 88 05 5a 34 cd 78 cc da fb 06 5a