package BasicImprove.HashFuncAndCode;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/23 16:10
 */
public class BitMap {

    public static void main(String[] args) {
        int[] arr = new int[10];

        int i = 178;

        int numIndex = i / 32;
        int bitIndex = i % 32;

        // 第i位状态
        int s = ((arr[numIndex] >> bitIndex) & 1);

        // 第i位状态改为1
        arr[numIndex] = arr[numIndex] | (1 << bitIndex);

        // 第i位状态改为0
        arr[numIndex] = arr[numIndex] & (~(1 << bitIndex));

        // 拿出第i位的状态
        int bit = 1 & (arr[numIndex] >> bitIndex);
    }
}
