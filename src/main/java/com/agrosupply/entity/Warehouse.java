package com.agrosupply.entity;

import com.agrosupply.enums.WarehouseStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "warehouses")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    private Double capacityTon;

    // Warehouse operator assigned to manage this warehouse
    // nullable — warehouse can exist before an operator is assigned
    @ManyToOne
    @JoinColumn(name = "operator_id", nullable = true)
    private User operator;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WarehouseStatus status;
}