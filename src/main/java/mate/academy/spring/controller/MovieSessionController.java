package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dto.MovieSessionRequestDto;
import mate.academy.spring.dto.MovieSessionResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.mapper.MovieSessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    @Autowired
    private MovieSessionService movieSessionService;
    @Autowired
    private MovieSessionMapper movieSessionMapper;

    @PostMapping
    // request type "movieId":?, "cinemaHallId":?, "showTime":"yyyy-MM-DDThh:mm"
    public MovieSessionRequestDto create(
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        movieSessionService.add(movieSessionMapper.toModel(movieSessionRequestDto));
        return movieSessionRequestDto;
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailable(@RequestParam Long movieId,
                                                         @RequestParam String date) {
        LocalDate showDate = LocalDate.parse(date);
        return movieSessionService.findAvailableSessions(movieId, showDate)
                .stream()
                .map(movieSession -> movieSessionMapper.toDto(movieSession))
                .collect(Collectors.toList());
    }

    @PutMapping({"/{id}"})
    public MovieSessionResponseDto update(@PathVariable Long id) {
        movieSessionService.update(movieSessionService.get(id));
        return movieSessionMapper.toDto(movieSessionService.get(id));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        movieSessionService.delete(id);
        return "Movie session was deleted";
    }
}
