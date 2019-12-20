package com.wwh.whblog.module.sys.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {

    /** 已锁定 */
    public static final String IS_LOCK = "1";
    /** 未锁定 */
    public static final String IS_NOT_LOCK = "0";
    /** 已删除 */
    public static final String IS_DELETED = "1";
    /** 未删除 */
    public static final String IS_NOT_DELETED = "0";

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;
    /** 用户名 - 登录名 */
    @Column(name = "username")
    private String userName;
    /** 密码 */
    @Column(name = "password")
    private String password;
    /** 手机号 */
    @Column(name = "phone")
    private String phone;
    /** 性别  0：女 /1：男 */
    @Column(name = "sex")
    private Integer sex;
    /** 锁定  0：未锁定 /1：已锁定 */
    @Column(name = "is_lock")
    private Integer isLock;
    /** 创建时间 */
    @Column(name = "create_date")
    private Date createDate;
    /** 修改时间 */
    @Column(name = "update_date")
    private Date updateDate;
    /** 修改用户 */
    @Column(name = "update_user")
    private String updateUser;
    /** 删除状态  0：未删除 /1：已删除 */
    @Column(name = "is_deleted")
    private Integer isDeleted;
    /** 邮箱 */
    @Column(name = "email")
    private String Email;
    /** 用户名称 */
    //@Column(name = "real_name")
    //private String realName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    /*public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }*/
}
