package org.CoffeeStore.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Chats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String about;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "list_id")
    private java.util.List<List> list;
}
