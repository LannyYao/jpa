package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.bothn21.JpaAsset;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lanny Yao
 * @date 6/9/2018 11:41 AM
 */
public interface AssetRepository extends JpaRepository<JpaAsset, Integer> {

}
