package com.tech.kj.controller;

import com.tech.kj.domain.Instrument;
import com.tech.kj.repo.InstrumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrument")
@Slf4j
@RequiredArgsConstructor
public class InstrumentController {
    private final InstrumentRepository instrumentRepository;

    @GetMapping
    List<Instrument> getInstrument(){
        log.info("returning all instruments");
        return instrumentRepository.findAll();
    }

    @GetMapping("/{type}")
    List<Instrument> getInstrumentByType(@PathVariable String type){
        log.info("returning instrument by type");
        return instrumentRepository.findByType(type);
    }

    @PostMapping
    Instrument addInstrument(@RequestBody Instrument instrument){
        log.info("Adding instrument: {}", instrument.getName());
        return instrumentRepository.save(instrument);
    }
}
