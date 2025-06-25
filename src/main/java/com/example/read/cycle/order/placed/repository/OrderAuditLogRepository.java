package com.example.read.cycle.order.placed.repository;


import com.example.read.cycle.order.placed.entity.OrderAuditLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAuditLogRepository extends JpaRepository<OrderAuditLogEntity, Long> {

}
