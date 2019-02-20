package com.lanny.learning.jpa.entity.embedded_key;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author Lanny Yao
 * @date 6/30/2018 5:21 PM
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Name implements Serializable {

    @NotNull
    @Size(max = 40)
    private String firstName;

    @Size(max = 40)
    private String middleName;

    @Size(max = 40)
    private String lastName;
}
