package mate.academy.spring.service.impl;

import java.util.List;
import mate.academy.spring.dao.CinemaHallService;
import mate.academy.spring.model.CinemaHall;
import org.springframework.stereotype.Service;

@Service
public class CinemaHallServiceImpl implements mate.academy.spring.service.CinemaHallService {
    private final CinemaHallService cinemaHallDao;

    public CinemaHallServiceImpl(CinemaHallService cinemaHallDao) {
        this.cinemaHallDao = cinemaHallDao;
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public CinemaHall get(Long id) {
        return cinemaHallDao.get(id).get();
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
