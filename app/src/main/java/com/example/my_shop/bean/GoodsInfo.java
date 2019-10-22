package com.example.my_shop.bean;

/**
 * 一个商品的所有信息
 */
public class GoodsInfo {
    /**
     * id : 1
     * categoryId : 5
     * campaignId : 1
     * name : 联想（Lenovo）拯救者14.0英寸游戏本（i7-4720HQ 4G 1T硬盘 GTX960M 2G独显 FHD IPS屏 背光键盘）黑
     * imgUrl : https://img.cniao5.com/s_recommend_55c1e8f7N4b99de71.jpg
     * price : 5979.0
     * sale : 8654
     */

    private int id;
    private int categoryId;
    private int campaignId;
    private String name;
    private String imgUrl;
    private double price;
    private int sale;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public ShoppingCart toShoppingCart() {
        ShoppingCart sc = new ShoppingCart();

        sc.setId(id);
        sc.setName(name);
        sc.setPrice(price);
        sc.setImgUrl(imgUrl);
        sc.setCampaignId(campaignId);
        sc.setCategoryId(categoryId);
        sc.setSale(sale);

        sc.setChecked(true);
        sc.setCount(1);

        return sc;
    }
}
