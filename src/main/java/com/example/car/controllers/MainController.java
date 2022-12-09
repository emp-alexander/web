package com.example.car.controllers;

import com.example.car.models.Car;
import com.example.car.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class MainController {

    @Autowired
    private CarsRepository carsRepository;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");

        Iterable<Car> cars = carsRepository.findAll();
        model.addAttribute("cars", cars);
        return "home";
    }

    @GetMapping("/add")
    public String add(Model model) {

        return "add";
    }

    @PostMapping("/add")
    public String carPostAdd(@RequestParam String nameCar, @RequestParam String year, Model model){
        Car car = new Car(nameCar, year);
        carsRepository.save(car);
        return "redirect:/";
    }

    @GetMapping("/more/{id}")
    public String carDetails(@PathVariable(value = "id") long id, Model model) {
        if(!carsRepository.existsById(id)){
            return "redirect:/";
        }

        Optional<Car> car = carsRepository.findById(id);
        ArrayList<Car> res = new ArrayList<>();
        car.ifPresent(res::add);
        model.addAttribute("car", res);
        return "more";
    }

    @GetMapping("/admin/{id}/redaction")
    public String carEdit(@PathVariable(value = "id") long id, Model model) {
        if(!carsRepository.existsById(id)){
            return "redirect:/";
        }

        Optional<Car> car = carsRepository.findById(id);
        ArrayList<Car> res = new ArrayList<>();
        car.ifPresent(res::add);
        model.addAttribute("car", res);
        return "redaction";
    }


}