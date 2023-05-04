package com.munte.disertatiebackend.mappers;

/*
    D - the DTO class
    M - the model class
 */
public interface Mapper<D, M> {
    public D toDTO(M model);
    public M toModel(D dto);
}
