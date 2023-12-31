package com.example.cicdbackendlink;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PinsService {
    private final PinsRepo pinsRepo;

    public PinsService(PinsRepo pinsRepo) {
        this.pinsRepo = pinsRepo;
    }

    public void createPin(Pins pins) {
        pins.setDate(LocalDate.now());
        pinsRepo.save(pins);
    }

    public List<Pins> allPins() {
        return pinsRepo.findAll();
    }
    @Transactional
    public void deletePin(String sheepId) {
         pinsRepo.deleteBySheepId(sheepId);
    }
}
