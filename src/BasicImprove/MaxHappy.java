package BasicImprove;

import java.util.List;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/12/5 14:37
 */
public class MaxHappy {
    public static class Employee{
        public int happy;
        public List<Employee> nexts;
    }

    public static int maxHappy(Employee boss){
        Info headInfo = process(boss);
        return Math.max(headInfo.laiMaxHappy, headInfo.buMaxHappy);
    }

    public static class Info{
        public int laiMaxHappy;
        public int buMaxHappy;
        public Info(int lai, int bu){
            laiMaxHappy = lai;
            buMaxHappy = bu;
        }
    }

    public static Info process(Employee x){
        if (x.nexts.isEmpty()){  // x为基层员工
            return new Info(x.happy, 0);
        }
        int lai = x.happy;
        int bu = 0;
        for (Employee next : x.nexts) {
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;
            bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
        }
        return new Info(lai, bu);
    }
}
