package com.agricultura.agricultura.track.Repository;

import com.agricultura.agricultura.track.Entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
