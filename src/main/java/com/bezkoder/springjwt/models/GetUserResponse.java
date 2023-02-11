package com.bezkoder.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetUserResponse {
    private String username;
    private String email;
    private List<String> roles;
}
