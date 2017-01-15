package com.db;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * Created by mtc on 28.05.16.
 */
@Entity
@Table(name = "ANWENDER")
public class Anwender implements Serializable {
    private static final long serialVersionUID = 2429131126358541395L;

    @Id
    @GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
    @Column(name = "id", unique = true, nullable = false, precision = 15, scale = 0)
    private int id;

    @Column(name = "benutzername")
    private String benutzername;

    @Column(name = "passwort")
    private String passwort;

    @Column(name = "email")
    private String email;

    @Column(name = "vorname")
    private String vorname;

    @Column(name = "nachname")
    private String nachname;

    @Column(name = "job_beschreibung")
    private String job_beschreibung;

    public Anwender(){};

    public Anwender(String benutzername, String passwort, String email, String vorname, String nachname, String job_beschreibung){
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.email = email;
        this.vorname = vorname;
        this.nachname = nachname;
        this.job_beschreibung = job_beschreibung;
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

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getJob_beschreibung() {
        return job_beschreibung;
    }

    public void setJob_beschreibung(String job_beschreibung) {
        this.job_beschreibung = job_beschreibung;
    }
}
