package com.trip.common.query;

import lombok.Data;

@Data
public class AdminUserQuery extends PageQuery{
    private String username;
    private String phone;
}
