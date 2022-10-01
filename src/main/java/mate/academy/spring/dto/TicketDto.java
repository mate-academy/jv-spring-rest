package mate.academy.spring.dto;

import java.time.LocalDateTime;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.User;

public class TicketDto {
    private Long id;
    private MovieSession movieSession;
    private User user;
    private LocalDateTime showTime;

    public TicketDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieSession getMovieSession() {
        return movieSession;
    }

    public void setMovieSession(MovieSession movieSession) {
        this.movieSession = movieSession;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
