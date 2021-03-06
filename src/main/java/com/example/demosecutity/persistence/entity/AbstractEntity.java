package com.example.demosecutity.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = -4681344806591011540L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
