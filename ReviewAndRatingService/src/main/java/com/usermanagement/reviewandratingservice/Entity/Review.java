package com.usermanagement.reviewandratingservice.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int reviewID;
    private int eventID;
    private int userID;
    private String userName;
    private int rating;
    private String comment;

    public Review() {
    }

    public Review(int eventID, int userID, String userName, int rating, String comment) {
        this.eventID = eventID;
        this.userID = userID;
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
    }

    public Review(int reviewID, int eventID, int userID, String userName, int rating, String comment) {
        this.reviewID = reviewID;
        this.eventID = eventID;
        this.userID = userID;
        this.userName = userName;
        this.rating = rating;
        this.comment = comment;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
