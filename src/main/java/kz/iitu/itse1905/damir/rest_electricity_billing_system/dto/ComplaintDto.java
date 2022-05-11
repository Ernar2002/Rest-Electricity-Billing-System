package kz.iitu.itse1905.damir.rest_electricity_billing_system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.details.UserDetails;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Bill;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Complaint;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.EActive;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class ComplaintDto {
    private String text;
    private EActive active;
    private Date created;

    public static ComplaintDto fromComplaint(Complaint complaint){
        ComplaintDto complaintDto = new ComplaintDto();

        complaintDto.setText(complaint.getText());
        complaintDto.setActive(complaint.getActive());
        complaintDto.setCreated(complaint.getCreated());

        return complaintDto;
    }
}
