package com.rabbitMQ.message.dto;

public record MessageDto(Long id, String name, String email, String messageContent) {
}
