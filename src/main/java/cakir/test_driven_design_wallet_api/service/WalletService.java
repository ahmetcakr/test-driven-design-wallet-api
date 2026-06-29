package cakir.test_driven_design_wallet_api.service;

import cakir.test_driven_design_wallet_api.model.dto.WalletDTO;
import cakir.test_driven_design_wallet_api.model.entity.Wallet;

import java.math.BigDecimal;

public interface WalletService {

    Wallet createWallet(WalletDTO request);

    Wallet deposit(Wallet wallet, BigDecimal amount);

    Wallet withdraw(Wallet wallet, BigDecimal amount);
}
