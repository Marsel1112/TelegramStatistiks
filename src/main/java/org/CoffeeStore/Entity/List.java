package org.CoffeeStore.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "lists")
public class List {

    private String name;

    private String type;

    @Id
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "messages_id")
    private java.util.List<Message> messages;
}
