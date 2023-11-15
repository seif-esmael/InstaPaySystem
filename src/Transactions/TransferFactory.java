package Transactions;

public class TransferFactory {
    public Transfer createTransferTransaction(String input)
    {
        if(input.equals("tobank")){
            return new toBankTransfer();
        }
        if(input.equals("towallet")){
            return new toWalletTransfer();
        }
        if(input.equals("toinstapay")){
            return new toInstaPayTransfer();
        }
        return null;

    }
}
