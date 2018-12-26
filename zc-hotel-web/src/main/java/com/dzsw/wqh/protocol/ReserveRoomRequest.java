package com.dzsw.wqh.protocol;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true) //链式setter
public class ReserveRoomRequest {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer roomNo;
}
