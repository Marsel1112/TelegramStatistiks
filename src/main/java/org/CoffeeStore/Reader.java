package org.CoffeeStore;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import org.CoffeeStore.Entity.BaseEntity;
import org.CoffeeStore.Entity.Chats;

import java.io.File;
import java.io.IOException;
import java.util.List;


@AllArgsConstructor
public class Reader{

    private ObjectMapper objectMapper;
    private File file;

    public BaseEntity readFile(){
        BaseEntity baseEntity = null;

        try {
            baseEntity = objectMapper.readValue(file, BaseEntity.class);


        }catch (IOException e){
            e.printStackTrace();
        }

        return baseEntity;
    }
}

