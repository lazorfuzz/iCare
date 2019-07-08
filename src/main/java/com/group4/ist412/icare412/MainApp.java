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
import org.dizitart.no2.objects.Cursor;
import static org.dizitart.no2.IndexOptions.indexOptions;
import org.dizitart.no2.IndexType;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

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
        scene = new Scene(new Browser(db), 960, 600, Color.web("#666970"));
        stage.setScene(scene);  
        System.out.println("Showing stage");
        stage.show();
    }
    
    public void initDB() {
        db = Nitrite.builder()
        .compressed()
        .filePath("icare.db")
        .openOrCreate();
        
        ObjectRepository<User> userRepo = db.getRepository(User.class);
        Cursor<User> cursor = userRepo.find();
        if (cursor.totalCount() == 0) {
            userRepo.insert(new User("Leon", "Li", "test", "leon@email.net", "doctor"));
            userRepo.insert(new User("Student", "Jackson", "ist412", "student@psu.edu", "patient"));
            db.commit();
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