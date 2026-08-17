package com.agricultura.agricultura.track.Service;

import com.agricultura.agricultura.track.Dto.CropDto;
import com.agricultura.agricultura.track.Entity.Crop;
import com.agricultura.agricultura.track.Entity.Plot;
import com.agricultura.agricultura.track.Mapper.CropMapper;
import com.agricultura.agricultura.track.Repository.CropRepository;
import com.agricultura.agricultura.track.Repository.PlotRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService {
    private final CropRepository cropRepository;
    private final PlotRepository plotRepository;
    private final CropMapper cropMapper;

    public CropService(CropRepository cropRepository, PlotRepository plotRepository, CropMapper cropMapper) {
        this.cropRepository = cropRepository;
        this.plotRepository = plotRepository;
        this.cropMapper = cropMapper;
    }

    public void createCrop(CropDto dto) {
        Plot plot = plotRepository.findById(dto.plotida())
                .orElseThrow(() -> new RuntimeException("Plot not found with the given id: " + dto.plotida()));

        Crop crop = cropMapper.toEntity(dto);

        crop.setPlot(plot);

        cropRepository.save(crop);
    }

    public Page<CropDto> getAllCrops(int page, int size, String sortCategory) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortCategory));
        Page<Crop> crops = cropRepository.findAll(pageRequest);
        return crops.map(cropMapper::toDto);
    }

    public List<CropDto> getCropsByPlot(Long id) {
        return cropRepository.findByPlotId(id).stream().map(cropMapper::toDto).toList();
    }


}

