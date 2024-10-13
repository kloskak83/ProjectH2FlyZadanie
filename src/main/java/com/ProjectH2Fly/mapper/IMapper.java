package com.ProjectH2Fly.mapper;

public interface IMapper <Input,Output>{
    Output map(Input input);
}
