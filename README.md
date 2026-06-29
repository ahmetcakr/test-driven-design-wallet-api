# Test Driven Design Wallet Api

TDD süreçlerini uygulamak amacıyla geliştirilmiş bakiye yönetimi projesidir.

### Teknolojiler
* Java 21 & Spring Boot 3
* Spring Data JPA & H2 Database
* JUnit 5 & AssertJ
* Mockito & Lombok

* **WalletService:** Veritabanı bağımlılıkları Mockito ile taklit edilerek iş kuralları ve hesaplamalar birim testlerle doğrulanmıştır.
* **WalletController:** `@WebMvcTest` kullanılarak sadece HTTP istek/yanıt yönetimi ve JSON dönüşümleri test edilmiştir.

### Uygulanan İş Kuralları
* **Cüzdan Oluşturma:** Yeni cüzdanlar sıfır bakiye ile başlatılır.
* **Para Yatırma (Deposit):** Sıfır ve negatif tutarlar reddedilir, geçerli tutarlarda bakiye artırılır.
* **Para Çekme (Withdraw):** Yetersiz bakiye veya geçersiz tutarlarda işlem engellenir, geçerli durumlarda bakiye düşürülür.

### Testlerin Çalıştırılması
```bash
mvn clean test