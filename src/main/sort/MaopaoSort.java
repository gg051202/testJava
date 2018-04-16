package main.sort;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.text.ParseException;
import java.util.Arrays;

/**
 * Created by guilinlin on 2018/3/29 11:27.
 * email 973635949@qq.com
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MaopaoSort {

    static int NUMBER = 1000000;
    static boolean SHOW_RESULT = false;

    @Test
    public void _00Test() throws ParseException {
//        _11bubblingSort();//冒泡
//        _12selectSort();//选择
//        _13insertSort();//插入
        _14quickSort();//快速
        _15heapSort();//堆
        _16shellSort();//希尔
        _17mergeSort();//归并
//        _18countSort();//计数
//        _19BucketSort();//桶
//        _20RadixSort();//基数

    }

    /**
     * 冒泡排序  O(n^2)
     */
    @Test
    public void _11bubblingSort() throws ParseException {
        if (NUMBER >= 100000) {
            System.out.println("冒泡排序太慢,pass");
            return;
        }

        int list[] = Util.getList();
        long current = System.currentTimeMillis();

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                //>表示从小到大排列 , <表示从大到小排列
                if (list[j] < list[j + 1]) {
                    Util.switchValue(list, j + 1, j);
                }
            }
        }
        Util.printLog("冒泡排序", current, list);
    }


    /**
     * 选择排序 O(n^2)
     */
    @Test
    public void _12selectSort() {
        if (NUMBER >= 200000) {
            System.out.println("选择排序太慢,pass");
            return;
        }
        int list[] = Util.getList();
        long current = System.currentTimeMillis();

        int index;
        for (int i = 0; i < list.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < list.length; j++) {
                //>表示从小到大排列 , <表示从大到小排列
                if (list[index] < list[j]) {
                    index = j;
                }
            }
            //>表示从小到大排列 , <表示从大到小排列
            if (index != i) {
                Util.switchValue(list, index, i);
            }
        }

        Util.printLog("选择排序", current, list);
    }

    /**
     * 插入排序 O(n^2)
     */
    @Test
    public void _13insertSort() {
        int[] list = Util.getList();
        long current = System.currentTimeMillis();

        int target;
        for (int i = 1; i < list.length; i++) {
            target = i;
            for (int j = i - 1; j >= 0; j--) {
                //>表示从小到大排列 , <表示从大到小排列
                if (list[j] < list[i]) {
                    target = j;
                } else {
                    break;
                }
            }
            if (target != i) {
                int a = list[i];
                for (int m = i; m > target; m--) {
                    list[m] = list[m - 1];
                }
                list[target] = a;

            }
        }
        Util.printLog("插入排序", current, list);
    }


    /**
     * 快速排序 O(nlgn)
     * todo 代码需优化,和博客里写的,有一点点差距,怀疑是交换数据次数多
     */
    @Test
    public void _14quickSort() {
        int[] list = Util.getList();
        long current = System.currentTimeMillis();

        divideList(list, 0, list.length - 1);

        Util.printLog("快速排序", current, list);
    }

    private void divideList(int[] list, int start, int end) {
        int oldStart = start;
        int oldEnd = end;
        int key = start;
        while (start < end) {
            for (; end > start; end--) {
                if (list[end] < list[key]) {
                    Util.switchValue(list, key, end);
                    key = end;
                    break;
                }
            }
            for (; start < end; start++) {
                if (list[start] > list[key]) {
                    Util.switchValue(list, key, start);
                    key = start;
                    break;
                }
            }
        }
        if (oldStart < key - 1) {
            divideList(list, oldStart, key - 1);
        }
        if (oldEnd > key + 1) {
            divideList(list, key + 1, oldEnd);
        }

    }

    /**
     * 堆排序 O(logN)
     */
    @Test
    public void _15heapSort() {

        int[] list = Util.getList();
        long current = System.currentTimeMillis();
        for (int i = list.length / 2 - 1; i >= 0; i--) {
            makeHeap(list, i, list.length);
        }

        for (int i = list.length - 1; i > 0; i--) {
            Util.switchValue(list, i, 0);
            makeHeap(list, 0, i);
        }

        Util.printLog("堆排序、", current, list);
    }

    private void makeHeap(int[] list, int i, int length) {


        int temp = list[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            //构建大顶堆表示升序  ,<表示大顶堆 , >表示小顶堆
            if (j + 1 < length && list[j] > list[j + 1]) {
                j++;
            }
            //构建大顶堆表示升序  ,>表示大顶堆 , <表示小顶堆
            if (list[j] < temp) {
                list[i] = list[j];
                i = j;
            } else {
                break;
            }
        }
        list[i] = temp;

    }

    /**
     * 希尔排序 olog(n)
     */
    @Test
    public void _16shellSort() {

        int[] list = Util.getList();
        long current = System.currentTimeMillis();

        int grap = list.length / 2;
        while (grap > 0) {
            for (int start = 0; start < grap; start++) {
                shellSort(list, start, grap);
            }
            grap /= 2;
        }

        Util.printLog("希尔排序", current, list);
    }

    private void shellSort(int[] list, int start, int grap) {
        int target;
        for (int i = start + grap; i < list.length; i += grap) {
            target = i;
            for (int j = i - grap; j >= start; j -= grap) {
                //>表示从小到大排列 , <表示从大到小排列
                if (list[j] > list[i]) {
                    target = j;
                } else {
                    break;
                }
            }
            if (target != i) {
                int a = list[i];
                for (int m = i; m > target; m -= grap) {
                    list[m] = list[m - grap];
                }
                list[target] = a;
            }

        }
    }

    /**
     * 归并排序 nLog(N)
     */
    @Test
    public void _17mergeSort() {

//        int[] list = Util.getList();
        int[] list = new int[]{2, 345, 12, 4, 1};
        long current = System.currentTimeMillis();

        split(list, 0, list.length);

        Util.printLog("归并排序", current, list);
    }

    private int[] split(int[] list, int start, int end) {
        int mid = start + (end - start) / 2;
        split(list, start, mid);
        split(list, mid + 1, end);
        return list;
    }

    @Test
    public void testMerge() {
        System.out.println(Arrays.toString(mergeList(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8, 9})));

    }

    private int[] mergeList(int[] list1, int[] list2) {
        int[] res = new int[list1.length + list2.length];
        int start1 = 0;
        int start2 = 0;
        while (start1 < list1.length && start2 < list2.length) {
            System.out.println(start1 + "," + start2);
            if (start1 == list1.length - 1 ) {
                res[start1 + start2] = list2[start2];
                start2++;
                continue;
            }
            if (start2 == list2.length - 1 ) {
                res[start1 + start2] = list1[start1];
                start1++;
                continue;
            }
            if (list1[start1] < list2[start2]) {
                res[start1 + start2] = list1[start1];
                start1++;
            } else {
                res[start1 + start2] = list1[start2];
                start2++;
            }
        }
        return res;
    }


    /**
     * 计数排序
     */
    @Test
    public void _18countSort() {

        int[] list = Util.getList();
        long current = System.currentTimeMillis();

        Util.printLog("计数排序", current, list);
    }

    /**
     * 桶排序
     */
    @Test
    public void _19BucketSort() {

        int[] list = Util.getList();
        long current = System.currentTimeMillis();

        Util.printLog("桶排序、", current, list);
    }

    /**
     * 基数排序
     */
    @Test
    public void _20RadixSort() {

        String a = "  asd  ";
        System.out.println(a.trim());

        int[] list = Util.getList();
        long current = System.currentTimeMillis();

        Util.printLog("基数排序", current, list);
    }
}

