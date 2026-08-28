package com.agricultura.agricultura.track.Repository;

import com.agricultura.agricultura.track.Entity.ExpenseLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseLogRepository extends JpaRepository<ExpenseLog, Long> {
    @Query("SELECT COALESCE(SUM(e.totalcost), 0.0) FROM ExpenseLog e")
    Double calculateTotalExpenses();

}
