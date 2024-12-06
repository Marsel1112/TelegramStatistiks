package org.coffeestore;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import org.coffeestore.entity.BaseEntity;

import java.io.File;
import java.io.IOException;


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

