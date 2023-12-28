package com.example.cicdbackendlink;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PinsRepo extends JpaRepository<Pins,Long> {

    void deleteBySheepId(String sheepId);
}
