package com.example.user.entity.inner;

import java.math.BigInteger;

public record UserInner(String id, String gender, String name, BigInteger offset, BigInteger size) {}
