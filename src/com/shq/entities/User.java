package com.shq.entities;
// Generated 10-feb-2018 4:42:33 by Hibernate Tools 5.2.3.Final


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="USER"
    ,catalog="shq"
)
public class User  implements java.io.Serializable {


     private BigDecimal userId;
     private String userName;
     private String userPass;

    public User() {
    }

    public User(BigDecimal userId, String userName, String userPass) {
       this.userId = userId;
       this.userName = userName;
       this.userPass = userPass;
    }
   
     @Id 

    
    @Column(name="user_id", unique=true, nullable=false, precision=50, scale=0)
    public BigDecimal getUserId() {
        return this.userId;
    }
    
    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    
    @Column(name="user_name", nullable=false, length=75)
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    @Column(name="user_pass", nullable=false, length=75)
    public String getUserPass() {
        return this.userPass;
    }
    
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }




}


