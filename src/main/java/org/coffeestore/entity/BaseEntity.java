package org.coffeestore.entity;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "very_important_information")
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "important_information", columnDefinition = "TEXT")
    private String about;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chats_id")
    private Chats chats;

}
