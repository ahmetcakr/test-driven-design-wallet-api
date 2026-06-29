package cakir.test_driven_design_wallet_api.controller;

import cakir.test_driven_design_wallet_api.model.dto.WalletDTO;
import cakir.test_driven_design_wallet_api.model.entity.Wallet;
import cakir.test_driven_design_wallet_api.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/create")
    public ResponseEntity<Wallet> createWallet(@RequestBody WalletDTO request){
        Wallet wallet = walletService.createWallet(request);
        return new ResponseEntity<>(wallet, HttpStatus.CREATED);
    }
}
