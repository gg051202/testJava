package main.dimen;

public class UpdateDimen_androidDevelopFrame {

    /**
     * System.out.println("......"+getResources().getConfiguration().smallestScreenWidthDp)
     * 写多少个值,就会自动生成多个对应的values-w***dp文件夹
     */
    public static final int[] DIMENS = new int[]{240, 270, 320, 360, 411, 480, 540, 600, 720, 800, 820, 1280};
    public static final String DIRECTORY = "/Users/guilinlin/Documents/DevelopFiles/AndroidStudioProjects/" +
            "AndroidDevelopDimen/main.java.dimen/src/main/res";


    /**
     * 默认的尺寸
     */
    public static final float BASE = 411;

    public static void main(String[] args) {
        UpdateDimen.make(DIRECTORY, BASE, DIMENS);
    }

}