package main.excel;

/**
 * Created by guilinlin on 2017/11/23 13:51.
 * email 973635949@qq.com
 */

class GradleData {
    private String channel;
    private String appName;
    private String packageName;
    private String channelKey;
    private String aliPushKey;
    private String aliPushSecret;
    private String umengKey;
    private String umengChannelName;
    private String serverType;
    private String logo;
    private String signType;

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAliPushKey() {
        return aliPushKey;
    }

    public void setAliPushKey(String aliPushKey) {
        this.aliPushKey = aliPushKey;
    }

    public String getAliPushSecret() {
        return aliPushSecret;
    }

    public void setAliPushSecret(String aliPushSecret) {
        this.aliPushSecret = aliPushSecret;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

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


    public String getChannel() {
        return channel;
    }

    public String getChannelName() {
        if (channel.equals("sdkj")) {
            return "_______test_______";
        }
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
                ", aliPushKey='" + aliPushKey + '\'' +
                ", aliPushSecret='" + aliPushSecret + '\'' +
                ", umengKey='" + umengKey + '\'' +
                ", umengChannelName='" + umengChannelName + '\'' +
                ", serverType='" + serverType + '\'' +
                '}';
    }
}
