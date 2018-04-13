package main.java.excel;

/**
 * Created by guilinlin on 2017/11/23 13:51.
 * email 973635949@qq.com
 */

class GradleData {
    private String channel;
    private String appName;
    private String packageName;
    private String channelKey;
    private String jpushKey;
    private String jpushMaster;
    private String umengKey;
    private String umengChannelName;
    private String jpushChannelName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getChannelKey() {
        return channelKey;
    }

    public void setChannelKey(String channelKey) {
        this.channelKey = channelKey;
    }

    public String getJpushKey() {
        return jpushKey;
    }

    public void setJpushKey(String jpushKey) {
        this.jpushKey = jpushKey;
    }

    public String getJpushMaster() {
        return jpushMaster;
    }

    public void setJpushMaster(String jpushMaster) {
        this.jpushMaster = jpushMaster;
    }

    public String getUmengKey() {
        return umengKey;
    }

    public void setUmengKey(String umengKey) {
        this.umengKey = umengKey;
    }

    public String getUmengChannelName() {
        return umengChannelName;
    }

    public void setUmengChannelName(String umengChannelName) {
        this.umengChannelName = umengChannelName;
    }

    public String getJpushChannelName() {
        return jpushChannelName;
    }

    public void setJpushChannelName(String jpushChannelName) {
        this.jpushChannelName = jpushChannelName;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "GradleData{" +
                "channel='" + channel + '\'' +
                ", appName='" + appName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", channelKey='" + channelKey + '\'' +
                ", jpushKey='" + jpushKey + '\'' +
                ", jpushMaster='" + jpushMaster + '\'' +
                ", umengKey='" + umengKey + '\'' +
                ", umengChannelName='" + umengChannelName + '\'' +
                ", jpushChannelName='" + jpushChannelName + '\'' +
                '}';
    }
}
