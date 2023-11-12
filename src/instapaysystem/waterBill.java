package instapaysystem;

import java.util.Random;

public class waterBill extends bill
{
    waterBill()
    {
        type = "water";
        Random random = new Random();
        amount = random.nextFloat((200 - 50) + 1) + 50;
    }
}
