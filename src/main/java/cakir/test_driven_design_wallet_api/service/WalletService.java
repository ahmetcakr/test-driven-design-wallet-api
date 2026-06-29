package cakir.test_driven_design_wallet_api.service;

import cakir.test_driven_design_wallet_api.model.dto.WalletDTO;
import cakir.test_driven_design_wallet_api.model.entity.Wallet;

import java.math.BigDecimal;

public class WalletService {
    public Wallet createWallet(WalletDTO request) {
        return new Wallet("wallet-id", request.getUserId(), BigDecimal.ZERO);
    }

    public Wallet deposit(Wallet wallet, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        BigDecimal newBalance = wallet.getBalance().add(amount);
        wallet.setBalance(newBalance);
        return wallet;
    }
}
