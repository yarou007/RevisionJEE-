/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 21655
 */
@Entity
@Table(catalog = "jdbc", schema = "")
@NamedQueries({
    @NamedQuery(name = "Etudiants.findAll", query = "SELECT e FROM Etudiants e"),
    @NamedQuery(name = "Etudiants.findById", query = "SELECT e FROM Etudiants e WHERE e.id = :id"),
    @NamedQuery(name = "Etudiants.findByNom", query = "SELECT e FROM Etudiants e WHERE e.nom = :nom"),
    @NamedQuery(name = "Etudiants.findByPrenom", query = "SELECT e FROM Etudiants e WHERE e.prenom = :prenom")})
public class Etudiants implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 45)
    private String nom;
    @Column(length = 45)
    private String prenom;

    public Etudiants() {
    }

    public Etudiants(Integer id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;

        this.prenom = prenom;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiants)) {
            return false;
        }
        Etudiants other = (Etudiants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Etudiants[ id=" + id + " ]";
    }

}
