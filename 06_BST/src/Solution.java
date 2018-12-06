import java.util.*;

/**
 * leetcode解题
 */
public class Solution {
    /**
     * leetcode 350. 两个数组的交集 II
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int num : nums1) {
            if (map1.containsKey(num)) {
                map1.put(num, map1.get(num) + 1);
            } else {
                map1.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (map1.containsKey(num)) {
                linkedList.add(num);
                map1.put(num, map1.get(num) - 1);
                if (map1.get(num) <= 0) {
                    map1.remove(num);
                }
            }
        }

        int[] res = new int[linkedList.size()];
        for (int i = 0; i < linkedList.size(); i++) {
            res[i] = linkedList.get(i);
        }
        return res;
    }

    /**
     * leetcode 771. 宝石与石头
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        /**
         * 方式一
         //         */
//        int count = 0;
//        for (int i = 0; i < S.length(); i++) {
//            int sc = S.charAt(i);
//            for (int j = 0; j < J.length(); j++) {
//                if (sc == J.charAt(j)) {
//                    count++;
//                }
//            }
//        }
//        return count;

        /**
         * 方式二
         */
        int count = 0;
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * leetcode 347. 前K个高频元素
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else {
                if (map.get(key) > map.get(queue.peek())) {
                    queue.remove();
                    queue.add(key);
                }
            }
        }
        for (int num : queue) {
            linkedList.add(num);
        }
        return linkedList;
    }

    /**
     * leeetcode 451. 根据字符出现频率排序
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        TreeMap<String, Integer> map = new TreeMap<>();
        String temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.substring(i, i + 1);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        for (String str : map.keySet()) {
            priorityQueue.add(str);
        }

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            temp = priorityQueue.remove();
            for (int i = 0; i < map.get(temp); i++) {
                sb.append(temp);
            }
        }
        return sb.toString();


    }
}
