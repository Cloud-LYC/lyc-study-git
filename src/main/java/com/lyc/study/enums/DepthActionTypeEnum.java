package com.lyc.study.enums;

/**
 * 用户深度行为
 * @project :  cip-growth-recengine
 * Created by liyuanchi on 2017/11/1
 */
public enum DepthActionTypeEnum {

    //交易类行为
    PAY(1, "trade.1"),//买单
    GROUP_BUY(2,"trade.2"),//团购
    TAKEAWAYS(3,"trade.3"),//外卖

    //浏览(商户、推荐菜、点评)
    SCAN_SHOP(4,"scanshop"), //商户
    SCAN_DISH(5,"scan.dish"), //推荐菜
    SCAN_REVIEW(6,"scan.review"),//点评

    OPENMAP(7,"openmap.1"),//打开导航

    //分享过(商户、团单、内容文章、活动)
    SHARE_SHOP(8,"share.shop"), //商户
    SHARE_DEAL(9,"share.deal"), //团单
    SHARE_ARTICLE(10,"share.article"), //内容文章
    SHARE_ACTIVITY(11,"share.activity"),//活动

    //收藏过(商户、团单、头条)
    COLLECT_SHOP(12,"collect.shop"), //商户
    COLLECT_DEAL(13,"collect.deal"), //团单
    COLLECT_HEADLINE(14,"collect.headline");//头条


    private int code;

    private String name;


    DepthActionTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static DepthActionTypeEnum fromCode(int code) {
        for (DepthActionTypeEnum s : DepthActionTypeEnum.values()) {
            if (code == s.getCode()) {
                return s;
            }
        }
        return null;
    }

    public static DepthActionTypeEnum fromName(String name) {
        for (DepthActionTypeEnum s : DepthActionTypeEnum.values()) {
            if (name.equalsIgnoreCase(s.getName())) {
                return s;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return String.valueOf("Code="+this.code+" Name="+this.name);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
