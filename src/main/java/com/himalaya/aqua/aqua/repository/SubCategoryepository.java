package com.himalaya.aqua.aqua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.himalaya.aqua.aqua.core.entity.SubCategory;

@Repository
@Transactional
public interface SubCategoryepository extends JpaRepository<SubCategory, Long> {

}
