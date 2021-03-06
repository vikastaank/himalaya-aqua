package com.himalaya.aqua.aqua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.himalaya.aqua.aqua.core.entity.Category;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
