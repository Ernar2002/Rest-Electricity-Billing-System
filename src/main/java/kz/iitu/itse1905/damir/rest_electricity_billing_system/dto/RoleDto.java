package kz.iitu.itse1905.damir.rest_electricity_billing_system.dto;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Role;
import lombok.Data;

@Data
public class RoleDto {
    private Long id;
    private String name;

    public static RoleDto fromRole(Role role){
        RoleDto roleDto = new RoleDto();

        roleDto.setId(role.getId());
        roleDto.setName(role.getName());

        return roleDto;
    }
}
