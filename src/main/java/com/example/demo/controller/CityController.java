package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping("/")
    public List<City> findAll(){
        return cityService.findAll();
    }

    @PostMapping("/")
    public List<City> create(@RequestBody City city){
        cityService.create(city);
        return findAll();
    }

    @PutMapping("/{id}")
    public List<City> update(@PathVariable("id") Long id, @RequestBody City city){
        cityService.update(id, city);
        return findAll();
    }

    @DeleteMapping("/{id}")
    public List<City> delete(@PathVariable("id") Long id){
        cityService.delete(id);
        return findAll();
    }



}
