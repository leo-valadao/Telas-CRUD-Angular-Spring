package com.leonardo.Spring.domain;

import javax.annotation.Generated;
import javax.persistence.Column;

public class SaleProduct {
    
    //Attributes
    // ID - Long - Not Nullable - Serial - Identifier
    @Id
    @Generatedvalue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    //
}
