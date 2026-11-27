
import java.util.Scanner;

// HIERARCHICAL INHERITANCE
public class PemesananTiket extends DataPengunjung {

    // ENCAPSULATION
    private int pilih, jumlah, pembayaran;

    // SETTER METHOD
    public void setPilih(int pilih) {
        this.pilih = pilih;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setPembayaran(int pembayaran) {
        this.pembayaran = pembayaran;
    }

    // GETTER METHOD
    public int getPilih() {
        return pilih;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getPembayaran() {
        return pembayaran;
    }

    // METHOD RINCIAN PEMBAYARAN
    public void rincianPembayaran() {
        int harga = 0;
        String wahana = "";

        // CONTROL STATEMENT
        switch (getPilih()) {
            case 1:
                wahana = "Komidi Putar";
                harga = 25000;
                break;
            case 2:
                wahana = "Bianglala";
                harga = 40000;
                break;
            case 3:
                wahana = "Waterpark";
                harga = 60000;
                break;
            default:
                System.out.println("Pilihan wahana salah!");
                return;
        }

        if (getJumlah() <= 0) {
            System.out.println("Jumlah tiket tidak valid!");
            return;
        }

        // EKSPRESI DAN DISKON
        int total = harga * getJumlah();
        int diskon = 0;

        if (getJumlah() >= 5) {
            diskon = total * 10 / 100;
        }

        int bayar = total - diskon;

        // OUTPUT RINCIAN
        System.out.println("\n================================");
        System.out.println("       RINCIAN PEMBAYARAN");
        System.out.println("================================");
        System.out.println("Wahana          : " + wahana);
        System.out.println("Harga tiket     : Rp" + harga);
        System.out.println("Jumlah tiket    : " + getJumlah());
        System.out.println("Total harga     : Rp" + total);
        System.out.println("Diskon          : Rp" + diskon);
        System.out.println("Total yang harus dibayar: Rp" + bayar);
        System.out.println("================================");
    }

    // METHOD STRUK PEMESANAN
    public void cetakStruk() {
        int harga = 0;
        String wahana = "";

        switch (getPilih()) {
            case 1:
                wahana = "Komidi Putar";
                harga = 25000;
                break;
            case 2:
                wahana = "Bianglala";
                harga = 40000;
                break;
            case 3:
                wahana = "Waterpark";
                harga = 60000;
                break;
            default:
                return;
        }

        int total = harga * getJumlah();
        int diskon = 0;

        if (getJumlah() >= 5) {
            diskon = total * 10 / 100;
        }

        int bayar = total - diskon;

        // VALIDASI PEMBAYARAN
        if (getPembayaran() < bayar) {
            System.out.println("Uang pembayaran kurang!");
            System.out.println("Kekurangan: Rp"
                    + (bayar - getPembayaran()));
            return;
        }

        int kembalian = getPembayaran() - bayar;

        // OUTPUT STRUK
        System.out.println("\n================================");
        System.out.println("       STRUK PEMESANAN TIKET");
        System.out.println("================================");
        System.out.println("Nama pengunjung : " + getNama());
        System.out.println("Wahana          : " + wahana);
        System.out.println("Harga tiket     : Rp" + harga);
        System.out.println("Jumlah tiket    : " + getJumlah());
        System.out.println("Total harga     : Rp" + total);
        System.out.println("Diskon          : Rp" + diskon);
        System.out.println("Total bayar     : Rp" + bayar);
        System.out.println("Uang pembayaran : Rp" + getPembayaran());
        System.out.println("Kembalian       : Rp" + kembalian);
        System.out.println("================================");
        System.out.println("   PEMESANAN BERHASIL!");
        System.out.println("       TERIMA KASIH");
        System.out.println("================================");
    }

    // FUNCTION AND PARAMETER
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // OBJECT
        PemesananTiket tiket = new PemesananTiket();

        System.out.println("================================");
        System.out.println("      PEMESANAN TIKET WAHANA");
        System.out.println("================================");

        System.out.print("Nama pengunjung: ");
        tiket.setNama(input.nextLine());

        System.out.println("\nDaftar Wahana:");
        System.out.println("1. Komidi Putar Rp25000");
        System.out.println("2. Bianglala     Rp40000");
        System.out.println("3. Waterpark     Rp60000");

        System.out.print("Pilih wahana: ");
        tiket.setPilih(input.nextInt());

        System.out.print("Jumlah tiket: ");
        tiket.setJumlah(input.nextInt());

        tiket.rincianPembayaran();

        System.out.print("\nUang pembayaran: Rp");
        tiket.setPembayaran(input.nextInt());

        tiket.cetakStruk();

        input.close();
    }
}
