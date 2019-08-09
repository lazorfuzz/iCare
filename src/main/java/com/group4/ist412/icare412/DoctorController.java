/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import com.google.gson.Gson;
import java.util.List;
import org.dizitart.no2.Document;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import static org.dizitart.no2.filters.Filters.and;
import static org.dizitart.no2.filters.Filters.eq;
import org.dizitart.no2.mapper.JacksonFacade;
import org.dizitart.no2.mapper.MapperFacade;

/**
 *
 * @author leon
 */
public class DoctorController {
    Gson gson;
    Nitrite db;
    
    /**
     *
     */
    public DoctorController() {
        gson = new Gson();
    }
    
    public String getAssignedPatients(String doctorId) {
        try (NitriteCollection collection = db.getCollection("patientMaps")) {
            List<Document> list = collection.find(eq("doctorId", doctorId)).toList();
            return gson.toJson(list);
        }
        catch (Exception e) {
            Logger.log(e.toString());
            System.out.println(e);
            return "[]";
        }
    }
    
    public Boolean setDoctorPatientMapping(String patientMap, Boolean add) {
        try (NitriteCollection collection = db.getCollection("patientMaps")) {
            MapperFacade fac = new JacksonFacade();
            Document doc = fac.parse(patientMap);
            Document existingDoc = collection.find(and(eq("doctorId", doc.get("doctorId")), eq("patientId", doc.get("patientId")))).firstOrDefault();
            if (existingDoc != null && add == false) {
                collection.remove(existingDoc);
                return true;
            }
            else if (existingDoc == null) {
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
