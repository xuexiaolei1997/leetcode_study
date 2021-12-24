package Basic.LinkList;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/14 21:11
 */
public class LinkList_ {

    // 单链表
    public static Node_ createSingleLinkList(int[] arr) {
        if (arr == null || arr.length < 2) return new Node_(-1);

        Node_ head = new Node_(-1);
        Node_ p = head;

        for (int i = 0; i < arr.length; i++) {
            Node_ node = new Node_(arr[i]);
            p.next = node;
            p = p.next;
        }
        return head;
    }

    // 双向链表
    public static Node_ createBiLinkList(int[] arr) {
        Node_ head = new Node_(-1);
        Node_ p = head;

        for (int i = 0; i < arr.length; i++) {
            Node_ node = new Node_(arr[i]);
            node.data = arr[i];
            p.next = node;
            node.prior = p;
            p = p.next;
        }
        return head;
    }

    // 双向循环链表
    public static Node_ createBiReLinkList(int[] arr) {
        if (arr == null || arr.length < 2) return new Node_(-1);

        Node_ head = new Node_(-1);
        Node_ p = head;

        for (int i = 0; i < arr.length; i++) {
            Node_ node = new Node_(arr[i]);
            node.data = arr[i];
            p.next = node;
            node.prior = p;
            p = p.next;
        }
        head.prior = p;
        p.next = head;
        return head;
    }

    // 头插法反转单链表
    public static Node_ inverseSingleLinkList(Node_ head) {
        Node_ p = new Node_(-1);
        while (head != null) {
            Node_ temp = head.next;
            head.next = p.next;
            p.next = head;
            head = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 3};
        Node_ head = createSingleLinkList(arr);
        Node_ p = inverseSingleLinkList(head);
        System.out.println();
    }
}
