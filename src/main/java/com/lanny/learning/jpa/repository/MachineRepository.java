package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.generator.MachineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lanny Yao
 * @date 7/10/2018 9:25 AM
 */
public interface MachineRepository extends JpaRepository<MachineEntity, String> {

}
