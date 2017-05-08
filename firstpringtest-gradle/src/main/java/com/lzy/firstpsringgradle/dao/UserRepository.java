package com.lzy.firstpsringgradle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lzy.firstpsringgradle.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select t from User t where t.name = :name")
    User findByUserName(@Param("name")String name);
    
    @Modifying
    @Query("update User t set t.name = ?1 where t.id = ?1")
    int updateByUserId(String id);
}
