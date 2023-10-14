package com.inq.learnease.vo;

public enum ResponseStatusCode {
    SUCCESS(1),
    FAIL(0);

    public final int value;

    ResponseStatusCode(int value) {
        this.value = value;
    }
}
