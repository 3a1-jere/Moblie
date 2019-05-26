/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.util.Vector;


public class Membre 
{   

    public Membre() {
       
    }

    public Membre(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Membre(Membre a) {
        this.id = a.getId();
        this.username = a.getUsername();
        this.email = a.getEmail();
        this.password = a.getPassword();
    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Membre(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Membre{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + '}';
    }

 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    /**
     * @var integer
     *
     * @ORM\Column(type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    

    
    private int id ;
    
    private String username ;
  
    
    private String email;


    /**
     * Encrypted password. Must be persisted.
     *
     * @var string
     */
    private String password;


}

   