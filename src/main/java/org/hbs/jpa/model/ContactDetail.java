package org.hbs.jpa.model;

import javax.persistence.*;

/**
 * Created by Hardik on 24-03-2017.
 */

@Entity
@Table(name = "contact_detail")
public class ContactDetail {

    @Id
    @Column(name="contact_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @Override
    public String toString() {
        return "ContactDetail{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", landLine='" + landLine + '\'' +
                '}';
    }
}
