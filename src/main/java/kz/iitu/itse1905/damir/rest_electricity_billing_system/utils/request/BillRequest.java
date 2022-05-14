package kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.EStatus;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.ETariff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
public class BillRequest {
    private int units;
    private ETariff tariff;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date endDate;
}
