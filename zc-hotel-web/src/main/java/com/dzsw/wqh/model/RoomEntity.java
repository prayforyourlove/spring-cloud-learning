package com.dzsw.wqh.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "room")
@Data
public class RoomEntity implements Serializable {
    @Id
    @Column(name = "room_no")
    @GeneratedValue(generator = "JDBC")
    private Integer roomNo;

    //00 标间 01 双人间 02豪华套间 03 总统套房
    private String type;

    private Integer price;

    @Column(name = "total_stock")
    private Integer totalStock;

    private Integer stock;

    private Integer sales;

    @Column(name = "insert_time")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date insertTime;

    @Column(name = "update_time")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}