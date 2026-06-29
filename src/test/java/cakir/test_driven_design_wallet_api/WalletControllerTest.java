package cakir.test_driven_design_wallet_api;

import cakir.test_driven_design_wallet_api.controller.WalletController;
import cakir.test_driven_design_wallet_api.model.dto.WalletDTO;
import cakir.test_driven_design_wallet_api.model.entity.Wallet;
import cakir.test_driven_design_wallet_api.service.WalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WalletController.class)
class WalletControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private WalletService walletService;

    /**
     * Red Test: WalletController is not implemented yet, so this test will fail.
     */
    @Test
    void shouldReturnCreatedWallet() throws Exception{
        WalletDTO request = new WalletDTO("user111");

        /**
         * we need to mock the service layer, because we are not testing the service layer here, we are testing the controller layer.
         * we assume that the service layer is working correctly, and we are testing the controller layer.
         */
        Wallet mockWallet = new Wallet("wallet-123", "user111", BigDecimal.ZERO);

        when(walletService.createWallet(any(WalletDTO.class))).thenReturn(mockWallet);

        mockMvc.perform(post("/api/v1/wallets/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("wallet-123"))
                .andExpect(jsonPath("$.userId").value("user111"))
                .andExpect(jsonPath("$.balance").value(0));
    }
}
