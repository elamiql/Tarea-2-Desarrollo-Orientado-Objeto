package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class RetrasoTest {
    Retraso retraso;

    @BeforeEach
    void setUp() {
        Empleado agustin = new Empleado("217", "Salgado", "Agustin", "agsalgado2023@udec.cl");
        Instant horaPrevista = Instant.now();
        retraso = new Retraso(agustin,Instant.now(),horaPrevista);
    }

    @test
    public void TestRetraso(){

    }

    @AfterEach
    void tearDown() {
    }
}