package com.example.protest;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "user_des")
@Data
public class UserDes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
