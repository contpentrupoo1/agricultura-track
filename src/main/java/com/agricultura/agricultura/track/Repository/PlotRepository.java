package com.agricultura.agricultura.track.Repository;

import com.agricultura.agricultura.track.Entity.Plot;
import com.agricultura.agricultura.track.Entity.PlotStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {
    long countByStatus(PlotStatus status);

}

