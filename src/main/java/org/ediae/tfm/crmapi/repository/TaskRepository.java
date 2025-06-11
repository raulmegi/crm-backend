package org.ediae.tfm.crmapi.repository;

import org.ediae.tfm.crmapi.entity.AppUser;
import org.ediae.tfm.crmapi.entity.Customer;
import org.ediae.tfm.crmapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
    List<Task> findByStatus(Task.Status status);
    List<Task> findByUser(AppUser user);
    List<Task> findByCustomer(Customer customer);

    List<Task> findByStatusAndUserId(Task.Status status, Long userId);
    List<Task> findByInitialDateBetween(LocalDate start, LocalDate end);
}
