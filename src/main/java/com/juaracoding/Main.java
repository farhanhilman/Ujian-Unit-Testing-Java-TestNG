package com.juaracoding;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000);

        //Perulangan untuk kembali ke menu utama setelah pengguna bertransaksi dan berhenti ketika pengguna memilih opsi keluaar
        while (true){
            System.out.println("==================================");
            System.out.print("Ketik opsi yang ingin anda pilih: \n1. Cek Saldo \n2. Setor Tunai \n3. Tarik Tunai \n4. Keluar \nSilahkan Masukkan opsi: ");
            int opsi = scanner.nextInt();

            //Percabangan untuk memilih opsi transaksi dengan menginput angka: input 1 untuk cek saldo, input 2 untuk setor uang, input 3 untuk tarik uang dan input 4 untuk keluar.
            if (opsi == 1){
                System.out.println("Saldo anda saat ini: ");
                System.out.println(atm.lihatSaldo());
            }
            else if (opsi == 2) {
                System.out.print("Masukkan Jumlah Setoran: ");
                double setoranUang = scanner.nextDouble();
                atm.setorUang(setoranUang);
                System.out.println("Saldo anda saat ini: " + atm.lihatSaldo());
            }
            else if (opsi == 3) {
                System.out.print("Masukkan Jumlah Penarikan: ");
                double penarikanUang = scanner.nextDouble();
                atm.tarikUang(penarikanUang);
                System.out.println("Saldo anda saat ini: " + atm.lihatSaldo());
            }
            else if (opsi == 4){
                System.out.println("Terimakasih telah bertransaksi :)");
                break;
            }
            else {
                System.out.println("Pilihan anda tidak valid silahkan ulangi");
            }
        }
    }
}