package com.munte.disertatiebackend.mappers;

/*
    T - the DTO class
    Y - the model class
 */
public interface Mapper<T, Y> {
    public T toDTO(Y model);
    public Y toModel(T dto);
}
