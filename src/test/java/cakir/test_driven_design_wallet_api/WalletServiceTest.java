package cakir.test_driven_design_wallet_api;

import cakir.test_driven_design_wallet_api.model.dto.WalletDTO;
import cakir.test_driven_design_wallet_api.model.entity.Wallet;
import cakir.test_driven_design_wallet_api.repository.WalletRepository;
import cakir.test_driven_design_wallet_api.service.impl.WalletServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

    @Mock
    private WalletRepository walletRepository;

    @InjectMocks
    private WalletServiceImpl walletService;

//    /**
//     * Red Test: WalletService is not implemented yet, so this test will fail.
//     */
//    @Test
//    void shouldCreateWalletWithZeroBalance(){
//        WalletService walletService = new WalletService();
//        WalletDTO request = new WalletDTO("user111");
//
//        Wallet response = walletService.createWallet(request);
//
//        assertThat(response.getBalance()).isEqualTo(BigDecimal.ZERO);
//        assertThat(response.getUserId()).isEqualTo("user111");
//    }

    /**
     * Green Test: after implementing the WalletService, this test will pass.
     */
    @Test
    void shouldCreateWalletWithZeroBalance(){
        WalletDTO request = new WalletDTO("user111");
        Wallet savedWallet = new Wallet("wallet123", "user111", BigDecimal.ZERO);

        when(walletRepository.save(any(Wallet.class))).thenReturn(savedWallet);

        Wallet response = walletService.createWallet(request);

        assertThat(response.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(response.getUserId()).isEqualTo("user111");
        assertThat(response.getId()).isNotNull();
    }


//    /**
//     * Red Test: Deposit functionality is not implemented yet, so this test will fail.
//     */
//    @Test
//    void shouldDepositMoneySuccessfully(){
//        Wallet wallet = new Wallet("wallet-id", "user111", new BigDecimal(100));
//        BigDecimal depositAmount = new BigDecimal(50);
//
//        Wallet updatedWallet = walletService.deposit(wallet, depositAmount);
//
//        assertThat(updatedWallet.getBalance()).isEqualTo(new BigDecimal(150));
//    }
//
//    @Test
//    void shouldThrowExceptionWhenDepositAmountIsNegative(){
//        Wallet wallet = new Wallet("wallet-id", "user111", new BigDecimal(100));
//        BigDecimal depositAmount = new BigDecimal(-50);
//
//        assertThatThrownBy(() -> walletService.deposit(wallet, depositAmount))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("Deposit amount must be positive");
//    }


    /**
     * Green Test: after implementing the deposit functionality, this test will pass.
     */
    @Test
    void shouldDepositMoneySuccessfully(){
        Wallet wallet = new Wallet("wallet-id", "user111", new BigDecimal(100));
        BigDecimal depositAmount = new BigDecimal(50);

        when(walletRepository.save(any(Wallet.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Wallet updatedWallet = walletService.deposit(wallet, depositAmount);

        assertThat(updatedWallet.getBalance()).isEqualTo(new BigDecimal(150));
    }

    @Test
    void shouldThrowExceptionWhenDepositAmountIsNegative(){
        Wallet wallet = new Wallet("wallet-id", "user111", new BigDecimal(100));
        BigDecimal depositAmount = new BigDecimal(-50);

        assertThatThrownBy(() -> walletService.deposit(wallet, depositAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Deposit amount must be positive");
    }


//    /**
//     * Red Test: before implementing the withdraw functionality, this test will fail.
//     */
//    @Test
//    void shouldWithdrawMoneySuccessfully(){
//        Wallet wallet = new Wallet("wallet-id", "user111", new BigDecimal(100));
//        BigDecimal withdrawAmount = new BigDecimal(50);
//
//        Wallet updatedWallet = walletService.withdraw(wallet, withdrawAmount);
//
//        assertThat(updatedWallet.getBalance()).isEqualTo(new BigDecimal(50));
//    }
//
//    @Test
//    void shouldThrowExceptionWhenWithdrawAmountIsNegative(){
//        Wallet wallet = new Wallet("wallet-id", "user111", new BigDecimal(100));
//        BigDecimal withdrawAmount = new BigDecimal(-50);
//
//        assertThatThrownBy(() -> walletService.withdraw(wallet, withdrawAmount))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("Withdraw amount must be positive");
//    }
//
//    @Test
//    void shouldThrowExceptionWhenWithdrawAmountExceedsBalance() {
//        Wallet wallet = new Wallet("wallet-id", "user111", new BigDecimal(100));
//        BigDecimal withdrawAmount = new BigDecimal(150);
//
//        assertThatThrownBy(() -> walletService.withdraw(wallet, withdrawAmount))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("Insufficient balance");
//    }

    /**
     * Green Test: after implementing the withdraw functionality, this test will pass.
     */
    @Test
    void shouldWithdrawMoneySuccessfully(){
        Wallet wallet = new Wallet("wallet-id", "user111", new BigDecimal(100));
        BigDecimal withdrawAmount = new BigDecimal(50);

        when(walletRepository.save(any(Wallet.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Wallet updatedWallet = walletService.withdraw(wallet, withdrawAmount);

        assertThat(updatedWallet.getBalance()).isEqualTo(new BigDecimal(50));
    }

    @Test
    void shouldThrowExceptionWhenWithdrawAmountIsNegative(){
        Wallet wallet = new Wallet("wallet-id", "user111", new BigDecimal(100));
        BigDecimal withdrawAmount = new BigDecimal(-50);

        assertThatThrownBy(() -> walletService.withdraw(wallet, withdrawAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Withdraw amount must be positive");
    }

    @Test
    void shouldThrowExceptionWhenWithdrawAmountExceedsBalance() {
        Wallet wallet = new Wallet("wallet-id", "user111", new BigDecimal(100));
        BigDecimal withdrawAmount = new BigDecimal(150);

        assertThatThrownBy(() -> walletService.withdraw(wallet, withdrawAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Insufficient balance");
    }

}
