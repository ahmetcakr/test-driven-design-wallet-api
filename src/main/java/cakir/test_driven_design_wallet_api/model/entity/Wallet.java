package cakir.test_driven_design_wallet_api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Wallet {
    private String id;
    private String userId;
    private BigDecimal balance;
}
