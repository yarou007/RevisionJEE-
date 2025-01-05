/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import model.Etudiants;

/**
 *
 * @author 21655
 */
public class JPAService {

    EntityManagerFactory emf;
    EntityManager em;

    /*public JPAService() {
        this.emf = Persistence.createEntityManagerFactory("RevisionInesPU");
        this.em = emf.createEntityManager();
    }*/

    
    
    public boolean Connexion(String persistence_unit) {
        try {
            this.emf = Persistence.createEntityManagerFactory(persistence_unit); // 7alina porte avec bd 
            this.em = this.emf.createEntityManager(); // prepartion l'outil d'operation avec bd 
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void deconnexion() {
       try{
           if(emf.isOpen()){
               emf.close();
           }
           if(em.isOpen()){
               em.close();
           }
       }catch(Exception ex){
           System.err.println("Probleme de quoi ");
       }
    }

    public boolean isExsitant(Integer id) {
     
        try{
            Etudiants e = em.find(Etudiants.class, id);
            if (e!=null) return true;
            else return false;
        }catch(Exception ex){
            return false;
        }
    }
    
    public Etudiants getEtudiant (Integer id){
        try{
            Etudiants e = em.find(Etudiants.class,id );
            return e;
            
        }catch(Exception ex){
            return null;
        }
    
    }

    public String AjouterEtudiant(Integer id, String nom, String prenom) {
        try{
            Etudiants e = new Etudiants(id,nom,prenom);
            if (!isExsitant(id)){
                em.getTransaction().begin(); // bdina transaction
                em.persist(e); // en process l'insertion
                em.getTransaction().commit(); // sakarna el trasaction
                return "Ajout avec succés";
            }else {
                return "Etudiant deja existant";
            }
        }catch(Exception ex){
            return "« Echec d’ajout, une erreur est survenue";
        }
    }

    public List<Etudiants> listerEtudiants() {
        List<Etudiants> students = new Vector<Etudiants>();

        try{
            String req = "SELECT e FROM Etudiants e";
            Query q = em.createQuery(req);
            List etuds = q.getResultList();
            Iterator i = etuds.iterator();
            Etudiants e = null;
            while(i.hasNext()){
                e = (Etudiants) i.next();
                students.add(e);
            }
            return students;         
            
        }catch(Exception ex){
            return null;
        }
    }

   

    public String SupprimerEtudiant(Integer id) {
        try{
            if(isExsitant(id)){
                Etudiants e = getEtudiant(id);
                em.getTransaction().begin();
                em.remove(e);
                em.flush();
                em.getTransaction().commit();
                return "Suppression avec succés";
            }else {
               return "N'existe pas";

            }
            
        }catch(Exception ex){
            return "Proble exception";
        }
    }

    public String modifierEtudiant(Integer id, String nom, String prenom) {
       try{
           if (isExsitant(id)){
               Etudiants e = getEtudiant(id);
               e.setNom(nom);
               e.setPrenom(prenom);
               em.getTransaction().begin();
               em.merge(e);
               em.flush();
               em.getTransaction().commit();
               return "Modif avec suucés";
           }else {
              return "inexistant";
           }
           
       }catch(Exception ex){
           return "Probleme d'exception";
       }
    }

}
