package com.example.my_shop.bean;

import java.io.Serializable;

public class CashBackBannerVo implements Serializable {
    /**
     * banner类型 1-首单返现 2-砍价
     */
    public int bannerType;
    /**
     * 砍价专用 当前砍价活动状态 1-砍价尚未发起 2-砍价进行中 3-活动满级结束或时间截止 4-活动关闭 5-订单取消或拒单导致活动结束
     */
    public int bargainStatus;
    /**
     * 砍价专用 活动状态展示文案
     */
    public String bargainStatusDesc;
    /**
     * 按钮
     */
    public TextLinkVo button;
    /**
     * 活动倒计时(S)
     */
    public int countDown;
    /**
     * 置灰
     */
    public boolean gray;
    /**
     * 跳转链接
     */
    public String linkUrl;
    /**
     * 背景图片
     */
    public String pictureUrl;
    /**
     * 副标题
     */
    public String subTitle;
    /**
     * 字体颜色
     */
    public String textColor;
    /**
     * 标题
     */
    public String title;
}
