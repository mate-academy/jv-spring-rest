package mate.academy.spring.controller;

import java.time.LocalDate;
import java.util.List;
import mate.academy.spring.dto.request.MovieSessionRequestDto;
import mate.academy.spring.dto.responce.MovieSessionResponseDto;
import mate.academy.spring.mapper.Mapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.service.MovieSessionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {

    private final MovieSessionService movieSessionService;
    private final Mapper<MovieSessionRequestDto, MovieSession> requestMapper;
    private final Mapper<MovieSession, MovieSessionResponseDto> responseMapper;

    public MovieSessionController(MovieSessionService movieSessionService,
                                  Mapper<MovieSessionRequestDto, MovieSession> requestMapper,
                                  Mapper<MovieSession, MovieSessionResponseDto> responseMapper) {
        this.movieSessionService = movieSessionService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping
    public MovieSessionResponseDto add(@RequestBody MovieSessionRequestDto dto) {
        return responseMapper.map(movieSessionService.add(requestMapper.map(dto)));
    }

    @PutMapping("/{id}")
    public MovieSessionResponseDto update(@RequestParam Long movieId,
                                          @RequestBody MovieSessionRequestDto dto) {
        MovieSession movieSession = requestMapper.map(dto);
        movieSession.setId(movieId);
        return responseMapper.map(movieSessionService.update(movieSession));
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestParam Long sessionId) {
        movieSessionService.delete(sessionId);
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAvailable(@RequestParam
                                             Long sessionId,
                                             @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy")
                                             LocalDate date) {
        return responseMapper.mapAll(movieSessionService.findAvailableSessions(sessionId, date));
    }
}
