package com.demwis.tests.gilan.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Qualifier(IdGenerationService.STRING)
public class UuidGenerationService implements IdGenerationService<String> {
    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
