package com.agricultura.agricultura.track;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PlotService {

    private final PlotRepository plotRepository;
    private final PlotMapper plotMapper;

    public PlotService(PlotRepository plotRepository, PlotMapper plotMapper) {
        this.plotRepository = plotRepository;
        this.plotMapper = plotMapper;
    }

    public Page<PlotDto> getAllPlots(int page, int size, String sortcategory) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortcategory));
        return plotRepository.findAll(pageable)
                .map(plotMapper::toDto);
    }

    public void createPlot(PlotDto dto) {
        plotRepository.save(plotMapper.toEntity(dto));
    }

}




