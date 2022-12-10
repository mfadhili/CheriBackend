package com.mfadhili.cheri.web.controller.Home;


import com.mfadhili.cheri.data.domain.Admin_Home.Home;
import com.mfadhili.cheri.service.home.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")

public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping("/{homeId}")
    public ResponseEntity<Home> getHomeById(@PathVariable("homeId") Long homeId){
        Optional<Home> foundHome = homeService.getHomeById(homeId);
        return new ResponseEntity<>(foundHome.get(), HttpStatus.FOUND);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Home>> getAllHomes(){
        List<Home> homes = homeService.getAllHomes();
        return new ResponseEntity<>(homes, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Home> createHome(@RequestBody Home reqHome) {
        Home newHome = homeService.createHome(reqHome);
        return new ResponseEntity<>(newHome, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{homeId}")
    public ResponseEntity<?> deleteHome(@PathVariable("homeId") Long homeId) {
        homeService.deleteHome(homeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
