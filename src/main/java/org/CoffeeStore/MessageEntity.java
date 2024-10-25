package org.CoffeeStore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.HashMap;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "StatistikaEbana")
public class MessageEntity {
    @Id
    private long id;

    private String type;

    private String date;

    @Column(name = "date_unixtime")
    private String dateUnixTime;

    @Column(name = "fram")
    private String from;

    private String from_id;

    private String text;
}
