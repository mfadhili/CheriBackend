package com.mfadhili.cheri.service.home;


import com.mfadhili.cheri.data.domain.Admin_Home.Home;
import com.mfadhili.cheri.data.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService{
    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Home createHome(Home home) {
        Home newHome = new Home();

        newHome.setHome_name(home.getHome_name());
        newHome.setHome_email(home.getHome_email());
        newHome.setTelephone(home.getTelephone());
        newHome.setCreatedAt(LocalDate.now());

        return homeRepository.save(newHome);
    }

    @Override
    public Optional<Home> updateHome(Long homeId, Home homeReq) {
        Optional<Home> oldHome = homeRepository.findById(homeId);

        if (oldHome.isEmpty()) {
            throw new IllegalStateException("Home of Id "+ homeId + "Does not exist");
        }
        else {
            oldHome.get().setHome_name(homeReq.getHome_name());
            oldHome.get().setHome_email(homeReq.getHome_email());
            oldHome.get().setTelephone(homeReq.getTelephone());
            oldHome.get().setUpdatedAt(LocalDate.now());
        }
        return Optional.empty();
    }

    @Override
    public String deleteHome(Long homeId) {
        boolean exist = homeRepository.existsById(homeId);

        if (!exist){
            throw new IllegalStateException("Home of Id "+ homeId + "Does not exist");
        }
        else
            homeRepository.deleteById(homeId);

        return "deleted successful";
    }

    @Override
    public Optional<Home> getHomeById(Long Id) {
        Optional<Home> home = homeRepository.getHomeById(Id);

        if (home.isPresent()) {
            return home;
        }
        else {
            throw new IllegalStateException("Home of Id "+ Id + "Does not exist");
        }

    }

    @Override
    public List<Home> getAllHomes() {
        return homeRepository.findAll();
    }


}
