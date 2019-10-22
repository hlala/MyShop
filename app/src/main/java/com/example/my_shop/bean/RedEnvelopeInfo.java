package com.example.my_shop.bean;

import java.util.List;

public class RedEnvelopeInfo {

    /**
     * trace : null
     * referTraceId : null
     * errorCode : 0
     * errorMessage : null
     * content : {"list":[{"title":null,"items":[{"code":"202932125262970880","amount":280,"currency":"¥","title":"夏日专属券-平台通用","content":"满2800元减280元 满2000元减200元\n满1400元减140元 满1000元减100元\n满700元减70元","validPeriod":"有效期：2019-07-12至2019-07-23","showLimitRules":false,"limitRules":["1、同类红包每张订单限使用一个，且不能与部分优惠叠加使用","2、一次性使用，抵扣定金后的余额不能再使用","3、部分促销活动暂不支持红包支付，具体详见相关活动规则页面"],"fontColor":"#FF9645","backgroundColorStart":"#FCEFE5","backgroundColorEnd":"#FFE4CF","gray":true,"link":{"enabled":true,"title":null,"text":"已领取","navigateUrl":null}},{"code":"201857292462886912","amount":100,"currency":"¥","title":"途家民宿红包","content":"抵扣房费6.00% 最高抵扣100元","validPeriod":"有效期：2019-07-12至2019-09-30","showLimitRules":false,"limitRules":["1、同类红包每张订单限使用一个，且不能与部分优惠叠加使用","2、一次性使用，抵扣定金后的余额不能再使用","3、部分促销活动暂不支持红包支付，具体详见相关活动规则页面"],"fontColor":"#FF9645","backgroundColorStart":"#FCEFE5","backgroundColorEnd":"#FFE4CF","gray":false,"link":{"enabled":true,"title":null,"text":"立即领取","navigateUrl":null}},{"code":"202932074851631104","amount":60,"currency":"¥","title":"夏日专属券-平台通用","content":"抵扣房费7.00% 最高抵扣60元","validPeriod":"有效期：2019-07-12至2019-07-23","showLimitRules":false,"limitRules":["1、同类红包每张订单限使用一个，且不能与部分优惠叠加使用","2、一次性使用，抵扣定金后的余额不能再使用","3、部分促销活动暂不支持红包支付，具体详见相关活动规则页面"],"fontColor":"#FF9645","backgroundColorStart":"#FCEFE5","backgroundColorEnd":"#FFE4CF","gray":false,"link":{"enabled":true,"title":null,"text":"立即领取","navigateUrl":null}}],"desc":null}],"title":"红包","desc":"先领红包，订房更优惠哦~"}
     */

    private Object trace;
    private Object referTraceId;
    private int errorCode;
    private Object errorMessage;
    private ContentBean content;

    public Object getTrace() {
        return trace;
    }

    public void setTrace(Object trace) {
        this.trace = trace;
    }

    public Object getReferTraceId() {
        return referTraceId;
    }

    public void setReferTraceId(Object referTraceId) {
        this.referTraceId = referTraceId;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * list : [{"title":null,"items":[{"code":"202932125262970880","amount":280,"currency":"¥","title":"夏日专属券-平台通用","content":"满2800元减280元 满2000元减200元\n满1400元减140元 满1000元减100元\n满700元减70元","validPeriod":"有效期：2019-07-12至2019-07-23","showLimitRules":false,"limitRules":["1、同类红包每张订单限使用一个，且不能与部分优惠叠加使用","2、一次性使用，抵扣定金后的余额不能再使用","3、部分促销活动暂不支持红包支付，具体详见相关活动规则页面"],"fontColor":"#FF9645","backgroundColorStart":"#FCEFE5","backgroundColorEnd":"#FFE4CF","gray":true,"link":{"enabled":true,"title":null,"text":"已领取","navigateUrl":null}},{"code":"201857292462886912","amount":100,"currency":"¥","title":"途家民宿红包","content":"抵扣房费6.00% 最高抵扣100元","validPeriod":"有效期：2019-07-12至2019-09-30","showLimitRules":false,"limitRules":["1、同类红包每张订单限使用一个，且不能与部分优惠叠加使用","2、一次性使用，抵扣定金后的余额不能再使用","3、部分促销活动暂不支持红包支付，具体详见相关活动规则页面"],"fontColor":"#FF9645","backgroundColorStart":"#FCEFE5","backgroundColorEnd":"#FFE4CF","gray":false,"link":{"enabled":true,"title":null,"text":"立即领取","navigateUrl":null}},{"code":"202932074851631104","amount":60,"currency":"¥","title":"夏日专属券-平台通用","content":"抵扣房费7.00% 最高抵扣60元","validPeriod":"有效期：2019-07-12至2019-07-23","showLimitRules":false,"limitRules":["1、同类红包每张订单限使用一个，且不能与部分优惠叠加使用","2、一次性使用，抵扣定金后的余额不能再使用","3、部分促销活动暂不支持红包支付，具体详见相关活动规则页面"],"fontColor":"#FF9645","backgroundColorStart":"#FCEFE5","backgroundColorEnd":"#FFE4CF","gray":false,"link":{"enabled":true,"title":null,"text":"立即领取","navigateUrl":null}}],"desc":null}]
         * title : 红包
         * desc : 先领红包，订房更优惠哦~
         */

        private String title;
        private String desc;
        public List<ListBean> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * title : null
             * items : [{"code":"202932125262970880","amount":280,"currency":"¥","title":"夏日专属券-平台通用","content":"满2800元减280元 满2000元减200元\n满1400元减140元 满1000元减100元\n满700元减70元","validPeriod":"有效期：2019-07-12至2019-07-23","showLimitRules":false,"limitRules":["1、同类红包每张订单限使用一个，且不能与部分优惠叠加使用","2、一次性使用，抵扣定金后的余额不能再使用","3、部分促销活动暂不支持红包支付，具体详见相关活动规则页面"],"fontColor":"#FF9645","backgroundColorStart":"#FCEFE5","backgroundColorEnd":"#FFE4CF","gray":true,"link":{"enabled":true,"title":null,"text":"已领取","navigateUrl":null}},{"code":"201857292462886912","amount":100,"currency":"¥","title":"途家民宿红包","content":"抵扣房费6.00% 最高抵扣100元","validPeriod":"有效期：2019-07-12至2019-09-30","showLimitRules":false,"limitRules":["1、同类红包每张订单限使用一个，且不能与部分优惠叠加使用","2、一次性使用，抵扣定金后的余额不能再使用","3、部分促销活动暂不支持红包支付，具体详见相关活动规则页面"],"fontColor":"#FF9645","backgroundColorStart":"#FCEFE5","backgroundColorEnd":"#FFE4CF","gray":false,"link":{"enabled":true,"title":null,"text":"立即领取","navigateUrl":null}},{"code":"202932074851631104","amount":60,"currency":"¥","title":"夏日专属券-平台通用","content":"抵扣房费7.00% 最高抵扣60元","validPeriod":"有效期：2019-07-12至2019-07-23","showLimitRules":false,"limitRules":["1、同类红包每张订单限使用一个，且不能与部分优惠叠加使用","2、一次性使用，抵扣定金后的余额不能再使用","3、部分促销活动暂不支持红包支付，具体详见相关活动规则页面"],"fontColor":"#FF9645","backgroundColorStart":"#FCEFE5","backgroundColorEnd":"#FFE4CF","gray":false,"link":{"enabled":true,"title":null,"text":"立即领取","navigateUrl":null}}]
             * desc : null
             */

            public Object title;
            public Object desc;
            public List<ItemsBean> items;

            public Object getTitle() {
                return title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public Object getDesc() {
                return desc;
            }

            public void setDesc(Object desc) {
                this.desc = desc;
            }

            public List<ItemsBean> getItems() {
                return items;
            }

            public void setItems(List<ItemsBean> items) {
                this.items = items;
            }

            public static class ItemsBean {
                /**
                 * code : 202932125262970880
                 * amount : 280
                 * currency : ¥
                 * title : 夏日专属券-平台通用
                 * content : 满2800元减280元 满2000元减200元
                 满1400元减140元 满1000元减100元
                 满700元减70元
                 * validPeriod : 有效期：2019-07-12至2019-07-23
                 * showLimitRules : false
                 * limitRules : ["1、同类红包每张订单限使用一个，且不能与部分优惠叠加使用","2、一次性使用，抵扣定金后的余额不能再使用","3、部分促销活动暂不支持红包支付，具体详见相关活动规则页面"]
                 * fontColor : #FF9645
                 * backgroundColorStart : #FCEFE5
                 * backgroundColorEnd : #FFE4CF
                 * gray : true
                 * link : {"enabled":true,"title":null,"text":"已领取","navigateUrl":null}
                 */

                private String code;
                private int amount;
                private String currency;
                private String title;
                private String content;
                private String validPeriod;
                private boolean showLimitRules;
                private String fontColor;
                private String backgroundColorStart;
                private String backgroundColorEnd;
                private boolean gray;
                private LinkBean link;
                private List<String> limitRules;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public int getAmount() {
                    return amount;
                }

                public void setAmount(int amount) {
                    this.amount = amount;
                }

                public String getCurrency() {
                    return currency;
                }

                public void setCurrency(String currency) {
                    this.currency = currency;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getValidPeriod() {
                    return validPeriod;
                }

                public void setValidPeriod(String validPeriod) {
                    this.validPeriod = validPeriod;
                }

                public boolean isShowLimitRules() {
                    return showLimitRules;
                }

                public void setShowLimitRules(boolean showLimitRules) {
                    this.showLimitRules = showLimitRules;
                }

                public String getFontColor() {
                    return fontColor;
                }

                public void setFontColor(String fontColor) {
                    this.fontColor = fontColor;
                }

                public String getBackgroundColorStart() {
                    return backgroundColorStart;
                }

                public void setBackgroundColorStart(String backgroundColorStart) {
                    this.backgroundColorStart = backgroundColorStart;
                }

                public String getBackgroundColorEnd() {
                    return backgroundColorEnd;
                }

                public void setBackgroundColorEnd(String backgroundColorEnd) {
                    this.backgroundColorEnd = backgroundColorEnd;
                }

                public boolean isGray() {
                    return gray;
                }

                public void setGray(boolean gray) {
                    this.gray = gray;
                }

                public LinkBean getLink() {
                    return link;
                }

                public void setLink(LinkBean link) {
                    this.link = link;
                }

                public List<String> getLimitRules() {
                    return limitRules;
                }

                public void setLimitRules(List<String> limitRules) {
                    this.limitRules = limitRules;
                }

                public static class LinkBean {
                    /**
                     * enabled : true
                     * title : null
                     * text : 已领取
                     * navigateUrl : null
                     */

                    private boolean enabled;
                    private Object title;
                    private String text;
                    private Object navigateUrl;

                    public boolean isEnabled() {
                        return enabled;
                    }

                    public void setEnabled(boolean enabled) {
                        this.enabled = enabled;
                    }

                    public Object getTitle() {
                        return title;
                    }

                    public void setTitle(Object title) {
                        this.title = title;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public Object getNavigateUrl() {
                        return navigateUrl;
                    }

                    public void setNavigateUrl(Object navigateUrl) {
                        this.navigateUrl = navigateUrl;
                    }
                }
            }
        }
    }
}
