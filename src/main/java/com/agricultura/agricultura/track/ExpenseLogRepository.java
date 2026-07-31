package com.agricultura.agricultura.track;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseLogRepository extends JpaRepository<ExpenseLog, Long> {

}
