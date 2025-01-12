package net.buildUi.ExpenseService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String expenseId;

    private String amount;

    private String userId;

    private String merchant;

    private String currency;

    private Timestamp createdAt;

    @PrePersist
    @PreUpdate
    private void generateExpenseAndCreatedAt(){
        if(this.expenseId == null){
            this.expenseId = String.valueOf(UUID.randomUUID());
        }
        if(this.createdAt == null){
            this.createdAt = Timestamp.from(Instant.now());
        }
    }

}
