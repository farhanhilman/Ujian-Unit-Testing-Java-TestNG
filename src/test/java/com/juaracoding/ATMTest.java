package com.juaracoding;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMTest {

    ATM atm;

    //Melakukan inisialisai objek ATM dengan saldo awal 1000
    @BeforeMethod
    public void setUp(){
        double saldoAwal = 1000;
        atm = new ATM(saldoAwal);
    }


    //Menguji apakah metode lihatSaldo() mengembalikan saldo yang benar.
    @Test
    public void testLihatSaldo(){
        double expected = 1000;
        double actual = atm.lihatSaldo();
        Assert.assertEquals(actual, expected);
    }

    //Menguji apakah metode setorUang() berfungsi dengan benar ketika jumlah yang valid disetor.
    @Test
    public void testSetorUang(){
        double expected = 6000;
        double jumlahSetoran = 5000;
        atm.setorUang(jumlahSetoran);
        Assert.assertEquals(atm.lihatSaldo(), expected);
    }

    //Menguji apakah metode setorUang() melempar pengecualian ketika jumlah yang negatif disetor.
    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Jumlah harus lebih besar dari 0")
    public void testSetorUangNegatif(){
        double jumlahSetoran = -500;
        atm.setorUang(jumlahSetoran);
    }

    //Menguji apakah metode tarikUang() berfungsi dengan benar ketika jumlah yang valid ditarik.
    @Test
    public void testTarikUang(){
        double expected = 500;
        double jumlahPenarikan = 500;
        atm.tarikUang(jumlahPenarikan);
        Assert.assertEquals(atm.lihatSaldo(), expected);
    }

    // Menguji apakah metode tarikUang() melempar pengecualian ketika jumlah yang ditarik melebihi saldo saat ini.
    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Saldo tidak mencukupi")
    public void testTarikUangLebihDariSaldo(){
        double jumlahPenarikan = 5000;
        atm.tarikUang(jumlahPenarikan);
    }

    // Menguji apakah metode tarikUang() melempar pengecualian ketika jumlah yang negatif ditarik.
    @Test (expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Jumlah harus lebih besar dari 0")
    public void testTarikUangNegatif(){
        double jumlahPenarikan = -500;
        atm.tarikUang(jumlahPenarikan);
    }

}
