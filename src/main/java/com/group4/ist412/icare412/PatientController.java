/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import com.google.gson.Gson;
import org.dizitart.no2.Document;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import static org.dizitart.no2.filters.Filters.eq;
import org.dizitart.no2.mapper.JacksonFacade;
import org.dizitart.no2.mapper.MapperFacade;

/**
 *
 * @author leon
 */
public class PatientController {
    Gson gson;
    Nitrite db;
    
    /**
     *
     */
    public PatientController() {
        gson = new Gson();
    }

    /**
     *
     * @param email The user's email
     * @return JSON string containing user vitals
     */
    public String getUserVitals(String email) {
        try (NitriteCollection collection = db.getCollection("vitals")) {
            Document doc = collection.find(eq("email", email)).firstOrDefault();
            String vitals = gson.toJson(doc);
            return vitals;
        }
        catch (Exception e) {
            Logger.log(e.toString());
            return "";
        }
    }
    
    /**
     *
     * @param vitals JSON string containing new vitals
     * @return Boolean
     */
    public Boolean setUserVitals(String vitals) {
        try (NitriteCollection collection = db.getCollection("vitals")) {
            MapperFacade fac = new JacksonFacade();
            Document doc = fac.parse(vitals);
            Document existingDoc = collection.find(eq("email", doc.get("email", String.class))).firstOrDefault();
            if (existingDoc != null) {
                collection.update(eq("email", doc.get("email", String.class)), doc);
            }
            else {
                collection.insert(doc);
            }
            this.db.commit();
            return true;
        }
        catch (Exception e) {
            Logger.log(e.toString());
            System.out.println(e);
            return false;
        }
    }
    
    /**
     *
     * @param db
     */
    public void setDb(Nitrite db) {
        this.db = db;
    }
}
