package main.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by guilinlin on 2018/3/30 13:53.
 * email 973635949@qq.com
 */

class Util {


    static int[] getList() {
        int[] result = new int[MaopaoSort.NUMBER];

        for (int i = 0; i < MaopaoSort.NUMBER; i++) {
            result[i] = new Random().nextInt(MaopaoSort.NUMBER * 10);
        }

        return result;

    }

    static void switchValue(int[] list, int index, int i) {
        int a = list[i];
        list[i] = list[index];
        list[index] = a;
    }

    static void printLog(String desc, long current, int[] list) {
        System.out.println(desc + ",耗时:" + (System.currentTimeMillis() - current));
        if (MaopaoSort.SHOW_RESULT) {
            System.out.println(Arrays.toString(list));
        }
    }
}
