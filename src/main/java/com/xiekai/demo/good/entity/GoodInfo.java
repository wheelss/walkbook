package com.xiekai.demo.good.entity;

/**
 * 商品实体类
 */
public class GoodInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品id
     */
    private String goodId;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    /**
     * 商品名称
     */
    private String goodName;
    /**
     * 一级分类
     */
    private String firstClassification;
    /**
     * 二级分类
     */
    private String secondClassification;
    /**
     * 广告词
     */
    private String ad;
    /**
     * 商品介绍
     */
    private String goodIntroduction;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 库存
     */
    private int inventory;
    /**
     * 成本价
     */
    private int costPrice;
    /**
     * 售价
     */
    private int sellPrice;
    /**
     * 销售量
     */
    private int sales;
    /**
     * 商品状态(0未发布,1上架,2下架)
     */
    private int goodStatus;
    /**
     * 上架时间
     */
    private String shelfTime;
    /**
     * 图片
     */
    private String picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 浏览量
     */
    private int views;
    /**
     * 商家编码
     */
    private String merchantCode;
    /**
     * isbn书号
     */
    private String isbnCode;
    /**
     * 星级
     */
    private double starLevel;
    /**
     * 作者
     */
    private String writer;
    /**
     * 出版社
     */
    private String press;
    /**
     * 删除标记(0否,1是)
     */
    private int isDelete;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新人
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 版本
     */
    private int version;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getFirstClassification() {
        return firstClassification;
    }

    public void setFirstClassification(String firstClassification) {
        this.firstClassification = firstClassification;
    }

    public String getSecondClassification() {
        return secondClassification;
    }

    public void setSecondClassification(String secondClassification) {
        this.secondClassification = secondClassification;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getGoodIntroduction() {
        return goodIntroduction;
    }

    public void setGoodIntroduction(String goodIntroduction) {
        this.goodIntroduction = goodIntroduction;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(int goodStatus) {
        this.goodStatus = goodStatus;
    }

    public String getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(String shelfTime) {
        this.shelfTime = shelfTime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public double getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(double starLevel) {
        this.starLevel = starLevel;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
