package StringTraining;

import java.util.Scanner;
//https://www.nowcoder.com/practice/55fb3c68d08d46119f76ae2df7566880
public class IpJudge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.next();
        System.out.println(solve(ip));
    }
    public static String solve(String ip){
        if(ip.contains(".")){
            return isIp4(ip);
        }
        if(ip.contains(":")){
            return isIp6(ip);
        }
        return "Neither";
    }
    public static String isIp4(String ip){
        String[] str = ip.split("\\.");//这里需要转义一下
        int count = 0;
        if(str.length == 4){
            for(int i = 0; i < str.length; i++){
                if(str[i].charAt(0) == '0'){
                    return "Neither";
                }
                int cur = Integer.valueOf(str[i]);
                if(cur >= 0 && cur <= 255){
                    count++;
                }
            }
            if(count == 4){
                return "IPv4";
            }else {
                return "Neither";
            }
        }
        return "Neither";
    }
    public static String isIp6(String ip){
        int length = ip.length();
        ip.replaceAll("[g-z,G-Z]","");
        if(length != ip.length()){
            return "Neither";
        }
        String[] str = ip.split(":");
        if(str.length == 8) {
            int count = 0;
            for (int i = 0; i < str.length; i++) {
                if (str[i] == "") {
                    return "Neither";
                }
                if(str[i].length() >= 2){
                    if(str[i].charAt(0) =='0' && str[i].charAt(1) == '0'){
                        count++;
                    }
                }
            }
            if(count > 0){
                return "Neither";
            }else{
                return "IPv6";
            }
        }
        return "Neither";
    }
}
