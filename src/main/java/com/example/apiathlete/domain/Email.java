package com.example.apiathlete.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "email")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Email implements Serializable {
    private static final long serialVersionUID = 667011049015452582L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String addressEmail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Email email = (Email) o;
        return Objects.equals(id, email.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}