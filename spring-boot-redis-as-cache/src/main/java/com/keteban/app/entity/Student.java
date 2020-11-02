package com.keteban.app.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author EPebrisulistiyo
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
@Entity
public class Student implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String email;
}
