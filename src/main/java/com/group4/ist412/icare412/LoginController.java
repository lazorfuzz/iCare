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
import org.dizitart.no2.Cursor;
import static org.dizitart.no2.filters.Filters.eq;
import org.dizitart.no2.mapper.JacksonFacade;
import org.dizitart.no2.mapper.MapperFacade;

/**
 *
 * @author leon
 */
public class LoginController {
    Gson gson;
    Nitrite db;
    Cursor cursor;
    
    public LoginController() {
        gson = new Gson();
    }
    
    public Boolean authenticate(String email, String password) {
        try (NitriteCollection collection = db.getCollection("users")) {
            Document d = collection.find(eq("email", email)).firstOrDefault();
            return d.get("password").equals(password);
        }
        catch (Exception e) {
            Logger.log(e.toString());
            return false;
        }
    }
    
    public Boolean createUser(String user) {
        try (NitriteCollection collection = db.getCollection("users")) {
            MapperFacade fac = new JacksonFacade();
            Document doc = fac.parse(user);
            String email = doc.get("email", String.class);
            Document existing = collection.find(eq("email", email)).firstOrDefault();
            if (existing != null) {
                return false;
            }
            collection.insert(doc);
            db.commit();
            return true;
        }
        catch (Exception e) {
            Logger.log(e.toString());
            return false;
        }
    }

    public Boolean deleteUser(String email) {
        try (NitriteCollection collection = db.getCollection("users")) {
            Document doc = collection.find(eq("email", email)).firstOrDefault();
            collection.remove(doc);
            db.commit();
            return true;
        }
        catch (Exception e) {
            Logger.log(e.toString());
            return false;
        }
    }

    public Boolean updateUser(String user) {
        try (NitriteCollection collection = db.getCollection("users")) {
            Document newUserDoc = gson.fromJson(user, Document.class);
            Document doc = collection.find(eq("email", newUserDoc.get("email", String.class))).firstOrDefault();
            if (doc != null) {
                collection.update(eq("email", newUserDoc.get("email", String.class)), newUserDoc);
                db.commit();
                return true;
            }
            return false;
        }
        catch (Exception e) {
            Logger.log(e.toString());
            return false;
        }
    }
    
    public String getUserByEmail(String email) {
        try (NitriteCollection collection = db.getCollection("users")) {
            Document d = collection.find(eq("email", email)).firstOrDefault();
            return gson.toJson(d);
        }
    }
    
    public String getUsers() {
        try (NitriteCollection collection = db.getCollection("users")) {
            List<Document> list = collection.find().toList();
            return gson.toJson(list);
        }
    }
    
    public void setDb(Nitrite db) {
        this.db = db;
    }
}
