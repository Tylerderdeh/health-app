package kz.iitu.healthapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "doctor")
    private User user;

    private String firstName;
    private String lastName;
    private String middleName;
    private String specialization;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}