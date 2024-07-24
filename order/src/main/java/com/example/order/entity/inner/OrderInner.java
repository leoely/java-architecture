package com.example.order.entity.inner;

import java.math.BigInteger;

public record OrderInner(BigInteger id, int count, long userId) {}
