package com.bincoding.nonprofit.dto;

import lombok.Value;

@Value
public class UserWithoutPass {

    String username, fname, lname, address, state, city, zip, roles;
}
