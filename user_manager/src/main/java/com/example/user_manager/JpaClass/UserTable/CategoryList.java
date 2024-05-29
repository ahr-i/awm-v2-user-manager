package com.example.user_manager.JpaClass.UserTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CategoryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listId;
    @Column
    private String userId;
    @Column
    private String categoryList;
}