package com.example.my_shop.bean;

import java.util.List;

public class HouseListJson {
    /**
     * content : {"title":"北京特色房屋推荐榜","leaderboardByDescList":[{"description":"民宿里晒太阳，过个慢生活","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230056179883.jpg","leaderboardDetailID":673},{"description":"睡故宫边，梦回千秋岁月","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230051449204.jpg","leaderboardDetailID":675},{"description":"超高性价比民宿，值回这场旅行","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230056378923.jpg","leaderboardDetailID":831},{"description":"四合院的中国之美，都藏在这","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230055511968.jpg","leaderboardDetailID":674},{"description":"临近故宫，TOP20必住好房","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_181122/201811221815061143.jpg","leaderboardDetailID":675},{"description":"解密设计师编织的乌托邦之城","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230052014628.jpg","leaderboardDetailID":638},{"description":"TOP20小清新口碑好房","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_181122/201811221816387071.jpg","leaderboardDetailID":677},{"description":"2018上半年度『人气美屋』大赏","pictureUrl":"https://pic.tujia.com/upload/LeaderBoardDestination/day_180820/201808201646144897.jpg","leaderboardDetailID":607},{"description":"泡山水温泉，承包你的周末","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230051517083.jpg","leaderboardDetailID":426},{"description":"『豪宅』来这儿，享受终极住宿体验","pictureUrl":"https://pic.tujia.com/upload/LeaderBoardDestination/day_171205/201712051629227800.jpg","leaderboardDetailID":438},{"description":"『天安门王府井』畅销好房TOP榜","pictureUrl":"https://pic.tujia.com/upload/LeaderBoardDestination/day_171205/201712051629502162.jpg","leaderboardDetailID":574},{"description":"『漂亮的民宿』年度美屋清单","pictureUrl":"https://pic.tujia.com/upload/LeaderBoardDestination/day_180212/201802121651335901.jpg","leaderboardDetailID":593}]}
     * errorCode : 0
     * errorMessage : null
     */

    private ContentBean content;
    private int errorCode;
    private Object errorMessage;

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
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
         * title : 北京特色房屋推荐榜
         * leaderboardByDescList : [{"description":"民宿里晒太阳，过个慢生活","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230056179883.jpg","leaderboardDetailID":673},{"description":"睡故宫边，梦回千秋岁月","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230051449204.jpg","leaderboardDetailID":675},{"description":"超高性价比民宿，值回这场旅行","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230056378923.jpg","leaderboardDetailID":831},{"description":"四合院的中国之美，都藏在这","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230055511968.jpg","leaderboardDetailID":674},{"description":"临近故宫，TOP20必住好房","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_181122/201811221815061143.jpg","leaderboardDetailID":675},{"description":"解密设计师编织的乌托邦之城","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230052014628.jpg","leaderboardDetailID":638},{"description":"TOP20小清新口碑好房","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_181122/201811221816387071.jpg","leaderboardDetailID":677},{"description":"2018上半年度『人气美屋』大赏","pictureUrl":"https://pic.tujia.com/upload/LeaderBoardDestination/day_180820/201808201646144897.jpg","leaderboardDetailID":607},{"description":"泡山水温泉，承包你的周末","pictureUrl":"https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230051517083.jpg","leaderboardDetailID":426},{"description":"『豪宅』来这儿，享受终极住宿体验","pictureUrl":"https://pic.tujia.com/upload/LeaderBoardDestination/day_171205/201712051629227800.jpg","leaderboardDetailID":438},{"description":"『天安门王府井』畅销好房TOP榜","pictureUrl":"https://pic.tujia.com/upload/LeaderBoardDestination/day_171205/201712051629502162.jpg","leaderboardDetailID":574},{"description":"『漂亮的民宿』年度美屋清单","pictureUrl":"https://pic.tujia.com/upload/LeaderBoardDestination/day_180212/201802121651335901.jpg","leaderboardDetailID":593}]
         */

        private String title;
        private List<LeaderboardByDescListBean> leaderboardByDescList;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<LeaderboardByDescListBean> getLeaderboardByDescList() {
            return leaderboardByDescList;
        }

        public void setLeaderboardByDescList(List<LeaderboardByDescListBean> leaderboardByDescList) {
            this.leaderboardByDescList = leaderboardByDescList;
        }

        public static class LeaderboardByDescListBean {
            /**
             * description : 民宿里晒太阳，过个慢生活
             * pictureUrl : https://pic.tujia.com/upload/leaderboarddestination/day_190323/201903230056179883.jpg
             * leaderboardDetailID : 673
             */

            private String description;
            private String pictureUrl;
            private int leaderboardDetailID;

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

            public int getLeaderboardDetailID() {
                return leaderboardDetailID;
            }

            public void setLeaderboardDetailID(int leaderboardDetailID) {
                this.leaderboardDetailID = leaderboardDetailID;
            }
        }
    }
}
