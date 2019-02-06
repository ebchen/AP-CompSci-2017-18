
public class WalletTester
{
    public static void main (String [] args)
    {
        //StudentIDCard idCard = new StudentIDCard("Eric Chen", "62347");
        ATMCard atmCard = new ATMCard ("Eric Chen", "123010239", "1234");
        DriverLicense license = new DriverLicense("Eric Chen", 2015);
        Wallet wallet = new Wallet();
        wallet.addCard(atmCard);
        wallet.addCard(license);
        System.out.println(wallet);
        System.out.println(license.isExpired());
        
        System.out.println("Number of expired cards: " + wallet.getExpiredCardCount());
    }
}
