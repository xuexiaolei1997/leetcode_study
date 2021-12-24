package Basic.Greedy.Example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/20 14:48
 * 会议室安排宣讲会问题
 */
public class BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<Program> {

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    // 按照结束时间走
    public static int bestArrange(Program[] progeams, int timePoint) {
        Arrays.sort(progeams, new ProgramComparator());
        int restlt = 0;
        for (int i = 0; i < progeams.length; i++) {
            if (timePoint <= progeams[i].start) {
                restlt++;
                timePoint = progeams[i].end;
            }
        }
        return restlt;
    }
}
