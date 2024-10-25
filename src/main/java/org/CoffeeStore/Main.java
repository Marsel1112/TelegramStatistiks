package org.CoffeeStore;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.CoffeeStore.Entity.BaseEntity;
import org.CoffeeStore.Entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    private static final File FILE_TO_TELEGRAM = new File("C:\\Users\\User\\Downloads\\Telegram Desktop\\DataExport_2024-10-25\\result.json");
    private static final ObjectMapper MAPPER = new ObjectMapper();


    public static void main(String[] args) throws IOException {
        Reader reader = new Reader(MAPPER,FILE_TO_TELEGRAM);
        BaseEntity baseEntity = reader.readFile();

        //writer(baseEntity);
        dataBaseSaver(baseEntity);





    }

    public static void writer(BaseEntity baseEntity){
        for (int i = 0; i < baseEntity.getChats().getList().size(); i++) {
            org.CoffeeStore.Entity.List list = baseEntity.getChats().getList().get(i);

            for (int j = 0; j < list.getMessages().size(); j++) {
                Message message = list.getMessages().get(j);

                System.out.println(message.getId());
                System.out.println(message.getType());
                System.out.println(message.getDate());
                System.out.println(message.getFrom());
                System.out.println(message.getFrom_id());
                System.out.println(message.getText());
            }



        }



    }

    public static void dataBaseSaver(BaseEntity baseEntity){
        Config config = new Config();
        SessionFactory sessionFactory = config.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.persist(baseEntity);

            session.getTransaction().commit();

        }
    }
}