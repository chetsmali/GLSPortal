package com.gls.portal.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable {
     
    @Id
    @GeneratedValue
    private Integer id;
     
    private String role;
   /*  
    @ManyToMany(fetch=FetchType.EAGER,mappedBy="roles")
    private List<User> user;*/
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
    }
 
   /* public List<User> getUserRoles() {
        return user;
    }
 
    public void setUserRoles(List<User> user) {
        this.user = user;
    }*/
     
}
