package com.trip.common.dto;

import lombok.Data;

@Data
public class UpdateCategoryRequest {
    
    private String categoryName;
    
    private String description;
    
    private String iconUrl;
    
    private Integer sortOrder;
    
    private Integer status;
}
