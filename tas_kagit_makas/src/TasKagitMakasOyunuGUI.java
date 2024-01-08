import javax.swing.JOptionPane;
import java.util.Random;

public class TasKagitMakasOyunuGUI {

    public static void main(String[] args) {
        while (true) {
            int secim = JOptionPane.showOptionDialog(
                    null,
                    "Lütfen oyun modunu seçin:",
                    "Oyun Modu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Normal Mod", "İmkansız Mod", "Oyundan Çık"},
                    "Normal Mod"
            );

            if (secim == 0) {
                oyunuOynatNormalMod();
            } else if (secim == 1) {
                oyunuOynatImkansizMod();
            } else {
                JOptionPane.showMessageDialog(null, "Oyunu kapattınız. İyi günler!");
                break;
            }

            int devamSecimi = JOptionPane.showConfirmDialog(null, "Tekrar oynamak ister misiniz?", "Tekrar Oyna", JOptionPane.YES_NO_OPTION);

            if (devamSecimi != JOptionPane.YES_OPTION) {
                break;
            }
        }
    }

    private static void oyunuOynatNormalMod() {
        String[] secenekler = {"Taş", "Kağıt", "Makas"};
        String kullaniciSecimi = (String) JOptionPane.showInputDialog(null, "Taş, Kağıt, Makas oyununa hoş geldiniz!\nLütfen seçiminizi yapın:", "Oyun", JOptionPane.PLAIN_MESSAGE, null, secenekler, secenekler[0]);

        if (kullaniciSecimi == null) {
            System.exit(0);
        }

        String bilgisayarSecimi = rastgeleSecimYap(secenekler);

        JOptionPane.showMessageDialog(null, "Bilgisayarın seçimi: " + bilgisayarSecimi);

        String sonuc = oyunuDegerlendir(kullaniciSecimi.toLowerCase(), bilgisayarSecimi.toLowerCase());
        JOptionPane.showMessageDialog(null, sonuc, "Sonuç", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void oyunuOynatImkansizMod() {
        String[] secenekler = {"Taş", "Kağıt", "Makas"};
        String kullaniciSecimi = (String) JOptionPane.showInputDialog(null, "İmkansız Mod!\nLütfen seçiminizi yapın:", "Oyun", JOptionPane.PLAIN_MESSAGE, null, secenekler, secenekler[0]);

        if (kullaniciSecimi == null) {
            System.exit(0);
        }

        String bilgisayarSecimi = imkansizModSecimYap(secenekler, kullaniciSecimi.toLowerCase());

        JOptionPane.showMessageDialog(null, "Bilgisayarın seçimi: " + bilgisayarSecimi);

        String sonuc = oyunuDegerlendir(kullaniciSecimi.toLowerCase(), bilgisayarSecimi.toLowerCase());
        JOptionPane.showMessageDialog(null, sonuc, "Sonuç", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String rastgeleSecimYap(String[] secenekler) {
        int index = new Random().nextInt(secenekler.length);
        return secenekler[index];
    }

    private static String imkansizModSecimYap(String[] secenekler, String kullaniciSecimi) {
        return kullaniciSecimi;
    }

    private static String oyunuDegerlendir(String kullanici, String bilgisayar) {
        if (kullanici.equals(bilgisayar)) {
            return "Berabere.";
        } else if ((kullanici.equals("taş") && bilgisayar.equals("makas")) ||
                (kullanici.equals("kağıt") && bilgisayar.equals("taş")) ||
                (kullanici.equals("makas") && bilgisayar.equals("kağıt"))) {
            return "Şanslı günündesin evlat.";
        } else {
            return "Beni asla yenemezsin.";
        }
    }
}
