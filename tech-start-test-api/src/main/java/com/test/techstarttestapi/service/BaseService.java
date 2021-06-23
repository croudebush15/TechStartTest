package com.test.techstarttestapi.service;

import java.util.List;

public interface BaseService<C,I> {

    void save(C c);
    List<C> getAll();

    C find(I i);
}
