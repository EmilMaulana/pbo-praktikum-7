/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tugas_7;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class TUGAS_7 {

    public static void main(String[] args) {
        // Inisialisasi data barang
        String[][] dataBarang = {
                {"001", "Pensil", "2000"},
                {"002", "Buku", "5000"},
                {"003", "Pulpen", "3000"},
                // Tambahkan data barang sesuai kebutuhan
        };

        // Inputan dari pengguna
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah barang yang akan dibeli: ");
        int jumlahBeli = scanner.nextInt();

        // Inisialisasi array untuk menyimpan detail pembelian
        String[][] detailPembelian = new String[jumlahBeli][4];

        // Input detail pembelian
        for (int i = 0; i < jumlahBeli; i++) {
            System.out.println("\nMasukkan detail barang ke-" + (i + 1));
            System.out.print("Kode Barang: ");
            String kodeBarang = scanner.next();
            System.out.print("Jumlah Beli: ");
            int jumlah = scanner.nextInt();

            // Temukan nama barang dan harga berdasarkan kode
            String[] detailBarang = getDetailBarang(dataBarang, kodeBarang);
            String namaBarang = detailBarang[0];
            String harga = detailBarang[1];

            // Simpan detail pembelian
            detailPembelian[i][0] = Integer.toString(i + 1);
            detailPembelian[i][1] = kodeBarang;
            detailPembelian[i][2] = namaBarang;
            detailPembelian[i][3] = Integer.toString(jumlah);
        }

        // Output header tabel
        System.out.printf("%-4s%-12s%-15s%-10s%-12s%-12s\n", "No", "Kode Barang", "Nama Barang", "Harga", "Jumlah Beli", "Jumlah Bayar");
        System.out.println("-------------------------------------------------------------");

        // Output detail pembelian dalam bentuk tabel
        int totalBayar = 0;
        for (String[] detail : detailPembelian) {
            int harga = Integer.parseInt(getHargaBarang(dataBarang, detail[1]));
            int jumlah = Integer.parseInt(detail[3]);
            int jumlahBayar = harga * jumlah;
            totalBayar += jumlahBayar;

            System.out.printf("%-4s%-12s%-15s%-10s%-12s%-12s\n",
                    detail[0], detail[1], detail[2], getHargaBarang(dataBarang, detail[1]), detail[3], jumlahBayar);
        }

        // Output total bayar
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-39s%-12s\n", "Total Bayar", totalBayar);
    }

    // Method untuk mendapatkan detail barang berdasarkan kode
    private static String[] getDetailBarang(String[][] dataBarang, String kode) {
        for (String[] data : dataBarang) {
            if (data[0].equals(kode)) {
                return new String[]{data[1], data[2]};
            }
        }
        return new String[]{"", "0"};
    }

    // Method untuk mendapatkan harga barang berdasarkan kode
    private static String getHargaBarang(String[][] dataBarang, String kode) {
        for (String[] data : dataBarang) {
            if (data[0].equals(kode)) {
                return data[2];
            }
        }
        return "0";
    }
}
