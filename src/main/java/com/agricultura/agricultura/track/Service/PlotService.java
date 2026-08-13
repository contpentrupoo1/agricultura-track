package com.agricultura.agricultura.track.Service;

import com.agricultura.agricultura.track.Dto.PlotDto;
import com.agricultura.agricultura.track.Entity.Plot;
import com.agricultura.agricultura.track.Mapper.PlotMapper;
import com.agricultura.agricultura.track.Repository.PlotRepository;
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

    public PlotDto getPlotById(Long id) {
        return plotMapper.toDto(plotRepository.findById(id).orElseThrow(() -> new RuntimeException("Plot with id: " + id + " has not been found")));
    }

    public PlotDto updatePlot(Long id, PlotDto dtoSent) {
        Plot plot = plotRepository.findById(id).orElseThrow(() -> new RuntimeException("Plot with id: " + id + " has not been found"));

        if(dtoSent.name() != null) {
            plot.setName(dtoSent.name());
        }

        if(dtoSent.size() != null) {
            plot.setSize(dtoSent.size());
        }

        if(dtoSent.type() != null) {
            plot.setType(dtoSent.type());
        }

        if(dtoSent.status() != null) {
            plot.setStatus(dtoSent.status());
        }

        return plotMapper.toDto(plotRepository.save(plot));
    }

}




