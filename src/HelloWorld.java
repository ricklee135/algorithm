import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class HelloWorld
{
    public static void main(String [] args)
    {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1, 2));
        Pair n = q.poll();

        System.out.println(q.isEmpty());
        Queue<Pair> q1 = new PriorityQueue<>();
        Map<Integer,Integer> p = new HashMap<>();
        q.isEmpty();
        q.poll();
        Pair t = new Pair(1,3);
        Pair t2 = new Pair(2,3);
        Pair t3 = new Pair(0,3);
        q1.offer(t);
        q1.offer(t2);
        q1.offer(t3);
        System.out.println(q1.poll().first);
        System.out.println(q1.poll().second);
    }


}
class Pair implements Comparable<Pair>{
    public int first;
    public int second;
    public Pair(int i, int j){
        this.first = i;
        this.second = j;
    }


    @Override
    public int compareTo(Pair o) {
        if(o.first < this.first) {
            return 1;
        }else{
            return -1;
        }
    }
}