package mate.academy.spring.dao;

import java.util.List;
import java.util.Optional;
import mate.academy.spring.model.CinemaHall;

public interface CinemaHallDao extends GenericDao<CinemaHall> {
    CinemaHall add(CinemaHall cinemaHall);

    Optional<CinemaHall> get(Long id);

    List<CinemaHall> getAll();

    void delete(CinemaHall cinemaHall);

    CinemaHall update(CinemaHall cinemaHall);
}
