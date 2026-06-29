package cakir.test_driven_design_wallet_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class WalletServiceTest {

    /**
     * Red Test: WalletService is not implemented yet, so this test will fail.
     */
    @Test
    void shouldCreateWalletWithZeroBalance(){
        WalletService walletService = new WalletService();
        WalletDTO request = new WalletDTO("user111");

        Wallet response = walletService.createWallet(request);

        assertThat(response.getBalance()).isEqualTo(BigDecimal.ZERO);
        assertThat(response.getUserId()).isEqualTo("user111");
    }
}
