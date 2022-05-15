package kz.iitu.itse1905.damir.rest_electricity_billing_system.controller.user;

import kz.iitu.itse1905.damir.rest_electricity_billing_system.dto.BillDto;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.Bill;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.model.User;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.BillService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.TransactionService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.service.UserService;
import kz.iitu.itse1905.damir.rest_electricity_billing_system.utils.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/bill/", produces = MediaType.APPLICATION_JSON_VALUE)
public class BillRestController {

    private final UserService userService;
    private final BillService billService;
    private final TransactionService transactionService;

    @Autowired
    public BillRestController(
            UserService userService,
            BillService billService,
            TransactionService transactionService
    ){
        this.userService = userService;
        this.billService = billService;
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<BillDto>> getAllBills(Principal principal){
        if(principal == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.findByEmail(principal.getName());

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Bill> bills = billService.getBillsOfUser(user);

        List<BillDto> billDtos = new ArrayList<>();

        for(Bill bill: bills){
            billDtos.add(BillDto.fromBill(bill));
        }

        return new ResponseEntity<>(billDtos, HttpStatus.OK);
    }

    @PostMapping("/{billId}/pay")
    public ResponseEntity<?> payForBill(@PathVariable("billId") Long billId, @RequestParam double payable, Principal principal){
        if(principal == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        User user = userService.findByEmail(principal.getName());
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        transactionService.addToBill(payable, billService.getById(billId));
        return new ResponseEntity<>(new MessageResponse("Payed successfully"), HttpStatus.OK);
    }
}

