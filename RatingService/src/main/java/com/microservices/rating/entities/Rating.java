package com.microservices.rating.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "micro_user_ratings")
public class Rating {
    @Id
    @Column(name = "ID")
    private String ratingId;
    @Column(name="USERID")
    private  String userId;
    @Column(name="HOTELID")
    private String hotelId;
    @Column(name="RATING")
    private int rating;
    @Column(name="FEEDBACK")
    private String feedback;
}
