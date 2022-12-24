package com.example.dto.entityDto.category;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CategoryDto {


    private Integer id;

    private String name;


    private LocalDateTime cratedDate;

}
