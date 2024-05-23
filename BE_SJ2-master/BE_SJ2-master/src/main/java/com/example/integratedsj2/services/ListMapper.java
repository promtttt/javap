package com.example.integratedsj2.services;

import org.hibernate.query.Page;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ListMapper {
    private static final ListMapper listMapper = new ListMapper();
    private static ModelMapper modelMapper = new ModelMapper();
    private ListMapper() {
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        return source.stream().map(entity -> modelMapper.map(entity, targetClass)).collect(Collectors.toList());
    }
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return mapList(source,targetClass, modelMapper);
    }
    public static ListMapper getInstance() {
        return listMapper;
    }
//    public <S, T> PageDTO<T> toPageDTO(Page<S> source, Class<T> targetClass, ModelMapper modelMapper) {
//        PageDTO<T> page = modelMapper.map(source, PageDTO.class);
//        page.setContent(mapList(source.getContent(), targetClass, modelMapper));
//        return page;
//    }
//    public <S, T> PageDTO<T> toPageDTO(Page<S> source, Class<T> targetClass) {
//        return toPageDTO(source, targetClass, modelMapper);
//    }
}
