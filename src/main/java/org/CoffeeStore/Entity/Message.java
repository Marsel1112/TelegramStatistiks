package org.CoffeeStore.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;
import org.CoffeeStore.CastomDeserialize.MessageDeserializer;


import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = MessageDeserializer.class)
@ToString

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long message_id;


    private long id;

    private String type;
    private LocalDateTime date;
    @Column(name = "is_from")
    private String from;
    private String from_id;
    @Column(name = "text_message", columnDefinition = "TEXT")
    private String text;


}
