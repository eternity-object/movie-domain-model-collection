package org.eternity.domainmodel.movie.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.eternity.domainmodel.generic.Money;

import java.util.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer runningTime;
    private Money fee;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name="MOVIE_ID")
    private Collection<Screening> screenings = new ArrayList<>();

    public Movie(String title, Integer runningTime, Money fee) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
    }

    public void addScreening(Screening screening) {
        this.screenings.add(screening);
    }
}