package com.example.demo.service;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CityService {

    private final CityRepository cityRepository;


    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll() {
        return this.cityRepository.findAll();
    }

    public void create(City city) {
        this.cityRepository.save(city);
    }


    public void update(Long id, City city) {
        try {
            City cityBD = this.cityRepository.findById(id).get();
            if (cityBD != null) {
                cityBD.setName(city.getName());
                cityBD.setState(city.getState());
                this.cityRepository.save(cityBD);
            }
        }catch(NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        this.cityRepository.deleteById(id);
    }

}
