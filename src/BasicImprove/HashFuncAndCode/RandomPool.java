package BasicImprove.HashFuncAndCode;

import java.util.HashMap;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/23 15:33
 * RandomPool
 */
public class RandomPool {
    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<K, Integer>();
            this.indexKeyMap = new HashMap<Integer, K>();
            this.size = 0;
        }

        public void insert(K key) {
            if (!this.keyIndexMap.containsKey(key)) {
                this.keyIndexMap.put(key, this.size);
                this.indexKeyMap.put(this.size++, key);
            }
        }

        public void delete(K k) {
            if (this.keyIndexMap.containsKey(k)) {
                int deleteIndex = this.keyIndexMap.get(k);
                int lastIndex = --this.size;
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey, deleteIndex);
                this.indexKeyMap.put(deleteIndex, lastKey);
                this.keyIndexMap.remove(k);
                this.indexKeyMap.remove(lastIndex);
            }
        }

        public K getRandom() {
            if (this.size == 0) return null;
            int randomIndex = (int) (Math.random() * this.size);
            return this.indexKeyMap.get(randomIndex);
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<>();
        pool.insert("xue");
        pool.insert("xiao");
        pool.insert("lei");
        String s = pool.getRandom();
        System.out.println(s);
        pool.delete("xue");
        pool.delete("xiao");
        s = pool.getRandom();
        System.out.println(s);
    }
}
