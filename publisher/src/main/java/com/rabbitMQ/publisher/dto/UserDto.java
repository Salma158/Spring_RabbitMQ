package com.rabbitMQ.publisher.dto;

public record UserDto(Long id, String name, String email, String password, String confirmPassword , String mobileNumber) {
}
