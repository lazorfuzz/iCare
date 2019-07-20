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
    
    public PatientController() {
        gson = new Gson();
    }

    public String getUserVitals(String email) {
        try (NitriteCollection collection = db.getCollection("vitals")) {
            Document d = collection.find(eq("email", email)).firstOrDefault();
            String v = gson.toJson(d);
            //Vitals vitals = gson.fromJson(v, Vitals.class);
            return v;
        }
        catch (Exception e) {
            Logger.log(e.toString());
            return "";
        }
    }
    
    public Boolean setUserVitals(String vitals) {
        try (NitriteCollection collection = db.getCollection("vitals")) {
            Vitals v = gson.fromJson(vitals, Vitals.class);
            System.out.println("BMI: "+v.calculateBMI(5.9, 150));
            String jsonv = gson.toJson(v);
            System.out.println("Set User Vitals:\n "+jsonv);
            Document d = collection.find(eq("email", v.getEmail())).firstOrDefault();
            
            if (d != null) {
                collection.remove(d);
            }
            MapperFacade fac = new JacksonFacade();
            Document doc = fac.parse(vitals);
            collection.insert(doc);
            this.db.commit();
            return true;
        }
        catch (Exception e) {
            Logger.log(e.toString());
            return false;
        }
    }
    
    public void setDb(Nitrite db) {
        this.db = db;
    }
}
