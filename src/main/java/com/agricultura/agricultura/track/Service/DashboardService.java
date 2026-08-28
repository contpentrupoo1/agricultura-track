package com.agricultura.agricultura.track.Service;

import com.agricultura.agricultura.track.Dto.DashboardDto;
import com.agricultura.agricultura.track.Entity.ExpenseLog;
import com.agricultura.agricultura.track.Entity.Plot;
import com.agricultura.agricultura.track.Repository.CropRepository;
import com.agricultura.agricultura.track.Repository.ExpenseLogRepository;
import com.agricultura.agricultura.track.Repository.PlotRepository;
import com.agricultura.agricultura.track.Repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
   private final PlotRepository plotRepository;
   private final CropRepository cropRepository;

   private final WorkerRepository workerRepository;
   private final ExpenseLogRepository expenseLogRepository;

   private final PlotService plotService;
   private final CropService cropService;

   private final InventoryService inventoryService;

   public DashboardService (PlotRepository plotRepository,
                            CropRepository cropRepository,
                            WorkerRepository workerRepository,
                            ExpenseLogRepository expenseLogRepository,
                            PlotService plotService,
                            CropService cropService,
                            InventoryService inventoryService)
   {
       this.plotRepository = plotRepository;
       this.cropRepository = cropRepository;
       this.workerRepository = workerRepository;
       this.expenseLogRepository = expenseLogRepository;
       this.plotService = plotService;
       this.cropService = cropService;
       this.inventoryService = inventoryService;
   }

   public DashboardDto getDashboardSummary() {
       long plotCount = plotRepository.count();
       long workerCount = workerRepository.count();
       long cropCount = cropRepository.count();
//       List<ExpenseLog> allExpenses = expenseLogRepository.findAll();
//       double totalSpent = 0.0;
//       for(ExpenseLog value : allExpenses) {
//           totalSpent += value.getTotalcost();
//       }
       double totalSpent = expenseLogRepository.calculateTotalExpenses();

       return new DashboardDto(plotCount, workerCount, cropCount, totalSpent);
   }

}
