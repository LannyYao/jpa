package com.lanny.learning.jpa.entity.embedded_PK;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Email;

/**
 * @author Lanny Yao
 * @date 7/7/2018 2:43 PM
 */
@Entity
@Table(name = "managers")
@NoArgsConstructor
@AllArgsConstructor
public class Manager {

    @EmbeddedId
    private ManagerIdentity managerIdentity;

    @NotNull
    @Size(max = 60)
    private String name;

    @NaturalId
    @NotNull
    @Email
    @Size(max = 60)
    private String email;

    @Size(max = 15)
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

}
