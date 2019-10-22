package com.example.my_shop.bean;

import java.util.List;

public class HouseListDetailedInfoJson {
    /**
     * content : {"shareSetting":{"shareTitle":"#北京#民宿里晒太阳，过个慢生活","shareImageUrl":"https://pic.tujia.com/upload/leaderboard/day_190325/201903251547292848.jpg","shareDescription":"北京超赞住宿特辑","shareUrl":"https://m.tujia.com/pwa/promotion/leaderBoard?cityId=48&id=673","shareUrlForWeChatSmallApp":null,"shareMessage":"我在途家发现了一个超赞的房屋攻略:#北京#民宿里晒太阳，过个慢生活。https://m.tujia.com/pwa/promotion/leaderBoard?cityId=48&id=673","enumAppShareChannel":15,"isReturnShareResult":false,"isAppendShareUser":false},"leaderboardDetailModel":{"title":"民宿里晒太阳，过个慢生活","subTitle":"日盛阳光、夜落星辰，感受真实的自然。","description":"透过窗棂，张望阳光，懒散地舒展着腰肢，静静享受太阳给予的温暖，享受那份难得的温馨。","pictureUrl":"https://pic.tujia.com/upload/leaderboard/day_190325/201903251547292848.jpg","leaderboardUnitCardList":[{"title":null,"subTitle":null,"leaderboardUnitCardItemList":[{"unitID":5093552,"summary":"阳光房里做个粉黛佳人","description":"粉黛大理石色系配合点点金属灯饰，你便是今天的粉黛佳人","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221527372479.jpg"},{"unitID":2832256,"summary":"明媚阳光房偷得小憩时光","description":"明媚的阳光，洒在惺忪的睫毛。睁开眼感受涌入心间的温暖，享受这精致时光。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521298955.jpg"},{"unitID":6000010,"summary":"品读设计师的王府井阳光空间","description":"阳光懒散的透过云层，从窗外射进一道道光影，抬头的时候甚至有一点炫目。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521395955.jpg"},{"unitID":1032559,"summary":"古色古香中睡进中式暖阳房","description":"\u201c栽下梧桐树,自有凤凰来\u201d阳关穿插在院落之间，风景之外，还是风景。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521547592.jpg"},{"unitID":9821295,"summary":"一缕阳光住进原木色禅意生活","description":"简约通透，斜阳映入，卸下奔波的笑靥和炊烟，别样惬意温暖。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_190213/201902131516074152.jpg"},{"unitID":515447,"summary":"每1㎡都透着阳光的工业风LOFT","description":"美好和温暖光线，微风拂过轻纱，一进门便是轻松惬意的感觉。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221524328360.jpg"},{"unitID":1786995,"summary":"阳光下的复古工业style","description":"坐在窗边，亲近暖阳，感受阳光的跳动，目视风景和行人，小酌一杯，很是惬意。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221525379971.jpg"},{"unitID":1031572,"summary":"美式阳光房尽享部落原乡","description":"纯粹的美式西部风情让人仿佛穿越到美国。打开门，阳光穿透，如家一般的温馨。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221525353958.jpg"},{"unitID":303493,"summary":"零距离触碰中式温暖","description":"阳光竹帘，卷起一帘幽梦。满地的斜阳，风吹着帘子，地板上一条条日影便晃晃悠悠的。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221526467453.jpg"},{"unitID":5788379,"summary":"城市爱丽丝阳光后花园","description":"如爱丽丝梦游中的仙境，绿意花林中溪水潺潺，是城市里难得的阳光后花园。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221527235096.jpg"}]}]}}
     * cityID : 48
     * cityName : 北京
     * errorCode : 0
     * errorMessage : null
     */

    private ContentBean content;
    private int cityID;
    private String cityName;
    private int errorCode;
    private Object errorMessage;

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public static class ContentBean {
        /**
         * shareSetting : {"shareTitle":"#北京#民宿里晒太阳，过个慢生活","shareImageUrl":"https://pic.tujia.com/upload/leaderboard/day_190325/201903251547292848.jpg","shareDescription":"北京超赞住宿特辑","shareUrl":"https://m.tujia.com/pwa/promotion/leaderBoard?cityId=48&id=673","shareUrlForWeChatSmallApp":null,"shareMessage":"我在途家发现了一个超赞的房屋攻略:#北京#民宿里晒太阳，过个慢生活。https://m.tujia.com/pwa/promotion/leaderBoard?cityId=48&id=673","enumAppShareChannel":15,"isReturnShareResult":false,"isAppendShareUser":false}
         * leaderboardDetailModel : {"title":"民宿里晒太阳，过个慢生活","subTitle":"日盛阳光、夜落星辰，感受真实的自然。","description":"透过窗棂，张望阳光，懒散地舒展着腰肢，静静享受太阳给予的温暖，享受那份难得的温馨。","pictureUrl":"https://pic.tujia.com/upload/leaderboard/day_190325/201903251547292848.jpg","leaderboardUnitCardList":[{"title":null,"subTitle":null,"leaderboardUnitCardItemList":[{"unitID":5093552,"summary":"阳光房里做个粉黛佳人","description":"粉黛大理石色系配合点点金属灯饰，你便是今天的粉黛佳人","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221527372479.jpg"},{"unitID":2832256,"summary":"明媚阳光房偷得小憩时光","description":"明媚的阳光，洒在惺忪的睫毛。睁开眼感受涌入心间的温暖，享受这精致时光。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521298955.jpg"},{"unitID":6000010,"summary":"品读设计师的王府井阳光空间","description":"阳光懒散的透过云层，从窗外射进一道道光影，抬头的时候甚至有一点炫目。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521395955.jpg"},{"unitID":1032559,"summary":"古色古香中睡进中式暖阳房","description":"\u201c栽下梧桐树,自有凤凰来\u201d阳关穿插在院落之间，风景之外，还是风景。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521547592.jpg"},{"unitID":9821295,"summary":"一缕阳光住进原木色禅意生活","description":"简约通透，斜阳映入，卸下奔波的笑靥和炊烟，别样惬意温暖。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_190213/201902131516074152.jpg"},{"unitID":515447,"summary":"每1㎡都透着阳光的工业风LOFT","description":"美好和温暖光线，微风拂过轻纱，一进门便是轻松惬意的感觉。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221524328360.jpg"},{"unitID":1786995,"summary":"阳光下的复古工业style","description":"坐在窗边，亲近暖阳，感受阳光的跳动，目视风景和行人，小酌一杯，很是惬意。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221525379971.jpg"},{"unitID":1031572,"summary":"美式阳光房尽享部落原乡","description":"纯粹的美式西部风情让人仿佛穿越到美国。打开门，阳光穿透，如家一般的温馨。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221525353958.jpg"},{"unitID":303493,"summary":"零距离触碰中式温暖","description":"阳光竹帘，卷起一帘幽梦。满地的斜阳，风吹着帘子，地板上一条条日影便晃晃悠悠的。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221526467453.jpg"},{"unitID":5788379,"summary":"城市爱丽丝阳光后花园","description":"如爱丽丝梦游中的仙境，绿意花林中溪水潺潺，是城市里难得的阳光后花园。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221527235096.jpg"}]}]}
         */

        private ShareSettingBean shareSetting;
        private LeaderboardDetailModelBean leaderboardDetailModel;

        public ShareSettingBean getShareSetting() {
            return shareSetting;
        }

        public void setShareSetting(ShareSettingBean shareSetting) {
            this.shareSetting = shareSetting;
        }

        public LeaderboardDetailModelBean getLeaderboardDetailModel() {
            return leaderboardDetailModel;
        }

        public void setLeaderboardDetailModel(LeaderboardDetailModelBean leaderboardDetailModel) {
            this.leaderboardDetailModel = leaderboardDetailModel;
        }

        public static class ShareSettingBean {
            /**
             * shareTitle : #北京#民宿里晒太阳，过个慢生活
             * shareImageUrl : https://pic.tujia.com/upload/leaderboard/day_190325/201903251547292848.jpg
             * shareDescription : 北京超赞住宿特辑
             * shareUrl : https://m.tujia.com/pwa/promotion/leaderBoard?cityId=48&id=673
             * shareUrlForWeChatSmallApp : null
             * shareMessage : 我在途家发现了一个超赞的房屋攻略:#北京#民宿里晒太阳，过个慢生活。https://m.tujia.com/pwa/promotion/leaderBoard?cityId=48&id=673
             * enumAppShareChannel : 15
             * isReturnShareResult : false
             * isAppendShareUser : false
             */

            private String shareTitle;
            private String shareImageUrl;
            private String shareDescription;
            private String shareUrl;
            private Object shareUrlForWeChatSmallApp;
            private String shareMessage;
            private int enumAppShareChannel;
            private boolean isReturnShareResult;
            private boolean isAppendShareUser;

            public String getShareTitle() {
                return shareTitle;
            }

            public void setShareTitle(String shareTitle) {
                this.shareTitle = shareTitle;
            }

            public String getShareImageUrl() {
                return shareImageUrl;
            }

            public void setShareImageUrl(String shareImageUrl) {
                this.shareImageUrl = shareImageUrl;
            }

            public String getShareDescription() {
                return shareDescription;
            }

            public void setShareDescription(String shareDescription) {
                this.shareDescription = shareDescription;
            }

            public String getShareUrl() {
                return shareUrl;
            }

            public void setShareUrl(String shareUrl) {
                this.shareUrl = shareUrl;
            }

            public Object getShareUrlForWeChatSmallApp() {
                return shareUrlForWeChatSmallApp;
            }

            public void setShareUrlForWeChatSmallApp(Object shareUrlForWeChatSmallApp) {
                this.shareUrlForWeChatSmallApp = shareUrlForWeChatSmallApp;
            }

            public String getShareMessage() {
                return shareMessage;
            }

            public void setShareMessage(String shareMessage) {
                this.shareMessage = shareMessage;
            }

            public int getEnumAppShareChannel() {
                return enumAppShareChannel;
            }

            public void setEnumAppShareChannel(int enumAppShareChannel) {
                this.enumAppShareChannel = enumAppShareChannel;
            }

            public boolean isIsReturnShareResult() {
                return isReturnShareResult;
            }

            public void setIsReturnShareResult(boolean isReturnShareResult) {
                this.isReturnShareResult = isReturnShareResult;
            }

            public boolean isIsAppendShareUser() {
                return isAppendShareUser;
            }

            public void setIsAppendShareUser(boolean isAppendShareUser) {
                this.isAppendShareUser = isAppendShareUser;
            }
        }

        public static class LeaderboardDetailModelBean {
            /**
             * title : 民宿里晒太阳，过个慢生活
             * subTitle : 日盛阳光、夜落星辰，感受真实的自然。
             * description : 透过窗棂，张望阳光，懒散地舒展着腰肢，静静享受太阳给予的温暖，享受那份难得的温馨。
             * pictureUrl : https://pic.tujia.com/upload/leaderboard/day_190325/201903251547292848.jpg
             * leaderboardUnitCardList : [{"title":null,"subTitle":null,"leaderboardUnitCardItemList":[{"unitID":5093552,"summary":"阳光房里做个粉黛佳人","description":"粉黛大理石色系配合点点金属灯饰，你便是今天的粉黛佳人","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221527372479.jpg"},{"unitID":2832256,"summary":"明媚阳光房偷得小憩时光","description":"明媚的阳光，洒在惺忪的睫毛。睁开眼感受涌入心间的温暖，享受这精致时光。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521298955.jpg"},{"unitID":6000010,"summary":"品读设计师的王府井阳光空间","description":"阳光懒散的透过云层，从窗外射进一道道光影，抬头的时候甚至有一点炫目。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521395955.jpg"},{"unitID":1032559,"summary":"古色古香中睡进中式暖阳房","description":"\u201c栽下梧桐树,自有凤凰来\u201d阳关穿插在院落之间，风景之外，还是风景。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521547592.jpg"},{"unitID":9821295,"summary":"一缕阳光住进原木色禅意生活","description":"简约通透，斜阳映入，卸下奔波的笑靥和炊烟，别样惬意温暖。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_190213/201902131516074152.jpg"},{"unitID":515447,"summary":"每1㎡都透着阳光的工业风LOFT","description":"美好和温暖光线，微风拂过轻纱，一进门便是轻松惬意的感觉。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221524328360.jpg"},{"unitID":1786995,"summary":"阳光下的复古工业style","description":"坐在窗边，亲近暖阳，感受阳光的跳动，目视风景和行人，小酌一杯，很是惬意。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221525379971.jpg"},{"unitID":1031572,"summary":"美式阳光房尽享部落原乡","description":"纯粹的美式西部风情让人仿佛穿越到美国。打开门，阳光穿透，如家一般的温馨。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221525353958.jpg"},{"unitID":303493,"summary":"零距离触碰中式温暖","description":"阳光竹帘，卷起一帘幽梦。满地的斜阳，风吹着帘子，地板上一条条日影便晃晃悠悠的。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221526467453.jpg"},{"unitID":5788379,"summary":"城市爱丽丝阳光后花园","description":"如爱丽丝梦游中的仙境，绿意花林中溪水潺潺，是城市里难得的阳光后花园。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221527235096.jpg"}]}]
             */

            private String title;
            private String subTitle;
            private String description;
            private String pictureUrl;
            private List<LeaderboardUnitCardListBean> leaderboardUnitCardList;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPictureUrl() {
                return pictureUrl;
            }

            public void setPictureUrl(String pictureUrl) {
                this.pictureUrl = pictureUrl;
            }

            public List<LeaderboardUnitCardListBean> getLeaderboardUnitCardList() {
                return leaderboardUnitCardList;
            }

            public void setLeaderboardUnitCardList(List<LeaderboardUnitCardListBean> leaderboardUnitCardList) {
                this.leaderboardUnitCardList = leaderboardUnitCardList;
            }

            public static class LeaderboardUnitCardListBean {
                /**
                 * title : null
                 * subTitle : null
                 * leaderboardUnitCardItemList : [{"unitID":5093552,"summary":"阳光房里做个粉黛佳人","description":"粉黛大理石色系配合点点金属灯饰，你便是今天的粉黛佳人","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221527372479.jpg"},{"unitID":2832256,"summary":"明媚阳光房偷得小憩时光","description":"明媚的阳光，洒在惺忪的睫毛。睁开眼感受涌入心间的温暖，享受这精致时光。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521298955.jpg"},{"unitID":6000010,"summary":"品读设计师的王府井阳光空间","description":"阳光懒散的透过云层，从窗外射进一道道光影，抬头的时候甚至有一点炫目。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521395955.jpg"},{"unitID":1032559,"summary":"古色古香中睡进中式暖阳房","description":"\u201c栽下梧桐树,自有凤凰来\u201d阳关穿插在院落之间，风景之外，还是风景。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221521547592.jpg"},{"unitID":9821295,"summary":"一缕阳光住进原木色禅意生活","description":"简约通透，斜阳映入，卸下奔波的笑靥和炊烟，别样惬意温暖。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_190213/201902131516074152.jpg"},{"unitID":515447,"summary":"每1㎡都透着阳光的工业风LOFT","description":"美好和温暖光线，微风拂过轻纱，一进门便是轻松惬意的感觉。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221524328360.jpg"},{"unitID":1786995,"summary":"阳光下的复古工业style","description":"坐在窗边，亲近暖阳，感受阳光的跳动，目视风景和行人，小酌一杯，很是惬意。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221525379971.jpg"},{"unitID":1031572,"summary":"美式阳光房尽享部落原乡","description":"纯粹的美式西部风情让人仿佛穿越到美国。打开门，阳光穿透，如家一般的温馨。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221525353958.jpg"},{"unitID":303493,"summary":"零距离触碰中式温暖","description":"阳光竹帘，卷起一帘幽梦。满地的斜阳，风吹着帘子，地板上一条条日影便晃晃悠悠的。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221526467453.jpg"},{"unitID":5788379,"summary":"城市爱丽丝阳光后花园","description":"如爱丽丝梦游中的仙境，绿意花林中溪水潺潺，是城市里难得的阳光后花园。","pictureUrl":"https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221527235096.jpg"}]
                 */

                private Object title;
                private Object subTitle;
                public List<LeaderboardUnitCardItemListBean> leaderboardUnitCardItemList;

                public Object getTitle() {
                    return title;
                }

                public void setTitle(Object title) {
                    this.title = title;
                }

                public Object getSubTitle() {
                    return subTitle;
                }

                public void setSubTitle(Object subTitle) {
                    this.subTitle = subTitle;
                }

                public List<LeaderboardUnitCardItemListBean> getLeaderboardUnitCardItemList() {
                    return leaderboardUnitCardItemList;
                }

                public void setLeaderboardUnitCardItemList(List<LeaderboardUnitCardItemListBean> leaderboardUnitCardItemList) {
                    this.leaderboardUnitCardItemList = leaderboardUnitCardItemList;
                }

                public static class LeaderboardUnitCardItemListBean {
                    /**
                     * unitID : 5093552
                     * summary : 阳光房里做个粉黛佳人
                     * description : 粉黛大理石色系配合点点金属灯饰，你便是今天的粉黛佳人
                     * pictureUrl : https://pic.tujia.com/upload/leaderboardunit/day_181122/201811221527372479.jpg
                     */

                    private int unitID;
                    private String summary;
                    private String description;
                    private String pictureUrl;

                    public int getUnitID() {
                        return unitID;
                    }

                    public void setUnitID(int unitID) {
                        this.unitID = unitID;
                    }

                    public String getSummary() {
                        return summary;
                    }

                    public void setSummary(String summary) {
                        this.summary = summary;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public String getPictureUrl() {
                        return pictureUrl;
                    }

                    public void setPictureUrl(String pictureUrl) {
                        this.pictureUrl = pictureUrl;
                    }
                }
            }
        }
    }
}
