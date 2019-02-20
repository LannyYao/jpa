package com.lanny.learning.jpa.repository;

import com.lanny.learning.jpa.entity.inherit.single_table.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lanny Yao
 * @date 7/8/2018 4:12 PM
 */
@Repository
public interface FolderRepository extends JpaRepository<Folder, Integer> {

}
