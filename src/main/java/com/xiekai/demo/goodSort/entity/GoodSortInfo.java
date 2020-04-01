package com.xiekai.demo.goodSort.entity;

/**
 * 用户实体类
 *
 * @author xiekai
 * @time 2020-3-25
 */

public class GoodSortInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 分类编码
     */
    private int sortingId;
    /**
     * 分类姓名
     */
    private String sortingName;
    /**
     * 备注
     */
    private String comment;
    /**
     * 父级编码
     */
    private String cateCodeParent;
    /**
     * 星级
     */
    private int levels;
    /**
     * 是否父类 0是 1否
     */
    private int isParent;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDelete;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 更新者
     */
    private String updateUser;

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


    public String getSortingName() {
        return sortingName;
    }

    public void setSortingName(String sortingName) {
        this.sortingName = sortingName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCateCodeParent() {
        return cateCodeParent;
    }

    public void setCateCodeParent(String cateCodeParent) {
        this.cateCodeParent = cateCodeParent;
    }

    public int getSortingId() {
        return sortingId;
    }

    public void setSortingId(int sortingId) {
        this.sortingId = sortingId;
    }

    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }

    public int getIsParent() {
        return isParent;
    }

    public void setIsParent(int isParent) {
        this.isParent = isParent;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 版本号
     */
    private String version;
}
