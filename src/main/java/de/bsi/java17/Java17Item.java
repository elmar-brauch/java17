package de.bsi.java17;

import lombok.Builder;

// JEP 395: Records
@Builder
public record Java17Item(String name, int id) {}