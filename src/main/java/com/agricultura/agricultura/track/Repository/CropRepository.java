package com.agricultura.agricultura.track.Repository;

import com.agricultura.agricultura.track.Entity.Crop;
import com.agricultura.agricultura.track.Entity.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
    List<Crop> findByPlotId(Long id);
}
