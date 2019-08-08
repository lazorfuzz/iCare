/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group4.ist412.icare412;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import com.group4.ist412.icare412.HTTPServer.*;
import org.dizitart.no2.Document;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;
import org.dizitart.no2.mapper.JacksonFacade;
import org.dizitart.no2.mapper.MapperFacade;
import com.google.gson.Gson;
import static org.dizitart.no2.IndexOptions.indexOptions;
import org.dizitart.no2.IndexType;

/**
 *
 * @author leon
 */
public class MainApp extends Application {
    
    private Scene scene;
    HTTPServer server;
    Nitrite db;
    
    @Override
    public void start(Stage stage) throws IOException {
        initDB();
        System.out.println("Starting");
        server = new HTTPServer(49555);
        VirtualHost host = new VirtualHost(null);
        host.addContext("/", new FileContextHandler(new File("ui/build")));
        server.addVirtualHost(host);
        System.out.println("Starting server");
        server.start();
        System.out.println("Creating scene");
        stage.setTitle("iCare");
        scene = new Scene(new Browser(this.db), 960, 600, Color.web("#666970"));
        stage.setScene(scene);  
        System.out.println("Showing stage");
        stage.show();
    }
    
    public void initDB() {
        db = Nitrite.builder()
        .compressed()
        .filePath("icare.db")
        .openOrCreate();
        Gson gson = new Gson();
        User u1 = new User("Leon", "Li", "test", "leon@email.net", "doctor", "g5g3gr3gr");
        User u2 = new User("Student", "Jackson", "ist412", "student@psu.edu", "patient", "glkj3jg");
        User u3 = new User("Nurse", "Ratched", "cuckoo", "nurse@hospital.com", "nurse", "lgkjl5k3jg");
        User p1 = new User("Tim", "Legler", "test", "timlegler@gmail.com", "patient", "kl4j3lkhjgh5");
        User p2 = new User("Luke", "Kerbs", "test", "lukerbs@gmail.com", "patient", "4klgj3");
        User p3 = new User("Jay", "Kerbs", "test", "jaykerbs@gmail.com", "patient", "g5jl3");
        User p4 = new User("Josh", "Richardson", "test", "jrichardson@gmail.com", "patient", "gljk5g");
        User p5 = new User("Daniel", "Fishman", "test", "dfishman@gmail.com", "patient", "g3jlkjgr");
        try (NitriteCollection collection = db.getCollection("users")) {
            if (!collection.hasIndex("email")) {
                collection.createIndex("email", indexOptions(IndexType.Unique, true));
            }
            MapperFacade fac = new JacksonFacade();
            Document doc = fac.parse(gson.toJson(u1));
            Document doc2 = fac.parse(gson.toJson(u2));
            Document doc3 = fac.parse(gson.toJson(u3));
            Document doc4 = fac.parse(gson.toJson(p1));
            Document doc5 = fac.parse(gson.toJson(p2));
            Document doc6 = fac.parse(gson.toJson(p3));
            Document doc7 = fac.parse(gson.toJson(p4));
            Document doc8 = fac.parse(gson.toJson(p5));
            collection.insert(doc);
            collection.insert(doc2);
            collection.insert(doc3);
            collection.insert(doc4);
            collection.insert(doc5);
            collection.insert(doc6);
            collection.insert(doc7);
            collection.insert(doc8);
            this.db.commit();
        }
        catch (Exception e) {
            Logger.log("DB initialized.");
            System.out.println(e);
        }
    }

    
    @Override
    public void stop() {
        server.stop();
        db.close();
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}