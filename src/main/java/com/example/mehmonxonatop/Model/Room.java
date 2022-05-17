package com.example.mehmonxonatop.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true)
    private Integer roomNumber;
    @Column(nullable = false)
    private Integer qavat;

    @ManyToOne
    Hotel hotel;
}
