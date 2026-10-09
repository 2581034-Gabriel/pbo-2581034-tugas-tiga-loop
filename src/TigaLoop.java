import java.util.Scanner;

/*
 * Tugas : Tiga Loop, Satu Deret
 * Class : TigaLoop
 *
 * ============================================================
 * KELUARAN PROGRAM (disalin dari hasil menjalankan program)
 * ============================================================
 *
 * Dijalankan pertama, n = 5
 * -------------------------
 * Batas deret (n) : 5
 *
 * ===== SATU DERET, TIGA LOOP =====
 * for      : 1 2 3 4 5
 * while    : 1 2 3 4 5
 * do-while : 1 2 3 4 5
 *
 * i <  n berputar : 4 kali
 * i <= n berputar : 5 kali
 * Disaring : 1 3 5 7
 * Sampai println  : 4 kali
 *
 * Dijalankan kedua, n = 0
 * -------------------------
 * Batas deret (n) : 0
 *
 * ===== SATU DERET, TIGA LOOP =====
 * for      :
 * while    :
 * do-while : 1
 *
 * i <  n berputar : 0 kali
 * i <= n berputar : 0 kali
 * Disaring : 1 3 5 7
 * Sampai println  : 4 kali
 *
 * Kenapa dua baris pertama kosong, tapi baris ketiga tidak?
 * for dan while mengecek kondisinya SEBELUM putaran pertama. Dengan n = 0,
 * kondisi 1 <= 0 sudah false sejak awal, jadi badan loopnya tidak pernah
 * dijalankan. do-while menjalankan badannya lebih dulu (mencetak 1), baru
 * mengecek kondisinya (2 <= 0 -> false) lalu berhenti.
 *
 * Kesimpulan: do-while mengecek kondisinya sesudah badan loop dijalankan,
 * jadi badannya pasti jalan minimal sekali.
 */
public class TigaLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Batas deret (n) : ");
        int n = input.nextInt();

        System.out.println();
        System.out.println("===== SATU DERET, TIGA LOOP =====");

        // ===== Tiga versi deret 1..n, masing-masing dengan pencacahnya sendiri =====

        // Versi 1: for (pencacahnya i)
        // Kondisi i <= n dicek SEBELUM putaran pertama.
        System.out.print("for      :");
        for (int i = 1; i <= n; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        // Versi 2: while (pencacahnya j)
        // Sama seperti for: kondisi j <= n dicek SEBELUM putaran pertama.
        // Yang berubah tiap putaran adalah j (lewat j++), dan kondisinya
        // jadi false begitu j lebih besar dari n.
        System.out.print("while    :");
        int j = 1;
        while (j <= n) {
            System.out.print(" " + j);
            j++;
        }
        System.out.println();

        // Versi 3: do-while (pencacahnya k)
        // Badan dijalankan dulu, kondisi k <= n baru dicek SESUDAHNYA,
        // jadi badan pasti jalan minimal sekali (n = 0 pun tetap mencetak 1).
        System.out.print("do-while :");
        int k = 1;
        do {
            System.out.print(" " + k);
            k++;
        } while (k <= n);
        System.out.println();

        // ===== Bukti meleset satu (off-by-one) =====
        // Selisih satu karakter (< lawan <=) berarti selisih satu putaran penuh.
        // Dengan n = 5 hasilnya 4 dan 5.
        int kurang = 0;
        for (int i = 1; i < n; i++) {
            kurang++;
        }
        int kurangSama = 0;
        for (int i = 1; i <= n; i++) {
            kurangSama++;
        }
        System.out.println();
        System.out.println("i <  n berputar : " + kurang + " kali");
        System.out.println("i <= n berputar : " + kurangSama + " kali");

        // ===== Saringan deret 1..10 dengan continue dan break =====
        // Memakai angka tetap 1..10 (tidak ikut n) supaya hasilnya bisa
        // dicocokkan langsung dengan contoh: 1 3 5 7 dan penghitung 4.
        /*
         * Kenapa loop tidak berhenti di i = 8, padahal 8 sudah lebih besar dari 7?
         * Karena continue (lewati genap) ditulis SEBELUM break. Saat i = 8, kondisi
         * i % 2 == 0 bernilai true, jadi continue langsung melompat ke pengubah i++
         * dan baris if (i > 7) tidak pernah dibaca untuk i = 8. Pengecekan i > 7
         * baru kena pada angka ganjil berikutnya, yaitu i = 9, dan di situlah break
         * dijalankan. Jadi loop ini sebenarnya berhenti di i = 9, bukan di i = 8.
         *
         *   i = 7 -> ganjil, 7 > 7 false -> dicetak (penghitung jadi 4)
         *   i = 8 -> genap -> continue, break tidak ikut dicek
         *   i = 9 -> ganjil, 9 > 7 true  -> break
         *
         * Kalau urutannya ditukar (break dulu, baru continue), loop berhenti di i = 8.
         */
        int sampaiPrintln = 0;
        System.out.print("Disaring :");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (i > 7) {
                break;
            }
            System.out.print(" " + i);
            sampaiPrintln++;
        }
        System.out.println();
        System.out.println("Sampai println  : " + sampaiPrintln + " kali");

        input.close();
    }
}