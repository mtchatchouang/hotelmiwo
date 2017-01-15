package com.db;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by mtc on 29.05.16.
 */
@Entity
@Table(name = "ROLLE")
public class Rolle implements Serializable {
    private static final long serialVersionUID = 6207830972783008845L;

    @Id
    @GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
    @Column(name = "id", unique = true, nullable = false, precision = 15, scale = 0)
    private int id;

    @Column(name = "rolle")
    private String rolle;

    public Rolle(){};

    public Rolle(String rolle) {
        this.rolle = rolle;
    }

    public int getId() {
        return id;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }
}
