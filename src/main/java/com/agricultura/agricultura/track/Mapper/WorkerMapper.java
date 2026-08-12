package com.agricultura.agricultura.track.Mapper;

import com.agricultura.agricultura.track.Dto.WorkerDto;
import com.agricultura.agricultura.track.Entity.Worker;
import org.springframework.stereotype.Component;

@Component
public class WorkerMapper {

    public WorkerDto toDto(Worker entity) {
        if (entity == null) {
            return null;
        }

        return new WorkerDto(
                entity.getId(),
                entity.getName(),
                entity.getRate()
        );
    }

    public Worker toEntity(WorkerDto dto) {
        if (dto == null) {
            return null;
        }

        Worker worker = new Worker();
        worker.setId(dto.id());
        worker.setName(dto.name());
        worker.setRate(dto.rate());

        return worker;
    }
}