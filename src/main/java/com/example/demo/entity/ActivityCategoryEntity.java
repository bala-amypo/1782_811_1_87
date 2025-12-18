
package com.example.demo.entity;

import jakarta.persistence.Entity;


@Entity
public class ActivityCategory(){
    private long id;
    private String categoryName;
    private String description;
    private LocalDateTime createdAt;

}

public ActivityCategory(){

}

public ActivityCategory(long id,String categoryName,String description, LocalDateTime createdAt){
    this.categoryName=categoryName;
    this.description=description;
    this.createdAt=createdAt;
}




