package com.example.dto.channel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SelectBeforeUpdate;

@Getter
@Setter
public class ChannelCreateDTO {
    @NotBlank(message = "Name required")
    private String name;

    @NotBlank(message = "PhotoId required")
    private String photoId;

    @Size(min = 20, max = 200, message = "Description required")
    private String description;

    @NotBlank(message = "BannerId required")
    private String bannerId;
}
