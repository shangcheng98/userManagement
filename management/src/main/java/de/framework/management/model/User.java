package de.framework.management.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // ???
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String email;
    private String imgUrl;

    @Column(nullable = false, updatable = false)
    private String userCode;

    public User(){

    }

    public User(String name,String email,String imgUrl,String userCode){
        this.name = name;
        this.email = email;
        this.imgUrl = imgUrl;
        this.userCode = userCode;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email = email;
    }

    public String getImgUrl(){
        return imgUrl;
    }

    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }

    public String getUserCode(){
        return userCode;
    }
    public void setUserCode(String userCode){
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "User{ " +
                "id" + id +
                " , name " + name +
                " , email "+ email +
                " , imgUrl" + imgUrl +
                " , userCode " + userCode +
                "}";
    }
}
