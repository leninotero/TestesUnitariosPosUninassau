import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestContaTest {
    Conta conta;

    @BeforeEach
    void init(){
        conta = new Conta();
    }

    @Test
    @DisplayName("TC001 - Testes de Consulta de Saldo")
    void testDeveMostrarSaldoInicialZero() {
        double valorEsperado = 0.00;
        assertEquals(valorEsperado, conta.getSaldo());
    }

    @Test
    @DisplayName("TC002 - Testes de Deposito")
    void testDeveDepositarValor() {
        double valorEsperado = 100.00;
        conta.depositarValor(100.00);
        assertEquals(valorEsperado, conta.getSaldo());
    }

    @Nested
    @DisplayName("TC003 - Testes de Saque")
    class TestesDeSaque {
        @Test
        @DisplayName("TC003-01 - Testes de Saque sem sucesso")
        void testeValidarSaldoInsuficienteParaSaque() {
            String valorEsperado = "Saldo Insuficiente";
            conta.sacarValor(100.00);
            assertEquals(valorEsperado, conta.sacarValor(100.00));
        }

        @Test
        @DisplayName("TC003-02 - Teste de Saque com sucesso")
        void testValidarSaqueRealizadoComSucessoParaSaque() {
            String valorEsperado = "Saque realizado com sucesso";
            conta.depositarValor(100.00);
            //        assertEquals(valorEsperado, conta.sacarValor(50.00));
            assertAll(
                    () -> assertEquals(valorEsperado, conta.sacarValor(20.00)),
                    () -> assertEquals(valorEsperado, conta.sacarValor(20.00)),
                    () -> assertEquals(valorEsperado, conta.sacarValor(20.00)),
                    () -> assertEquals(valorEsperado, conta.sacarValor(20.00)),
                    () -> assertEquals(valorEsperado, conta.sacarValor(20.00))
            );
        }
    }
}