package com.javaweb.model.request;


import com.javaweb.model.dto.AbstractDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSearchRequest extends AbstractDTO {
    private String fullname;
    private String email;
    private String phone;
    private Long staffId;
    private String status;
}
