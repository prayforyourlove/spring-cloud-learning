package com.dzsw.wqh.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "order")
@Data
public class OrderEntity  implements Serializable {
    @Id
    @Column(name = "order_no")
    @GeneratedValue(generator = "JDBC",strategy = GenerationType.IDENTITY)
    private Integer orderNo;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "room_no")
    private Integer roomNo;

    @Column(name = "order_amount")
    private Integer orderAmount;

    @Column(name = "insert_time")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date insertTime;

    @Column(name = "update_time")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}