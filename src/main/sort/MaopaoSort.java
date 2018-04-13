package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by guilinlin on 2018/3/29 11:27.
 * email 973635949@qq.com
 */

class MaopaoSort {

    public static void main(String args[]) {

        int list[] = new int[]{1, 2, 3, 345, 6, 12, 3, 54, 5};

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] < list[j + 1]) {
                    int a = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = a;
                }
            }
        }
        System.out.println(Arrays.toString(list));

    }

    @Test
    public void test() {

    }

}
