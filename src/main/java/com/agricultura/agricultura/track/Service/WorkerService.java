package com.agricultura.agricultura.track.Service;

import com.agricultura.agricultura.track.Dto.WorkerDto;
import com.agricultura.agricultura.track.Entity.Worker;
import com.agricultura.agricultura.track.Mapper.WorkerMapper;
import com.agricultura.agricultura.track.Repository.WorkerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerMapper workerMapper;

    public WorkerService(WorkerRepository workerRepository, WorkerMapper workerMapper) {
        this.workerRepository = workerRepository;
        this.workerMapper = workerMapper;
    }

    public void createWorker(WorkerDto dto) {
        Worker worker = workerMapper.toEntity(dto);
        workerRepository.save(worker);
    }

    public Page<WorkerDto> getAllWorkers(int page, int size, String sortCategory) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortCategory));
        Page<Worker> workerPage = workerRepository.findAll(pageRequest);
        return workerPage.map(worker -> workerMapper.toDto(worker));
    }

    public WorkerDto getWorkerById(Long id) {
        return workerMapper.toDto(workerRepository.findById(id).orElseThrow(() -> new RuntimeException ("Worker with id: " + id + " has not been found")));
    }


}