package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class form3 {
    private JTextField campoEstudiante;
    private JTextField Calificacion;
    JPanel menuPrincipal;
    private JButton botonGuardar;
    private JTextField camposMaterias;


    public form3() {

        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n1 = campoEstudiante.getText();
                String n2 = Calificacion.getText();
                String n3 = camposMaterias.getText();
                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");


                MongoDatabase database = mongoClient.getDatabase("mydb2");
                MongoCollection<Document> collection = database.getCollection("mydb2");

                Document document = new Document("name", n1)
                        .append("Calificacion", n2)
                        .append("Materias", n3);


                collection.insertOne(document);
                System.out.println("Documento insertado");

            }

        });
    }
}