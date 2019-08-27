package com.github.spotswood.tacocloud.repositories;

import com.github.spotswood.tacocloud.models.Taco;

public interface TacoRepository  {

    Taco save(Taco taco);
}