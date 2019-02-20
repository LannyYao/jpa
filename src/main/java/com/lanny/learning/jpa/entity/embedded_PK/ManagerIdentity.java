package com.lanny.learning.jpa.entity.embedded_PK;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Lanny Yao
 * @date 7/7/2018 2:46 PM
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ManagerIdentity implements Serializable {

    @NotNull
    @Size(max = 20)
    private String employeeId;

    @NotNull
    @Size(max = 20)
    private String companyId;

}
