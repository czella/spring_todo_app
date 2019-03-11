package com.codecool.spring_todo_app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {

    @Column
    private String title;

    @Column
    private Status status;

    @Id
    @GeneratedValue
    private long id;

    public boolean isComplete() {
        return this.status == Status.COMPLETE;
    }


    public void toggleStatus (boolean isComplete) {
        if (isComplete) {
            this.status = Status.COMPLETE;
        } else {
            this.status = Status.ACTIVE;
        }
    }



}
