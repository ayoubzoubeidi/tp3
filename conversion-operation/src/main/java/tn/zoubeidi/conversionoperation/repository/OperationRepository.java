package tn.zoubeidi.conversionoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.zoubeidi.conversionoperation.domain.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
