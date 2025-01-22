package org.eternity.domainmodel.movie.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Screening {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int sequence;
    private LocalDateTime screeningTime;

    public Screening(int sequence, LocalDateTime screeningTime) {
        this.sequence = sequence;
        this.screeningTime = screeningTime;
    }
}
