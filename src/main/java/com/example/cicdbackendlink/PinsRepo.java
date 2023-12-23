package com.example.cicdbackendlink;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PinsRepo extends JpaRepository<Pins,Long> {
}
