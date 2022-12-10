package com.mfadhili.cheri.service.home;


import com.mfadhili.cheri.data.domain.Admin_Home.Home;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface HomeService {
    Home createHome( Home home);

    Optional<Home>
    String deleteHome(Long homeId);
    Optional<Home> getHomeById(Long Id);

    List<Home> getAllHomes();
}
