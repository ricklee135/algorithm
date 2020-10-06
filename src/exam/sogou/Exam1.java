package exam.sogou;
//https://www.nowcoder.com/discuss/525709?type=post&order=time&pos=&page=1&channel=1009&source_id=search_post
import java.util.*;
public class Exam1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        if(k == n){
            System.out.println(count);
            System.out.println(count);
        }else if(k == 0){
            System.out.println(0);
            System.out.println(n - count);
        }else{
            if(count + k < n){
                System.out.println(0);
                System.out.println(n);
                //seg.end = n;
            }else if(count + k == n){
                System.out.println(0);
                System.out.println(n);
                //seg.start = 0;
                //seg.end = n;
            }else{
                System.out.println(count + k - n);
                System.out.println(count + n - k);
            }

    }}
}
