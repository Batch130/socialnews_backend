package com.batch130.repository;


import com.batch130.entity.concretes.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // optional
public interface EntryRepository extends JpaRepository<Entry,Long> {



    boolean existsBySubject(String subject);

    @Query("SELECT e FROM Entry e WHERE e.createdBy.id =:id")
    List<Entry> findAllByUserId(Long id);
}
