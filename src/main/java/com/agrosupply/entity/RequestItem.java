package com.agrosupply.entity;

import com.agrosupply.enums.RequestItemStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "request_items")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class RequestItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Which farmer request this item belongs to
    @ManyToOne
    @JoinColumn(name = "farmer_request_id", nullable = false)
    private FarmerRequest farmerRequest;

    // Which product is being requested
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    // PENDING → ALLOCATED (once warehouse operator confirms stock for this item)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestItemStatus status;
}