package com.phuong.livestreamapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Data
@Entity
public class AppUser {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(nullable = false)
    private String fullName;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] avatar;

    private String phoneNumber;

    @Column(unique = true, nullable = false)
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "LONGTEXT")
    private String address;
    
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private AppRole appRole;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppUser appUser = (AppUser) o;
        return id != null && Objects.equals(id, appUser.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
