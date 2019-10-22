package com.example.my_shop.bean;

public class GoodsShow {
    /**
     * cpOne : {"id":9,"title":"玩Bigger","imgUrl":"https://img.cniao5.com/560be90cN0a2bf923.jpg"}
     * cpTwo : {"id":10,"title":"1元抢","imgUrl":"https://img.cniao5.com/560be7d5N03f4731e.jpg"}
     * cpThree : {"id":16,"title":"打白条","imgUrl":"https://img.cniao5.com/560a016aNd3d86d3b.jpg"}
     * id : 6
     * title : 金融街
     * campaignOne : 9
     * campaignTwo : 10
     * campaignThree : 16
     */

    private CpOneBean cpOne;
    private CpTwoBean cpTwo;
    private CpThreeBean cpThree;
    private int id;
    private String title;
    private int campaignOne;
    private int campaignTwo;
    private int campaignThree;

    public CpOneBean getCpOne() {
        return cpOne;
    }

    public void setCpOne(CpOneBean cpOne) {
        this.cpOne = cpOne;
    }

    public CpTwoBean getCpTwo() {
        return cpTwo;
    }

    public void setCpTwo(CpTwoBean cpTwo) {
        this.cpTwo = cpTwo;
    }

    public CpThreeBean getCpThree() {
        return cpThree;
    }

    public void setCpThree(CpThreeBean cpThree) {
        this.cpThree = cpThree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCampaignOne() {
        return campaignOne;
    }

    public void setCampaignOne(int campaignOne) {
        this.campaignOne = campaignOne;
    }

    public int getCampaignTwo() {
        return campaignTwo;
    }

    public void setCampaignTwo(int campaignTwo) {
        this.campaignTwo = campaignTwo;
    }

    public int getCampaignThree() {
        return campaignThree;
    }

    public void setCampaignThree(int campaignThree) {
        this.campaignThree = campaignThree;
    }

    public static class CpOneBean {
        /**
         * id : 9
         * title : 玩Bigger
         * imgUrl : https://img.cniao5.com/560be90cN0a2bf923.jpg
         */

        private int id;
        private String title;
        private String imgUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }

    public static class CpTwoBean {
        /**
         * id : 10
         * title : 1元抢
         * imgUrl : https://img.cniao5.com/560be7d5N03f4731e.jpg
         */

        private int id;
        private String title;
        private String imgUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }

    public static class CpThreeBean {
        /**
         * id : 16
         * title : 打白条
         * imgUrl : https://img.cniao5.com/560a016aNd3d86d3b.jpg
         */

        private int id;
        private String title;
        private String imgUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
