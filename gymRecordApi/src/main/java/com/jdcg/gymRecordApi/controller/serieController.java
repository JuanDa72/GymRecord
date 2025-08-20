package com.jdcg.gymRecordApi.controller;

import com.jdcg.gymRecordApi.dto.get.SerieGetDto;
import com.jdcg.gymRecordApi.dto.save.SerieSaveDto;
import com.jdcg.gymRecordApi.dto.update.SerieUpdateDto;
import com.jdcg.gymRecordApi.service.SerieService;
import jakarta.persistence.PreUpdate;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class serieController {

    private final SerieService serieService;

    public serieController(SerieService serieService) {
        this.serieService = serieService;
    }



    @PostMapping("/serie")
    public SerieGetDto save(@Valid @RequestBody SerieSaveDto serieSaveDto){
        return serieService.save(serieSaveDto);
    }



    @PutMapping("/serie/{id}")
    public SerieGetDto update(@PathVariable Integer id, @RequestBody SerieUpdateDto serieUpdateDto){
        return serieService.update(id, serieUpdateDto);
    }



    @GetMapping("/serie/{id}")
    public SerieGetDto getSerie(@PathVariable Integer id){
        return serieService.getSerie(id);
    }


    @GetMapping("/series")
    public List<SerieGetDto> getAllSeries(){
        return serieService.getAllSeries();
    }



    @DeleteMapping("/serie/{id}")
    public void delete(@PathVariable Integer id){
        serieService.delete(id);
    }






}
