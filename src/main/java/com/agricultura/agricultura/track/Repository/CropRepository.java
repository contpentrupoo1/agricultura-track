package com.agricultura.agricultura.track.Repository;

import com.agricultura.agricultura.track.Entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

}
