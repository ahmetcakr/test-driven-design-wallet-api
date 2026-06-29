package cakir.test_driven_design_wallet_api.repository;

import cakir.test_driven_design_wallet_api.model.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {
    Wallet findByUserId(String userId);
}
