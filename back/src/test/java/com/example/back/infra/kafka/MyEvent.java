package com.example.back.infra.kafka;

import com.example.back.standard.event.HasEventName;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public record MyEvent(String msg) implements HasEventName {
}