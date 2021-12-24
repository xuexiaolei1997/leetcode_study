package Basic.Greedy.Example;

import java.util.HashMap;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/22 11:56
 * 数字型字符串转为字母
 */
public class Integer2String {

    public static class Node_ {
        public String value;
        public Node_ left;
        public Node_ right;

        public Node_(String data) {
            this.value = data;
        }

    }

    public static HashMap<String, String> int2strMap = new HashMap<String, String>();

    public static HashMap<String, String> getMap() {
        int2strMap.put("1", "A");
        int2strMap.put("2", "B");
        int2strMap.put("3", "C");
        int2strMap.put("4", "D");
        int2strMap.put("5", "E");
        int2strMap.put("6", "F");
        int2strMap.put("7", "G");
        int2strMap.put("8", "H");
        int2strMap.put("9", "I");
        int2strMap.put("10", "J");
        int2strMap.put("11", "K");
        int2strMap.put("12", "L");
        int2strMap.put("13", "M");
        int2strMap.put("14", "N");
        int2strMap.put("15", "O");
        int2strMap.put("16", "P");
        int2strMap.put("17", "Q");
        int2strMap.put("18", "R");
        int2strMap.put("19", "S");
        int2strMap.put("20", "T");
        int2strMap.put("21", "U");
        int2strMap.put("22", "V");
        int2strMap.put("23", "W");
        int2strMap.put("24", "X");
        int2strMap.put("25", "Y");
        int2strMap.put("26", "Z");
        return int2strMap;
    }

    // 构建树模型进行转换
    public static Node_ process1(String s, int i, Node_ head, HashMap<String, String> int2strMap) {
        if (i == s.length()) return null;
        if (int2strMap.containsKey(s.substring(i, i + 1))) {
            Node_ left = new Node_(int2strMap.get(s.substring(i, i + 1)));
            process1(s, i + 1, left, int2strMap);
            head.left = left;
        }
        if (i < s.length() - 1 && int2strMap.containsKey(s.substring(i, i + 2))) {
            Node_ right = new Node_(int2strMap.get(s.substring(i, i + 2)));
            process1(s, i + 2, right, int2strMap);
            head.right = right;
        }
        return head;
    }

    public static int process(char[] arr, int i) {
        if (i == arr.length) return 1;
        if (arr[i] == '0') return 0;
        if (arr[i] == '1') {
            int res = process(arr, i + 1);
            if (i + 1 < arr.length) {
                res += process(arr, i + 2);
            }
            return res;
        }
        return 0;
    }

    public static void printTree(Node_ head) {
        if (head == null) return;
        if (head.left != null) {
            printSubTree(head.left);
        }
        if (head.right != null) {
            printSubTree(head.right);
        }
    }

    public static Node_ printSubTree(Node_ head) {
        if (head == null) return null;
        if (!head.value.equals("-1"))
            System.out.print(head.value + " ");
        if (head.left != null) {
            printSubTree(head.left);
        }
        if (head.right != null) {
            System.out.println();
            if (!head.value.equals("-1"))
                System.out.print(head.value + " ");
            printSubTree(head.right);
        }
        return head;
    }

    public static void main(String[] args) {
        HashMap<String, String> int2strMap = getMap();
        Node_ head = process1("1212", 0, new Node_("-1"), int2strMap);
        printSubTree(head);
    }
}
