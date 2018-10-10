package org.hackathon.packapp.containerbank.rest;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Payment;
import org.hackathon.packapp.containerbank.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentRest")
public class PaymentRestController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentRestController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping("/savePayment")
	public void savePayment(@RequestParam(value="payment") Payment payment) throws DataAccessException {
    	paymentService.savePayment(payment);
	}
    
    @RequestMapping("/findPaymentsByCardId")
	public Collection<Payment> findPaymentsByCardId(@RequestParam(value="cardId") int cardId) {
		return paymentService.findPaymentsByCardId(cardId);
	}
}
