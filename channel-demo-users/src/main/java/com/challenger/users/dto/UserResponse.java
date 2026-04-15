package com.challenger.users.dto;

public record UserResponse(
    Long id,
    String name,
    String username,
    String email,
    String street,
    String suite,
    String city,
    String zipcode,
    String lat,
    String lng,
    String phone,
    String website,
    String companyName,
    String companyCatchPhrase,
    String companyBs
) {
}