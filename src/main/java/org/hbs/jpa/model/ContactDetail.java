package org.hbs.jpa.model;

import javax.persistence.*;

/**
 * Created by Hardik on 24-03-2017.
 */

@Entity
public class ContactDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String mobile;
    private String email;
    private String landLine;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }
}
