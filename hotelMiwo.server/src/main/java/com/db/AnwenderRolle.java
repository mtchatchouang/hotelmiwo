package com.db;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by mtc on 29.05.16.
 */
@Entity
@Table(name = "ANWENDER_ROLLE")
public class AnwenderRolle implements Serializable {

    private static final long serialVersionUID = -2593883443814347105L;

    @Id
    @GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
    @Column(name = "id", unique = true, nullable = false, precision = 15, scale = 0)
    private int id;

    @Column(name = "benutzername")
    private String benutzername;

    @Column(name = "rolle_id")
    private int rolle_id;

    public AnwenderRolle() {
    }

    public AnwenderRolle(String benutzername, int rolle_id) {
        this.benutzername = benutzername;
        this.rolle_id = rolle_id;
    }

    public int getId() {
        return id;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public int getRolle_id() {
        return rolle_id;
    }

    public void setRolle_id(int rolle_id) {
        this.rolle_id = rolle_id;
    }
}
