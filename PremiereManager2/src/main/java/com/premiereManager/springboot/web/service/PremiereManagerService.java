package com.premiereManager.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.premiereManager.springboot.web.model.Premiere;

/**
 * Handles requests from the user. Fills the list of premieres with default entries.
 * Enables the user to add, update or delete a premiere from their list.
 * 
 * @author Rafal Jagodzinski
 *
 */

@Service
public class PremiereManagerService {
    private static List<Premiere> premieres = new ArrayList<Premiere>(); 
    private static int premiereCount = 3;

    /**
     * Fills the list of premieres with default entries.
     * 
     * @author Rafal Jagodzinski
     * 
     */
    
    static {
        premieres.add(new Premiere(1, "Lukasz", "Biomutant", new Date(), "Game"));
        premieres.add(new Premiere(2, "Lukasz", "Land of War: The beginning", new Date(), "Game"));
        premieres.add(new Premiere(3, "Lukasz", "Sniper: Ghost Warrior Contracts", new Date(), "Game"));
    }
    
    /**
     * Retrieves a list of premieres. Entries are checked with regards to the user.
     * If the name of the user is equal to the name provided to the method, it retrieves the list.
     * 
     * @author Rafal Jagodzinski
     * 
     */

    public List<Premiere> retrievePremieres(String user) {
        List<Premiere> filteredPremieres = new ArrayList<Premiere>();
        for (Premiere premiere : premieres) {
            if (premiere.getUser().equalsIgnoreCase(user)) {
                filteredPremieres.add(premiere);
            }
        }
        return filteredPremieres;
    }
    
    /**
     * Retrieves a single entry from the premiere list.
     * An entry is checked with regards to its id number.
     * 
     * @param id
     * @return
     */
    
    public Premiere retrievePremiere(int id) {
        for (Premiere premiere : premieres) {
            if (premiere.getId()==id) {
                return premiere;
            }
        }
        return null;
    }
    
    /**
     * Updates an entry, by deleting the old one and replacing it with a new one.
     * 
     * @author Rafal Jagodzinski
     * 
     */

    public void updatePremiere(Premiere premiere){
    		premieres.remove(premiere);
    		premieres.add(premiere);
    }
    
    /**
     * Adds a premiere and iterates variable ++premiereCount in order to create a unique id number.
     * 
     * @author Rafal Jagodzinski
     * 
     */

    public void addPremiere(String name, String desc, Date targetDate, String type) {
        premieres.add(new Premiere(++premiereCount, name, desc, targetDate, type));
    }
    
    /**
     * Deletes a premiere with regards to its id number.
     * 
     * @author Rafal Jagodzinski
     */

    public void deletePremiere(int id) {
        Iterator<Premiere> iterator = premieres.iterator(); 
        while (iterator.hasNext()) {
            Premiere premiere = iterator.next();
            if (premiere.getId() == id) {
                iterator.remove();
            }
        }
    }
}