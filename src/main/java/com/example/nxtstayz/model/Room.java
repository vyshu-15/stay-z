/*
 *
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here
package com.example.nxtstayz.model;

import javax.persistence.*;

@Entity
@Table(name="room") // This annotation specifies the table name as "room"
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id") // This annotation specifies the column name as "room_id"
    private int id;

    @Column(name = "room_number") // This annotation specifies the column name as "room_number"
    private String roomNumber;

    @Column(name = "room_type") // This annotation specifies the column name as "room_type"
    private String type;

    @Column(name = "price") // This annotation specifies the column name as "price"
    private double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id") // This annotation specifies the column name as "hotel_id"
    private Hotel hotel;
