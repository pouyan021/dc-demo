package com.pk.doublecoconutdemo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1340853260921128822L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role_name", length = 32)
    private String roleName;

    @Column(name = "create_date")
    private Instant createDate;

    public Integer getId() {
        return id;
    }

    public Role setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Role setCreateDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

}
