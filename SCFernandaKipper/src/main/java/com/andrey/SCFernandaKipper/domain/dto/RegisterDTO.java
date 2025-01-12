package com.andrey.SCFernandaKipper.domain.dto;

import com.andrey.SCFernandaKipper.domain.enums.UserRoleEnum;

public record RegisterDTO(String login, String password, UserRoleEnum role) {
}
